package com.brs.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.BeanUtils;

import com.brs.dao.ImgsDaoI;
import com.brs.dao.UsersDaoI;
import com.brs.model.Imgs;
import com.brs.model.Users;
import com.brs.pagemodel.PageUsers;
import com.brs.service.UsersServiceI;
import com.brs.utils.GConfig;
import com.brs.utils.GUtils;

public class UsersService implements UsersServiceI{
	//声明usersDao
	private UsersDaoI usersDao;

	public void setUsersDao(UsersDaoI usersDao) {
		this.usersDao = usersDao;
	}
	
	//声明imgsDao
	private ImgsDaoI imgsDao;

	public void setImgsDao(ImgsDaoI imgsDao) {
		this.imgsDao = imgsDao;
	}
	
	/**
	 * 新增一条用户记录
	 */
	@Override
	public void add(PageUsers pageModel) throws Exception {
		File targetFile = null;
		//获取服务器的图片保存目录
		String imgDirPath = GConfig.getProps().getProperty("imgsPath").toString();
		//查询数据库是否存在该记录
		String hql = "from Users where userId = :userId";
		Map<String, Object> parameters = GUtils.getMap(new String[]{"userId"}, new Object[]{pageModel.getUserId()});
		Users user = usersDao.getByHql(hql,parameters);
		
		if(null != user){
			//判断该记录的状态,1或-1抛出异常，其他情况删除该记录并删除对应的img
			if(user.getStatus()==1||user.getStatus()==-1){
				throw new Exception ("该用户已存在！");
			}else{
				//删除无效用户记录
				usersDao.delete(user);
				//删除无效图片记录
				imgsDao.delete(user.getImgs());
				//删除服务器文件目录下的图片
				targetFile = new File(imgDirPath+"/"+user.getImgs().getImgId()+".png");
				GUtils.deleteFile(targetFile);
			}
			
		}
		//实例化user(除了插入可以new一个新对象,其他操作要获取数据库对象)
		user = new Users();
		try {
			BeanUtils.copyProperties(pageModel,user);
			/*
			 * 写入数据库,自动生成一个无意义的36位id
			 */
			String uuid = UUID.randomUUID().toString();
			
			//1表示存在租赁未删除状态,-1表示不存在租赁未删除状态，0表示删除状态
			user.setStatus(-1);
			//设置Imgs参数,用随机生成的uuid作为路径
			Imgs img = new Imgs();
			img.setImgId(uuid);
			img.setPath(uuid+".png");
			//写入img
			imgsDao.save(img);
			//imgs表必须存在该图片,users表才可调用
			user.setImgs(img);
			//写入Users 注意：img必须比Users先执行save；
			usersDao.save(user);
			
			/*
			 * 写入文件到服务器磁盘
			 */
			//生成File对象,并写入(服务器+图片)路径
			targetFile = new File(imgDirPath+"/"+uuid+".png");
			//执行写入操作(从磁盘写入到服务器)
			writeFileToDisk(pageModel.getFile(),targetFile);
		} catch (Exception e) {
			e.printStackTrace();
			GUtils.deleteFile(targetFile);
		}
		
	}
	/**
	 * 写入文件
	 * @param sorceFile
	 * @param targetFile
	 */
	private void writeFileToDisk(File sorceFile,File targetFile){
		try {
			byte[] data = IOUtils.toByteArray(new FileInputStream(sorceFile));
			FileOutputStream output = new FileOutputStream(targetFile);
			IOUtils.write(data, output);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 更新一条用户记录
	 */
	@Override
	public void edit(PageUsers pageModel) throws Exception {
		File targetFile = null;
		//获取服务器的图片保存目录
		String imgDirPath = GConfig.getProps().getProperty("imgsPath").toString();
		//初始化User(除了插入可以new一个新对象,其他操作要获取数据库对象)
		Users user = usersDao.get(Users.class, pageModel.getUserId());
		try {
			//拷贝对象 注意:所有公共属性都会被覆盖
			BeanUtils.copyProperties(pageModel,user);
			//查询图片ID
			String uuid = user.getImgs().getImgId();
			//重置status
			user.setStatus(-1);
			//更新Users
			usersDao.saveOrUpdate(user);
			
			/*
			 * 写入文件到服务器磁盘
			 */
			//文件为空时不执行写入操作
			if(null != pageModel.getFile()){
				//生成File对象,并写入(服务器+图片)路径
				targetFile = new File(imgDirPath+"/"+uuid+".png");
				//执行写入操作,覆盖原文件(从磁盘写入到服务器)
				writeFileToDisk(pageModel.getFile(),targetFile);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			GUtils.deleteFile(targetFile);
		}
	}
	
	/**
	 * 查询表中所有记录
	 */
	@Override
	public List<PageUsers> list() throws Exception {
		String hql = "from Users where status != 0 order by sex desc";
		//初始化一个Map对象
		Map<String, Object> parameters = null;
		//获取列表
		List<Users> us = usersDao.queryByHql(hql,parameters, 0, 0);
		/**
		 * 设置页面显示需要属性
		 */
		//copy集合List<Users> -> List<PageUsers>
		List<PageUsers> listPage = GUtils.copyProList(PageUsers.class,us);
		//设置imgId
		for (int i = 0; i < us.size(); i++) {
			//获取当前Users
			Users u = us.get(i);
			//获取当前PageUsers
			PageUsers pu = listPage.get(i);
			//设置imgId
			pu.setImgId(u.getImgs().getImgId());
		}
		
		return listPage;
	}
	
	/**
	 * 查询一条用户记录
	 */
	@Override
	public void details(PageUsers pageModel) throws Exception {
		
		Users user = usersDao.get(Users.class, pageModel.getUserId());
		//拷贝公共属性
		BeanUtils.copyProperties(user, pageModel); 
		//设置图片id
		String imgId = user.getImgs().getImgId();
		pageModel.setImgId(imgId);
		
	}
	
	/**
	 * 删除一条用户记录
	 */
	@Override
	public void del(PageUsers pageModel) throws Exception {
		Users user = usersDao.get(Users.class, pageModel.getUserId());
		//判断status是否为1(存在租赁且未删除状态)
		if(user.getStatus() == 1){
			throw new Exception ("删除失败！该用户租赁了自行车！");
			
		}else{
			//若为-1将status设为0(删除状态)
			user.setStatus(0);
			usersDao.saveOrUpdate(user);
			
		}
			
	}
	
	/**
	 * 搜索用户信息
	 */
	@Override
	public List<PageUsers> search(String searchCon) throws Exception {
		
		String hql = "from Users where status != 0 and (userId like :searchCon or name like :searchCon or password like :searchCon or sex like :searchCon or tel like :searchCon or email like :searchCon)";
		//初始化一个Map对象
		Map<String, Object> parameters = GUtils.getMap(new String[]{"searchCon"}, new Object[]{"%"+searchCon+"%"});
		//获取列表
		List<Users> us = usersDao.queryByHql(hql,parameters, 0, 0);
		/**
		 * 设置页面显示需要属性
		 */
		//copy集合List<Users> -> List<PageUsers>
		List<PageUsers> listPage = GUtils.copyProList(PageUsers.class,us);
		//设置imgId
		for (int i = 0; i < us.size(); i++) {
			//获取当前Users
			Users u = us.get(i);
			//获取当前PageUsers
			PageUsers pu = listPage.get(i);
			//设置imgId
			pu.setImgId(u.getImgs().getImgId());
		}
		return listPage;
	}


}

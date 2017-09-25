package com.brs.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.BeanUtils;

import com.brs.dao.BicycleDaoI;
import com.brs.dao.ImgsDaoI;
import com.brs.model.Bicycle;
import com.brs.model.Imgs;
import com.brs.pagemodel.PageBicycle;
import com.brs.service.BicycleServiceI;
import com.brs.utils.GConfig;
import com.brs.utils.GUtils;

public class BicycleService implements BicycleServiceI{
	//声明bicycleDao
	private BicycleDaoI bicycleDao;

	public void setBicycleDao(BicycleDaoI bicycleDao) {
		this.bicycleDao = bicycleDao;
	}
	
	//声明imgsDao
	private ImgsDaoI imgsDao;

	public void setImgsDao(ImgsDaoI imgsDao) {
		this.imgsDao = imgsDao;
	}
	
	/**
	 * 新增一条bicycle记录
	 */
	@Override
	public void add(PageBicycle pageModel) throws Exception {
		File targetFile = null;
		//获取服务器的图片保存目录
		String imgDirPath = GConfig.getProps().getProperty("imgsPath").toString();
		//查询数据库是否存在该记录
		String hql = "from Bicycle where type = :type";
		Map<String, Object> parameters = GUtils.getMap(new String[]{"type"}, new Object[]{pageModel.getType()});
		Bicycle bicycle = bicycleDao.getByHql(hql,parameters);
		
		if(null != bicycle){
			//判断该记录的状态,1或-1抛出异常，其他情况删除该记录并删除对应的img
			if(bicycle.getStatus()==1||bicycle.getStatus()==-1){
				throw new Exception ("该种类已存在！");
			}else{
				//删除无效记录
				bicycleDao.delete(bicycle);
				//删除无效图片记录
				imgsDao.delete(bicycle.getImgs());
				//删除服务器文件目录下的图片
				targetFile = new File(imgDirPath+"/"+bicycle.getImgs().getImgId()+".png");
				GUtils.deleteFile(targetFile);
			}
		}
		
		//实例化bicycle(除了插入可以new一个新对象,其他操作要获取数据库对象)
		bicycle = new Bicycle();
		try {

			BeanUtils.copyProperties(pageModel,bicycle);
			/*
			 * 写入数据库,自动生成一个无意义的id
			 */
			String uuid = UUID.randomUUID().toString();
			//设置Bicycle参数
			bicycle.setBicId(uuid);
			//-1表示闲置未删除
			bicycle.setStatus(-1);
			//设置Imgs参数
			Imgs img = new Imgs();
			img.setImgId(uuid);
			img.setPath(uuid+".png");
			//写入img
			imgsDao.save(img);
			//imgs表必须存在该图片,users表才可调用
			bicycle.setImgs(img);
			
			//写入Bicycle 注意：img必须比Bicycle先执行save；
			bicycleDao.save(bicycle);
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
	 * 更新一条bicycle记录
	 */
	@Override
	public void edit(PageBicycle pageModel) throws Exception {
		File targetFile = null;
		//获取服务器的图片保存目录
		String imgDirPath = GConfig.getProps().getProperty("imgsPath").toString();
		
		//获取原自行车类型
		String tp = bicycleDao.get(Bicycle.class, pageModel.getBicId()).getType();
		
		//查询数据库是否存在该记录
		String hql = "from Bicycle where type = :type";
		Map<String, Object> parameters = GUtils.getMap(new String[]{"type"}, new Object[]{pageModel.getType()});
		Bicycle bicycle = bicycleDao.getByHql(hql,parameters);
		
		//保持类型唯一,并判断是否是无效记录(类型没有修改则跳过)
		if(null != bicycle && !bicycle.getType().equals(tp)){
			
			//判断该记录的状态,1或-1抛出异常，其他情况删除该记录并删除对应的img
			if(bicycle.getStatus()==1||bicycle.getStatus()==-1){ //有效记录
				
				throw new Exception ("该种类已存在！");
			}else{  //无效记录
				
				//删除无效记录
				bicycleDao.delete(bicycle);
				//删除无效图片记录
				imgsDao.delete(bicycle.getImgs());
				//删除服务器文件目录下的图片
				targetFile = new File(imgDirPath+"/"+bicycle.getImgs().getImgId()+".png");
				GUtils.deleteFile(targetFile);
			}
		}
		
		//初始化Bicycle(除了插入可以new一个新对象,其他操作要获取数据库对象)
		bicycle = bicycleDao.get(Bicycle.class, pageModel.getBicId());
		
		try {
			
			//拷贝对象 注意:所有公共属性都会被覆盖
			BeanUtils.copyProperties(pageModel,bicycle);
			//查询图片ID
			String uuid = bicycle.getImgs().getImgId();
			//更新Bicycle
			bicycleDao.saveOrUpdate(bicycle);
			
			/*
			 * 写入文件到服务器磁盘
			 */
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
	public List<PageBicycle> list() throws Exception {
		String hql = "from Bicycle where status != 0 order by status desc";
		Map<String, Object> parameters = null;
		//获取列表
		List<Bicycle> bs = bicycleDao.queryByHql(hql,parameters, 0, 0);
		/**
		 * 设置页面显示需要属性
		 */
		//copy集合
		List<PageBicycle> listPage = GUtils.copyProList(PageBicycle.class,bs);
		//设置imgId
		for (int i = 0; i < bs.size(); i++) {
			//获取当前Bicycle
			Bicycle b = bs.get(i);
			//获取当前PageBicycle
			PageBicycle pb = listPage.get(i);
			//设置imgId
			pb.setImgId(b.getImgs().getImgId());
		}
		
		return listPage;
	}
	
	/**
	 * 查询一条用户记录
	 */
	@Override
	public void details(PageBicycle pageModel) throws Exception {
		
		Bicycle bicycle = bicycleDao.get(Bicycle.class, pageModel.getBicId());
		//拷贝公共属性
		BeanUtils.copyProperties(bicycle, pageModel); 
		//设置图片id
		String imgId = bicycle.getImgs().getImgId();
		pageModel.setImgId(imgId);
		
	}
	
	/**
	 * 删除一条用户记录
	 */
	@Override
	public void del(PageBicycle pageModel) throws Exception {
		Bicycle bicycle = bicycleDao.get(Bicycle.class, pageModel.getBicId());
		//判断status是否为1(租赁中)
		if(bicycle.getStatus() == 1){
			throw new Exception ("删除失败！该种类自行车租赁中！");
		}else{
			//若为-1(闲置状态)将status设为0(删除状态)
			bicycle.setStatus(0);
			bicycleDao.saveOrUpdate(bicycle);
		}
			
	}
	
	/**
	 * 搜索自行车记录
	 */
	@Override
	public List<PageBicycle> search(String searchCon) throws Exception {
		//初始化hql
		String hql = "";
		//初始化parameters
		Map<String, Object> parameters = null;
		
		if(searchCon.equals("热门")){  //如果搜索内容为自行车状态
			hql = "from Bicycle where status = 1";
		}else if(searchCon.equals("闲置")) {  //如果搜索内容为自行车状态
			hql = "from Bicycle where status = -1";
		}else{  //其他情况
			hql = "from Bicycle where status != 0 and (type like :searchCon or price like :searchCon) order by status desc";
			parameters = GUtils.getMap(new String[]{"searchCon"}, new Object[]{"%"+searchCon+"%"});
		}
		
		//获取列表
		List<Bicycle> bs = bicycleDao.queryByHql(hql,parameters, 0, 0);
		/**
		 * 设置页面显示需要属性
		 */
		//copy集合
		List<PageBicycle> listPage = GUtils.copyProList(PageBicycle.class,bs);
		//设置imgId
		for (int i = 0; i < bs.size(); i++) {
			//获取当前Bicycle
			Bicycle b = bs.get(i);
			//获取当前PageBicycle
			PageBicycle pb = listPage.get(i);
			//设置imgId
			pb.setImgId(b.getImgs().getImgId());
		}
		
		return listPage;
	}

}

package com.brs.service.impl;

import javax.servlet.Servlet;

import org.springframework.beans.BeanUtils;

import com.brs.dao.AdminsDaoI;
import com.brs.model.Admins;
import com.brs.pagemodel.PageAdmins;
import com.brs.service.AdminsServiceI;
import com.opensymphony.xwork2.ActionContext;
import com.brs.utils.GActionUtils;

public class AdminsService implements AdminsServiceI{
	//声明adminsDao
	private AdminsDaoI adminsDao;
	
	public void setAdminsDao(AdminsDaoI adminsDao) {
		this.adminsDao = adminsDao;
	}



	/**
	 * 登录
	 */
	@Override
	public PageAdmins login(PageAdmins pageModel) throws Exception {
		//获取Admins对象
		Admins adm = adminsDao.get(Admins.class, pageModel.getAdminId());
		//如果账号不存在
		if(null == adm||adm.getStatus()==0){
			throw new Exception("该管理员不存在");
		}
		//如果密码错误
		if(!adm.getPassword().equals(pageModel.getPassword())){
			throw new Exception("密码错误");
		}
		//复制数据库记录属性
		BeanUtils.copyProperties(adm, pageModel);
		return pageModel;
	}

	/**
	 * 注册
	 */
	@Override
	public void register(PageAdmins pageModel) throws Exception {
		Admins adm = adminsDao.get(Admins.class, pageModel.getAdminId());
		//如果账号存在
		if(null != adm){
			if(adm.getStatus() == 1){  //有效用户
				throw new Exception ("该管理员已存在");
			}else {  //无效用户
				//删除无效用户
				adminsDao.delete(adm);
			}
			
		}
		//初始化adm
		adm = new Admins();
		//copy公共属性
		BeanUtils.copyProperties(pageModel, adm);
		//保存该用户到数据库
		adminsDao.save(adm);
	}


	/**
	 * 修改密码
	 */
	@Override
	public void edit(PageAdmins pageModel) throws Exception {
		//获取session对象中的参数(静态方法调用需要加类名,继承除外)
		PageAdmins adm = (PageAdmins) GActionUtils.getSessionAttr("adm");
		//如果管理员不在线
		if(null == adm){
			throw new Exception("该管理员不在线");
		}
		//判断密码二次输入是否正确
		if(!pageModel.getPassword().equals(pageModel.getPassword2()) ){
			throw new Exception("二次输入密码不一致");
		}
		
		//初始化一个管理员对象
		Admins admin = adminsDao.get(Admins.class, adm.getAdminId());
		//重置密码
		admin.setPassword(pageModel.getPassword());
		//更新该管理员的数据库记录
		adminsDao.saveOrUpdate(admin);
	}
	
}

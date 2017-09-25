package com.brs.service;

import com.brs.pagemodel.PageAdmins;

public interface AdminsServiceI {
	/**
	 * 登录
	 * @param pageModel
	 * @return 
	 */
	PageAdmins login(PageAdmins pageModel) throws Exception;
	/**
	 * 注册
	 * @param pageModel
	 * @throws Exception
	 */
	void register(PageAdmins pageModel) throws Exception;
	/**
	 * 修改密码
	 * @param pageModel
	 * @throws Exception
	 */
	void edit(PageAdmins pageModel) throws Exception;
	
}

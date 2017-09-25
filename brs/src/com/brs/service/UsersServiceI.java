package com.brs.service;

import java.util.List;

import com.brs.pagemodel.PageUsers;

public interface UsersServiceI {

	/**
	 * 上传一个user
	 * @param pageModel
	 * @return 
	 */
	void add(PageUsers pageModel) throws Exception;
	/**
	 * 打印列表
	 * @return
	 * @throws Exception
	 */
	List<PageUsers> list() throws Exception;
	/**
	 * 查看一条用户记录
	 * @param pageModel
	 * @throws Exception
	 */
	void details(PageUsers pageModel) throws Exception;
	/**
	 * 删除一条用户记录
	 * @param pageModel
	 * @throws Exception
	 */
	void del(PageUsers pageModel) throws Exception;
	/**
	 * 修改一条用户记录
	 * @param pageModel
	 * @return 
	 */
	void edit(PageUsers pageModel) throws Exception;
	/**
	 * 搜索用户记录
	 * @param searchCon
	 * @return
	 */
	List<PageUsers> search(String searchCon) throws Exception;
	
}

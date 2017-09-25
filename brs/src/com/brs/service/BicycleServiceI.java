package com.brs.service;

import java.util.List;

import com.brs.pagemodel.PageBicycle;

public interface BicycleServiceI {
	/**
	 * 上传一个bicycle
	 * @param pageModel
	 * @return 
	 */
	void add(PageBicycle pageModel) throws Exception;
	/**
	 * 打印列表
	 * @return
	 * @throws Exception
	 */
	List<PageBicycle> list() throws Exception;
	/**
	 * 查看一条bicycle记录
	 * @param pageModel
	 * @throws Exception
	 */
	void details(PageBicycle pageModel) throws Exception;
	/**
	 * 删除一条bicycle记录
	 * @param pageModel
	 * @throws Exception
	 */
	void del(PageBicycle pageModel) throws Exception;
	/**
	 * 修改一条bicycle记录
	 * @param pageModel
	 * @throws Exception
	 */
	void edit(PageBicycle pageModel) throws Exception;
	/**
	 * 搜索自行车记录
	 * @param searchCon
	 * @return
	 * @throws Exception
	 */
	List<PageBicycle> search(String searchCon) throws Exception;


	
}

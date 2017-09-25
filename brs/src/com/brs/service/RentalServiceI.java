package com.brs.service;

import java.util.List;

import com.brs.pagemodel.PageRental;

public interface RentalServiceI {
	/**
	 * 查询所有记录
	 * @return
	 * @throws Exception
	 */
	List<PageRental> list() throws Exception;
	/**
	 * 添加一条订单记录
	 * @param pageModel
	 * @throws Exception
	 */
	void add(PageRental pageModel) throws Exception;
	/**
	 * 查询一条订单记录
	 * @param pageModel
	 * @throws Exception
	 */
	void details(PageRental pageModel) throws Exception;
	/**
	 * 修改一条订单记录
	 * @param pageModel
	 * @throws Exception
	 */
	void edit(PageRental pageModel) throws Exception;
	/**
	 * 删除一条订单记录
	 * @param pageModel
	 * @throws Exception
	 */
	void del(PageRental pageModel) throws Exception;
	/**
	 * 搜索订单记录
	 * @param searchCon
	 * @return
	 * @throws Exception
	 */
	List<PageRental> search(String searchCon) throws Exception;
	
}

package com.brs.action;

import java.io.File;
import java.util.List;

import com.brs.pagemodel.PageUsers;
import com.brs.service.UsersServiceI;
import com.brs.utils.GConfig;
import com.opensymphony.xwork2.ModelDriven;

public class UsersAction extends BaseAction implements ModelDriven<PageUsers>{
	private PageUsers pageModel = new PageUsers();

	@Override
	public PageUsers getModel() {
		return pageModel;
	}
	
	//声明usersService
	private UsersServiceI usersService;
	public void setUsersService(UsersServiceI usersService) {
		this.usersService = usersService;
	}
	
	/**
	 * 获取列表
	 * @return
	 */
	public String userList(){
		try {
			List<PageUsers> listPage = usersService.list();
			setRequestAttr("userList", listPage);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			setRequestAttr("msg", e.getMessage());
			return "reminder";
		}
	}
	
	/**
	 * 详情
	 * @return
	 */
	public String userDetail(){
		try {
			usersService.details(pageModel);
			
			//详情转发到编辑页面
			setRequestAttr("user", pageModel);
			return "edit";
			
		} catch (Exception e) {
			e.printStackTrace();
			setRequestAttr("msg", e.getMessage());
			return "reminder";
		}
	}
	
	/**
	 * 删除单条记录
	 * @return
	 */
	public String userDel(){
		try {
			usersService.del(pageModel);
			return userList();
		} catch(Exception e){
			e.printStackTrace();
			setRequestAttr("msg", e.getMessage());
			return "reminder";
		}
	}
	
	/**
	 * 修改
	 * @return
	 */
	public String editUser(){
		try {
			usersService.edit(pageModel);
			return userList();
		} catch (Exception e) {
			e.printStackTrace();
			setRequestAttr("msg", e.getMessage());
			return "reminder";
		}
	}
	
	/**
	 * 搜索
	 * @return
	 */
	public String userSearch(){
		try {
			//获取搜索内容,并去除字符串空格
			String searchCon = pageModel.getSearchContent().replaceAll(" ", "");
			
			if(searchCon.equals("")){
				//搜索内容为空则查询所有
				return userList();
			}else {
				List<PageUsers> listPage = usersService.search(searchCon);
				setRequestAttr("userList", listPage);
				return "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
			setRequestAttr("msg", e.getMessage());
			return "reminder";
		}
	}
	
	/**
	 * 上传一个user
	 * @return
	 */
	public String uploadUser(){
		try {
			usersService.add(pageModel);
			return userList();
		} catch (Exception e) {
			e.printStackTrace();
			setRequestAttr("msg", e.getMessage());
			return "reminder";
		}
	}
	/**
	 * 通过img的id获取图片
	 */
	public void getImgByImgId(){
		String imgId = pageModel.getImgId();
		String imgPath = GConfig.getProps().getProperty("imgsPath").toString()+"/"+imgId+".png";
		File imgFile = new File(imgPath);
		//返回图片
		writeImg(imgFile);
	}

	
}

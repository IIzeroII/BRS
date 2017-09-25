package com.brs.action;

import com.brs.pagemodel.PageAdmins;
import com.brs.service.AdminsServiceI;
import com.brs.utils.GReturnJSON;
import com.opensymphony.xwork2.ModelDriven;

public class AdminsAction extends BaseAction implements ModelDriven<PageAdmins>{
	private PageAdmins pageModel = new PageAdmins();

	@Override
	public PageAdmins getModel() {
		return pageModel;
	}
	
	private AdminsServiceI adminsService;

	public AdminsServiceI getAdminsService() {
		return adminsService;
	}

	public void setAdminsService(AdminsServiceI adminsService) {
		this.adminsService = adminsService;
	}
	
	/**
	 * 登录
	 */
	public void login(){
		GReturnJSON retJSON = new GReturnJSON();
		try{
			pageModel = adminsService.login(pageModel);
			retJSON.setMsg("登录成功");
			retJSON.setSuccess(true);
			
			//设置管理员在线状态       
			setSessionAttr("adm",pageModel);
		}catch(Exception e){
			e.printStackTrace();
			retJSON.setMsg(e.getMessage());
			retJSON.setSuccess(false);
		}finally {
			//返回一个json对象
			writeJSON(retJSON);
		}
	}
	
	/**
	 * 注册
	 */
	public void register(){
		GReturnJSON retJSON = new GReturnJSON();
		try{
			adminsService.register(pageModel);
			retJSON.setMsg("注册成功");
			retJSON.setSuccess(true);
		}catch(Exception e){
			e.printStackTrace();
			retJSON.setMsg(e.getMessage());
			retJSON.setSuccess(false);
		}finally {
			//返回一个json对象
			writeJSON(retJSON);
		}
	}
	
	/**
	 * 修改密码
	 */
	public void edit(){
		GReturnJSON retJSON = new GReturnJSON();
		try {
			adminsService.edit(pageModel);
			retJSON.setMsg("修改成功");
			retJSON.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			retJSON.setMsg(e.getMessage());
			retJSON.setSuccess(false);
		}finally {
			//返回一个json对象
			writeJSON(retJSON);
		}
	}
}

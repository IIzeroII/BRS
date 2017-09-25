package com.brs.action;


import java.io.File;
import java.util.List;

import com.brs.pagemodel.PageBicycle;
import com.brs.service.BicycleServiceI;
import com.brs.utils.GConfig;
import com.brs.utils.GReturnJSON;
import com.opensymphony.xwork2.ModelDriven;

public class BicycleAction extends BaseAction implements ModelDriven<PageBicycle>{
	private PageBicycle pageModel = new PageBicycle();

	@Override
	public PageBicycle getModel() {
		return pageModel;
	}
	
	//声明bicycleService
	private BicycleServiceI bicycleService;
	public void setBicycleService(BicycleServiceI bicycleService) {
		this.bicycleService = bicycleService;
	}
	
	/**
	 * 获取列表
	 * @return
	 */
	public String bicycleList(){
		try {
			List<PageBicycle> listPage = bicycleService.list();
			setRequestAttr("bicycleList", listPage);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			setRequestAttr("msg", e.getMessage());
			return "reminder";
		}
	}
	
	/**
	 * 获取列表ajax
	 */
	public void bicycleList_ajax(){
		GReturnJSON retJSON = new GReturnJSON();
		try {
			List<PageBicycle> listPage = bicycleService.list();
			retJSON.setObj(listPage);
			retJSON.setMsg("查询成功！");
			retJSON.setSuccess(true);
		} catch(Exception e){
			e.printStackTrace();
			retJSON.setMsg(e.getMessage());
			retJSON.setSuccess(false);
		}finally {
			//返回一个json对象
			writeJSON(retJSON);
		}
	}
	
	/**
	 * 查看详情
	 * @return
	 */
	public String bicycleDatails(){
		try {
			int op = pageModel.getOp();
			bicycleService.details(pageModel);
			
			if(op == 1){	//转发到编辑页面
				setRequestAttr("bicycle", pageModel);
				return "edit";
			}else {		//转发到详情页面
				setRequestAttr("bicycle", pageModel);
				return "details";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			setRequestAttr("msg", e.getMessage());
			return "reminder";
		}
	}
	
	/**
	 * 删除单条记录ajax未完成
	 */
	public void bicycleDel_ajax(){
		GReturnJSON retJSON = new GReturnJSON();
		try {
			bicycleService.del(pageModel);
			retJSON.setMsg("删除成功！");
			retJSON.setSuccess(true);
		} catch(Exception e){
			e.printStackTrace();
			retJSON.setMsg(e.getMessage());
			retJSON.setSuccess(false);
		}finally {
			//返回一个json对象
			writeJSON(retJSON);
		}
	}
	
	/**
	 * 删除单条记录
	 * @return
	 */
	public String bicycleDel(){
		try {
			bicycleService.del(pageModel);
			return bicycleList();
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
	public String editBicycle(){
		try {
			bicycleService.edit(pageModel);
			return bicycleList();
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
	public String bicycleSearch(){
		try {
			//获取搜索内容,并去除字符串空格
			String searchCon = pageModel.getSearchContent().replaceAll(" ", "");
			if(searchCon.equals("")){
				//搜索内容为空则查询所有
				return bicycleList();
			}else {
				List<PageBicycle> listPage = bicycleService.search(searchCon);
				setRequestAttr("bicycleList", listPage);
				return "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
			setRequestAttr("msg", e.getMessage());
			return "reminder";
		}
	}
	
	/**
	 * 上传一个bicycle
	 * @return
	 */
	public String uploadBicycle(){
		try {
			bicycleService.add(pageModel);
			return bicycleList();
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

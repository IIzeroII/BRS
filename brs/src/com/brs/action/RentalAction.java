package com.brs.action;

import java.io.File;
import java.util.List;

import com.brs.pagemodel.PageRental;
import com.brs.service.RentalServiceI;
import com.brs.utils.GConfig;
import com.opensymphony.xwork2.ModelDriven;

public class RentalAction extends BaseAction implements ModelDriven<PageRental>{
	private PageRental pageModel = new PageRental();

	@Override
	public PageRental getModel() {
		return pageModel;
	}
	//声明rentalService
	private RentalServiceI rentalService;
	public void setRentalService(RentalServiceI rentalService) {
		this.rentalService = rentalService;
	}
	
	
	/**
	 * 上传一个订单
	 * @return
	 */
	public String uploadRental(){
		try {
			rentalService.add(pageModel);
			return rentalList();
		} catch (Exception e) {
			e.printStackTrace();
			setRequestAttr("msg", e.getMessage());
			return "reminder";
		}
	}
	
	/**
	 * 获取列表
	 * @return
	 */
	public String rentalList(){
		try {
			List<PageRental> listPage = rentalService.list();
			setRequestAttr("rentalList", listPage);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			setRequestAttr("msg", e.getMessage());
			return "reminder";
		}
	}
	
	/**
	 * 查看详情
	 * @return
	 */
	public String rentalDatails(){
		try {
			int op = pageModel.getOp();
			rentalService.details(pageModel);
			
			if(op == 1){	//转发到编辑页面
				setRequestAttr("rental", pageModel);
				return "edit";
			}else {		//转发到详情页面
				setRequestAttr("rental", pageModel);
				return "details";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			setRequestAttr("msg", e.getMessage());
			return "reminder";
		}
	}
	
	/**
	 * 修改
	 * @return
	 */
	public String editRental(){
		try {
			rentalService.edit(pageModel);
			return rentalList();
		} catch (Exception e) {
			e.printStackTrace();
			setRequestAttr("msg", e.getMessage());
			return "reminder";
		}
	}
	
	/**
	 * 删除
	 * @return
	 */
	public String rentalDel(){
		try {
			rentalService.del(pageModel);
			return rentalList();
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
	public String rentalSearch(){
		try {
			//获取搜索内容,并去除字符串空格
			String searchCon = pageModel.getSearchContent().replaceAll(" ", "");
			if(searchCon.equals("")){
				//搜索内容为空则查询所有
				return rentalList();
			}else {
				List<PageRental> listPage = rentalService.search(searchCon);
				setRequestAttr("rentalList", listPage);
				return "success";
			}
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
		//初始化imgId
		String imgId = "";
		String userImgId = pageModel.getUserImgId();
		String bicycleImgId = pageModel.getBicycleImgId();
		//判断是用户图片还是自行车图片
		if(null != userImgId){
			imgId = userImgId;
		}else if(null != bicycleImgId){
			imgId = bicycleImgId;
		}
		String imgPath = GConfig.getProps().getProperty("imgsPath").toString()+"/"+imgId+".png";
		File imgFile = new File(imgPath);
		//返回图片
		writeImg(imgFile);
	}
}

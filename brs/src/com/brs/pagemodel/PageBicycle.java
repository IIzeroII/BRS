package com.brs.pagemodel;

import java.io.File;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.brs.model.Imgs;
import com.brs.model.Rental;

public class PageBicycle implements Serializable{
	private String bicId;
	private String type;
	private int price;
	private int status;
	
	private int op;
	
	//搜索内容
	private String searchContent;
	
	private String imgPath;
	private String imgId;
	
	//注意，file并不是指前端jsp上传过来的文件本身，而是文件上传过来存放在临时文件夹下面的文件
    private File file;
    //提交过来的file的名字
    private String fileFileName;
    //提交过来的file的MIME类型
    private String fileContentType;
	public String getBicId() {
		return bicId;
	}
	public void setBicId(String bicId) {
		this.bicId = bicId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getOp() {
		return op;
	}
	public void setOp(int op) {
		this.op = op;
	}
	public String getSearchContent() {
		return searchContent;
	}
	public void setSearchContent(String searchContent) {
		this.searchContent = searchContent;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public String getImgId() {
		return imgId;
	}
	public void setImgId(String imgId) {
		this.imgId = imgId;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	public PageBicycle() {
		super();
	}
	public PageBicycle(String bicId, String type, int price, int status, int op, String searchContent, String imgPath,
			String imgId, File file, String fileFileName, String fileContentType) {
		super();
		this.bicId = bicId;
		this.type = type;
		this.price = price;
		this.status = status;
		this.op = op;
		this.searchContent = searchContent;
		this.imgPath = imgPath;
		this.imgId = imgId;
		this.file = file;
		this.fileFileName = fileFileName;
		this.fileContentType = fileContentType;
	}
	@Override
	public String toString() {
		return "PageBicycle [bicId=" + bicId + ", type=" + type + ", price=" + price + ", status=" + status + ", op="
				+ op + ", searchContent=" + searchContent + ", imgPath=" + imgPath + ", imgId=" + imgId + ", file="
				+ file + ", fileFileName=" + fileFileName + ", fileContentType=" + fileContentType + "]";
	}

	
}

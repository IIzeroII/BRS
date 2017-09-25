package com.brs.pagemodel;

import java.io.File;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.brs.model.Imgs;
import com.brs.model.Rental;

public class PageUsers implements Serializable{
	private String userId;
	private String name;
	private String password;
	private String sex;
	private String tel;
	private String email;
	private int status;
	
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
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
	public PageUsers() {
		super();
	}
	public PageUsers(String userId, String name, String password, String sex, String tel, String email, int status,
			String searchContent, String imgPath, String imgId, File file, String fileFileName,
			String fileContentType) {
		super();
		this.userId = userId;
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.tel = tel;
		this.email = email;
		this.status = status;
		this.searchContent = searchContent;
		this.imgPath = imgPath;
		this.imgId = imgId;
		this.file = file;
		this.fileFileName = fileFileName;
		this.fileContentType = fileContentType;
	}
	@Override
	public String toString() {
		return "PageUsers [userId=" + userId + ", name=" + name + ", password=" + password + ", sex=" + sex + ", tel="
				+ tel + ", email=" + email + ", status=" + status + ", searchContent=" + searchContent + ", imgPath="
				+ imgPath + ", imgId=" + imgId + ", file=" + file + ", fileFileName=" + fileFileName
				+ ", fileContentType=" + fileContentType + "]";
	}
    
}

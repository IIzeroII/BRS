var loginBtn;
var adminId;
var password;

$(function($){
	//初始化dom节点
	initLoginDoms();
	//设置监听事件
	setLoginList();
	//设置界面样式
	setLoginUI();
});
/**
 * 初始化dom节点
 */
function initLoginDoms(){
	loginBtn = $("#loginBtn");
	adminId = $("#adminId");
	password = $("#password");
}
/**
 * 设置监听事件
 */
function setLoginList(){
	//登录点击监听事件
	setLoginBtnClickLis();
}
/**
 * 登录点击监听事件
 */
function setLoginBtnClickLis(){
	//移除该元素的所有事件处理程序
	loginBtn.unbind("click");
	loginBtn.click(function(){
		//打开加载界面
		showLoadingModel(0, function(){
			var url = "/adminsAction!login.action";
			var jsonData = new Object();
			jsonData["adminId"] = adminId.val();
			jsonData["password"] = password.val();
			zxAjaxData(url, jsonData, function(data){
				//登錄成功
				if(data.success){
					
					self.location= getWebProjectName()+'/brs/jsp/index.jsp';
				}
				//登陸失敗
				else{
					showMsgWin(undefined,data.msg,0);
				}
				//隐藏加载界面
				hideLoadingModel(0);
			},true);
		})
		
	});
}


/**
 * 设置界面样式
 */
function setLoginUI(){
	
}
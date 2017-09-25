var registerBtn;
var adminId;
var password;
var password2;
$(function($){
	//初始化dom节点
	initRegisterDoms();
	//设置监听事件
	setRegisterList();
	//设置界面样式
	setRegisterUI();
});
/**
 * 初始化dom节点
 */
function initRegisterDoms(){
	registerBtn = $("#registerBtn");
	adminId = $("#adminId");
	password = $("#password");
	password2 = $("#password2");
}
/**
 * 设置监听事件
 */
function setRegisterList(){
	//注册点击监听事件
	setRegisterBtnClickLis();
}
/**
 * 注册点击监听事件
 */
function setRegisterBtnClickLis(){
	//移除该元素的所有事件处理程序
	registerBtn.unbind("click");
	
	registerBtn.click(function(){
		showLoadingModel(0, function(){
			var url = "/adminsAction!register.action";
			//默认状态为未删除
			var status = 1;
			var jsonData = new Object();
			
			//判断二次输入密码是否一致
			if(password.val()!=password2.val()){
				hideLoadingModel(0);
				showMsgWin(undefined,"二次输入密码不一致！",0);
				return;
			}
			jsonData["adminId"] = adminId.val();
			jsonData["password"] = password.val();
			jsonData["status"] = status;
			zxAjaxData(url, jsonData, function(data){
				//隐藏加载界面
				hideLoadingModel(0);
				//显示提示
				showMsgWin(undefined,data.msg,0);
			},true);
		})
		
	});
}


/**
 * 设置界面样式
 */
function setRegisterUI(){
	
}
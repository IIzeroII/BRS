$(function(){
    //菜单点击
    J_iframe
    $(".J_menuItem").on('click',function(){
        var url = $(this).attr('href');
        $("#J_iframe").attr('src',url);
        return false;
    });
});

var editBtn;
var password;
var password2;

$(function($){
	//初始化dom节点
	initIndexDoms();
	//设置监听事件
	setIndexList();
	//设置界面样式
	setRegisterUI();
});
/**
 * 初始化dom节点
 */
function initIndexDoms(){
	editBtn = $("#editBtn");
	password = $("#password");
	password2 = $("#password2");
}
/**
 * 设置监听事件
 */
function setIndexList(){
	//重置密码点击监听事件
	setEditBtnClickLis();
}
/**
 * 重置密码点击监听事件
 */
function setEditBtnClickLis(){
	editBtn.click(function(){
		var url = "/adminsAction!edit.action";
		var jsonData = new Object();
		
		jsonData["password"] = password.val();
		jsonData["password2"] = password2.val();
		zxAjaxData(url, jsonData, function(data){
			//显示提示
			showMsgWin(undefined,data.msg,0);
		},true);
	});
};

/**
 * 设置界面样式
 */
function setRegisterUI(){
	
}
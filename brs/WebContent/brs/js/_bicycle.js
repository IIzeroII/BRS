var delBtn;
var searchBtn;
var loadingBtn;
var stas;
var bicId;
var bicType;
var bicImgId;
var price;

$(function($){
	//初始化dom节点
	initBicycleDoms();
	//设置监听事件
	setBicycleList();
	//设置界面样式
	setBicycleUI();
	//判断状态
	judgeStatus();
});
/**
 * 初始化dom节点
 */
function initBicycleDoms(){
	delBtn = $(".delBtn");
	searchBtn = $("#searchBtn");
	loadingBtn = $("#loadingBtn");
	bicId = $(".bicId");
	bicType = $(".bicType");
	bicImgId = $(".bicImgId");
	price = $(".price");
	stas = $(".stas");
}

/**
 * 设置bicycle状态
 */
function judgeStatus(){
	//遍历所有节点
	stas.each(function(){
		var sta = $(this);
		//判断节点状态,1为热门,2为闲置
		if(sta.html() == 1){ 
			sta.html("热门");
			/*label-primary，label-default*/
			sta.removeClass("label-default").addClass("label-primary");
		}else{
			sta.html("闲置");
			sta.removeClass("label-primary").addClass("label-default");
		}
	});
	
}
/**
 * 设置监听事件
 */
function setBicycleList(){
	/*//删除按钮点击监听事件
	setDelBtnClickLis();
	//搜索按钮点击监听事件
	setSearchBtnClickLis();
	//刷新按钮点击监听事件
	setLoadingBtnClickLis();*/

}

/**
 * 设置界面样式
 */
function setBicycleUI(){
	
}
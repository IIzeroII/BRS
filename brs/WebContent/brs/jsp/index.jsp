<%@ page language="java" import="java.util.*" pageEncoding="Utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.brs.model.*" %>
<%@ page autoFlush="true" buffer="1094kb"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="renderer" content="webkit">

<title> Bicycle Rental System- 主页</title>

<meta name="keywords" content="">
<meta name="description" content="">

<!--[if lt IE 9]>
<meta http-equiv="refresh" content="0;ie.jsp" />
<![endif]-->

<link rel="shortcut icon" href="favicon.ico">
<link href="<c:url value='/brs/css/bootstrap.min.css?v=3.3.6'></c:url>" rel="stylesheet">
<link href="<c:url value='/brs/css/font-awesome.min.css?v=4.4.0'></c:url>" rel="stylesheet">
<link href="<c:url value='/brs/css/animate.css'></c:url>" rel="stylesheet">
<link href="<c:url value='/brs/css/style-h.css?v=4.1.0'></c:url>" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="<c:url value='/brs/css/_msgWin.css'></c:url>" />
</head>

<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
	
	<!-- 导入弹窗 -->
	<jsp:include page="./msgWin.jsp"></jsp:include>
	
    <div id="wrapper">
        <!--左侧导航开始-->
        <nav class="navbar-default navbar-static-side" role="navigation">
            <div class="nav-close"><i class="fa fa-times-circle"></i>
            </div>
            <div class="sidebar-collapse">
                <ul class="nav" id="side-menu">
                	
                    <!--nav-header开始-->
                    <li class="nav-header">
                        <div class="dropdown profile-element">
                            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                <span class="clear">
                                    <span class="block m-t-xs" style="font-size:20px;">
                                        <i class="fa fa-area-chart"></i>
                                        <strong class="font-bold">Bicycle Rental System</strong>
                                    </span>
                                </span>
                            </a>
                        </div>
                        <div class="logo-element">BRS
                        </div>
                    </li>
                    <!--nav-header结束-->
                   
                   <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
                        <span class="ng-scope">自行车租赁管理系统</span>
                    </li>
                    <li>
                        <a class="J_menuItem" href="<c:url value='/rentalAction!rentalList.action'></c:url>">
                            <i class="fa fa-home"></i>
                            <span class="nav-label">主页</span>
                        </a>
                    </li>
                    <li>
                        <a class="J_menuItem" href="<c:url value='/bicycleAction!bicycleList.action'></c:url>" > 
                            <i class="fa fa-bicycle"></i>
                            <span class="nav-label">自行车管理</span>
                        </a>
                    </li>
                    <li>
                        <a class="J_menuItem" href="<c:url value='/usersAction!userList.action'></c:url>">
                            <i class="fa fa-user"></i>
                            <span class="nav-label">用户管理</span>
                        </a>
                    </li>
                    <li class="line dk"></li>
                    
                    <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
                        <span class="ng-scope">分类</span>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-flask"></i> <span class="nav-label">UI元素</span><span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li><a class="J_menuItem" href="#">排版</a>
                            </li>
                            <li>
                                <a href="#">字体图标 <span class="fa arrow"></span></a>
                                <ul class="nav nav-third-level">
                                    <li>
                                        <a class="J_menuItem" href="#">Font Awesome</a>
                                    </li>
                                    <li>
                                        <a class="J_menuItem" href="#">Glyphicon</a>
                                    </li>
                                    <li>
                                        <a class="J_menuItem" href="#">阿里巴巴矢量图标库</a>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <a href="#">拖动排序 <span class="fa arrow"></span></a>
                                <ul class="nav nav-third-level">
                                    <li><a class="J_menuItem" href="#">拖动面板</a>
                                    </li>
                                    <li><a class="J_menuItem" href="#">任务清单</a>
                                    </li>
                                </ul>
                            </li>
                            <li><a class="J_menuItem" href="#">按钮</a>
                            </li>
                            <li><a class="J_menuItem" href="#">选项卡 &amp; 面板</a>
                            </li>
                            <li><a class="J_menuItem" href="#">通知 &amp; 提示</a>
                            </li>
                            <li><a class="J_menuItem" href="#">徽章，标签，进度条</a>
                            </li>
                            <li>
                                <a class="J_menuItem" href="#">栅格</a>
                            </li>
                            <li><a class="J_menuItem" href="#">视频、音频</a>
                            </li>
                            <li>
                                <a href="#">弹框插件 <span class="fa arrow"></span></a>
                                <ul class="nav nav-third-level">
                                    <li><a class="J_menuItem" href="#">Web弹层组件layer</a>
                                    </li>
                                    <li><a class="J_menuItem" href="#">模态窗口</a>
                                    </li>
                                    <li><a class="J_menuItem" href="#">SweetAlert</a>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <a href="#">树形视图 <span class="fa arrow"></span></a>
                                <ul class="nav nav-third-level">
                                    <li><a class="J_menuItem" href="#">jsTree</a>
                                    </li>
                                    <li><a class="J_menuItem" href="#">Bootstrap Tree View</a>
                                    </li>
                                    <li><a class="J_menuItem" href="#">nestable</a>
                                    </li>
                                </ul>
                            </li>
                            <li><a class="J_menuItem" href="#">Toastr通知</a>
                            </li>
                            <li><a class="J_menuItem" href="#">文本对比</a>
                            </li>
                            <li><a class="J_menuItem" href="#">加载动画</a>
                            </li>
                            <li><a class="J_menuItem" href="#">小部件</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">
                            <i class="fa fa fa-bar-chart-o"></i>
                            <span class="nav-label">统计图表</span>
                            <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a class="J_menuItem" href="#">百度ECharts</a>
                            </li>
                            <li>
                                <a class="J_menuItem" href="#">Flot</a>
                            </li>
                            <li>
                                <a class="J_menuItem" href="#">Morris.js</a>
                            </li>
                            <li>
                                <a class="J_menuItem" href="#">Rickshaw</a>
                            </li>
                            <li>
                                <a class="J_menuItem" href="#">Peity</a>
                            </li>
                            <li>
                                <a class="J_menuItem" href="#">Sparkline</a>
                            </li>
                            <li>
                                <a class="J_menuItem" href="#">图表组合</a>
                            </li>
                        </ul>
                    </li>
                    <li class="line dk"></li>
                    <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
                        <span class="ng-scope">分类</span>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-picture-o"></i> <span class="nav-label">相册</span><span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li><a class="J_menuItem" href="#">基本图库</a>
                            </li>
                            <li><a class="J_menuItem" href="#">图片切换</a>
                            </li>
                            <li><a class="J_menuItem" href="#">Blueimp相册</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a class="J_menuItem" href="#"><i class="fa fa-magic"></i> <span class="nav-label">CSS动画</span></a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-cutlery"></i> <span class="nav-label">工具 </span><span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li><a class="J_menuItem" href="#">表单构建器</a>
                            </li>
                        </ul>
                    </li>

                </ul>
            </div>
        </nav>
        <!--左侧导航结束-->
        <!--右侧部分开始-->
        <div id="page-wrapper" class="gray-bg dashbard-1">
            <div class="row border-bottom">
                <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                    <div class="navbar-header">
                    	<a class="navbar-minimalize minimalize-styl-2 btn btn-info " href="#"><i class="fa fa-bars"></i> </a>
                        <!--<form role="search" class="navbar-form-custom" method="post" action="#">
                            <div class="form-group">
                                <input type="text" placeholder="请输入您需要查找的内容 …" class="form-control" name="top-search" id="top-search">
                            </div>
                        </form>-->
                    </div>
                    <ul class="nav navbar-top-links navbar-right">
                   		<li class="notification-menu">
	                        <a href="#" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
	                            <img src="<c:url value='/brs/img/user-avatar.png'></c:url>" alt=""/>
	                            Admin
	                            <span class="caret"></span>
	                        </a>
	                        <ul class="dropdown-menu dropdown-menu-usermenu pull-right">
	                            <li><a href="#modal-form" data-toggle="modal"><i class="fa fa-cog"></i>  Settings</a></li>
	                            <li><a href="login.jsp"><i class="fa fa-sign-out"></i> Log Out</a></li>
	                        </ul>
	                    </li>
                    </ul>
                </nav>
            </div>
            <!-- 动态内容开始 -->
            <div class="row J_mainContent" id="content-main">
                <iframe name="J_iframe" id="J_iframe" width="100%" height="100%" src="<c:url value='/rentalAction!rentalList.action'></c:url>" frameborder="0"  data-id="rental.jsp" seamless></iframe>
            </div>
            <!-- 动态内容结束 -->
        </div>
        <!--右侧部分结束-->
    </div>
    
    <!--弹窗开始-->
    <div id="modal-form" class="modal fade" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-body">
                    <div class="row">
                        <div class="b-r">
                            <h3 class="m-t-none m-b">重置密码</h3>
                            <form role="form" >
                            	<div class="form-group">
	                                <label class="control-label">密码</label>
	
	                                <div>
	                                    <input id="password"   type="password" placeholder="请输入密码"  class="form-control" >
	                                </div>
                            	</div>
                            	<div class="form-group">
	                                <label class="control-label">重复密码</label>
	
	                                <div>
	                                    <input id="password2" type="password" placeholder="请再次输入密码"  class="form-control">
	                                </div>
                            	</div>
                                <div class="form-group">
	                                <div class="col-sm-offset-5">
	                                    <button id="editBtn" class="btn btn-primary" type="button" data-dismiss="modal">确定</button>
	                                    <button  class="btn btn-default" type="button" data-dismiss="modal">取消</button>
	                                </div>
                            	</div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
	<!--弹窗结束-->

    <!-- 全局js -->
    <script src="<c:url value='/brs/js/jquery.min.js?v=2.1.4'></c:url>"></script>
    <script src="<c:url value='/brs/js/bootstrap.min.js?v=3.3.6'></c:url>"></script>
    <script src="<c:url value='/brs/js/plugins/metisMenu/jquery.metisMenu.js'></c:url>"></script>
    <script src="<c:url value='/brs/js/plugins/slimscroll/jquery.slimscroll.min.js'></c:url>"></script>
    <script src="<c:url value='/brs/js/plugins/layer/layer.min.js'></c:url>"></script>

    <!-- 自定义js -->
    <script src="<c:url value='/brs/js/hAdmin.js?v=4.1.0'></c:url>"></script>
    <script type="text/javascript" src="<c:url value='/brs/js/_global.js'></c:url>"></script>
	<script type="text/javascript" src="<c:url value='/brs/js/index.js'></c:url>"></script>
	<script type="text/javascript" src="<c:url value='/brs/js/_msgWin.js'></c:url>"></script>

</body>

</html>

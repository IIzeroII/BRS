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
<title> - 用户信息管理</title>
<meta name="keywords" content="">
<meta name="description" content="">

<link rel="shortcut icon" href="favicon.ico"> <link href="<c:url value='/brs/css/bootstrap.min.css?v=3.3.6'></c:url>" rel="stylesheet">
<link href="<c:url value='/brs/css/font-awesome.css?v=4.4.0'></c:url>" rel="stylesheet">

<link href="<c:url value='/brs/css/animate.css'></c:url>" rel="stylesheet">
<link href="<c:url value='/brs/css/style-h.css?v=4.1.0'></c:url>" rel="stylesheet">
</head>

<body class="gray-bg">
	
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
        	<div class="ibox">
        		<div class="ibox-title" >
                    <h5>所有</h5>
                    <div class="ibox-tools">
                        <a  href="<c:url value='/brs/jsp/users_add.jsp'></c:url>" class="btn btn-primary btn-xs">创建用户信息</a>
                    </div>
                </div>
                <div class="row m-b-sm m-t-sm users-row" >
                    <div class="col-md-8 ">
                        <button  type="button" id="loadingBtn" onclick="window.location.href='<c:url value='/usersAction!userList.action'></c:url>'" class="btn btn-white btn-sm "><i class="fa fa-refresh"></i> 刷新</button>
                    </div>
                    <div class="col-md-4 ">
                    	<form action="<c:url value="/usersAction!userSearch.action"></c:url>" method="post" target="J_iframe">
	                        <div class="input-group">
	                            <input name="searchContent" type="text" placeholder="请输入相关信息" class="input-sm form-control">
	                             <span class="input-group-btn">
	                       			<button id="searchBtn" type="submit" class="btn btn-sm btn-primary"> 搜索</button> 
	                       		</span>
	                        </div>
                        </form>
                    </div>
                </div>
                <c:forEach items="${userList}" var="user">
		            <div class="col-sm-4">
		                <div class="contact-box">
		                	<a href="<c:url value='/usersAction!userDel.action?userId=${user.userId}'></c:url>" target="J_iframe" class="close-link"><i class="fa fa-times"></i></a>
		                    <a href="<c:url value='/usersAction!userDetail.action?userId=${user.userId}'></c:url>"  target="J_iframe">
		                        <div class="col-sm-4">
		                            <div class="text-center">
		                                <img  class="userImg img-circle m-t-xs img-responsive" src="<c:url value='/usersAction!getImgByImgId.action?imgId=${user.imgId}'></c:url>"/>
		                            </div>
		                        </div>
		                        <div class="col-sm-8">
		                            <h3><strong class="userName">${user.name}</strong></h3><br />
		                            <p><strong>性别：<span class="sex">${user.sex}</span></strong><br /></p>
		                            <strong>ID：<span class="userId">${user.userId}</span></strong><br />
		                            <strong>PWD：<span class="password">${user.password}</span></strong><br />
		                            <strong>E-mail：<span class="email">${user.email}</span></strong><br />
		                            <strong>Tel：<span class="tel">${user.tel}</span></strong>
		                        </div>
		                        <div class="clearfix"></div>
		                    </a>
		                </div>
		            </div>
	            </c:forEach>
	         </div> 
        </div>
    </div>

    <!-- 全局js -->
    <script src="<c:url value='/brs/js/jquery.min.js?v=2.1.4'></c:url>"></script>
    <script src="<c:url value='/brs/js/bootstrap.min.js?v=3.3.6'></c:url>"></script>



    <!-- 自定义js -->
    <script src="<c:url value='/brs/js/content.js?v=1.0.0'></c:url>"></script>

	
    <script>
        $(document).ready(function () {
            $('.contact-box').each(function () {
                animationHover(this, 'pulse');
            });
        });
    </script>
    <!-- 刷新按钮 -->
	<script>
        $(document).ready(function(){

            $('#loadingBtn').click(function () {
                btn = $(this);
                simpleLoad(btn, true)

                // Ajax example
//                $.ajax().always(function () {
//                    simpleLoad($(this), false)
//                });

                simpleLoad(btn, false)
            });
        });

        function simpleLoad(btn, state) {
            if (state) {
                btn.children().addClass('fa-spin');
                btn.contents().last().replaceWith(" Loading");
            } else {
                setTimeout(function () {
                    btn.children().removeClass('fa-spin');
                    btn.contents().last().replaceWith(" 刷新");
                }, 2000);
            }
        }
    </script>
    
    

</body>

</html>

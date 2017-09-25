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
<meta name="author" content="Brs" />
<title>Bicycle Rental System</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/brs/css/style-d.css'></c:url>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/brs/css/_msgWin.css'></c:url>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/brs/css/_loadingModel.css'></c:url>" />
<style>
body{height:100%;background:#16a085;overflow:hidden;}
canvas{z-index:-1;position:absolute;}
</style>
</head>
<body>

	<!-- 导入弹窗 -->
	<jsp:include page="./msgWin.jsp"></jsp:include>
	<%--加载界面--%>
	<jsp:include page="./loadingModel.jsp"></jsp:include>
	
	<dl class="admin_login">
	 <dt>
	  <strong>自行车租赁信息管理系统</strong>
	  <em>Bicycle Rental System</em>
	 </dt>
	 <dd class="user_icon">
	  <input id="adminId" type="text" placeholder="账号" class="login_txtbx" required=""/>
	 </dd>
	 <dd class="pwd_icon">
	  <input id="password" type="password" placeholder="密码" class="login_txtbx" required=""/>
	 </dd>
	 <dd class="val_icon">
	  <div class="checkcode">
	    <input type="text" id="J_codetext" placeholder="验证码" maxlength="4" class="login_txtbx">
	    <canvas class="J_codeimg" id="myCanvas" onclick="createCode()">对不起，您的浏览器不支持canvas，请下载最新版浏览器!</canvas>
	  </div>
	  <input type="button" value="验证码核验" class="ver_btn" onClick="validate();">
	 </dd>
	 <dd>
	  <input id="loginBtn" type="button" value="立即登陆" class="submit_btn"/>
	 </dd>
	 <dd>
	  <input type="button" value="注 册" onclick="window.location.href='<c:url value='/brs/jsp/register.jsp'></c:url>'" class="submit_btn"/>
	 </dd>
	 <dd>
	  <p>© 2016-2020 Brs 版权所有</p>
	 </dd>
	</dl>
  
</body>
<script src="<c:url value='/brs/js/jquery.min.js'></c:url>"></script>
<script src="<c:url value='/brs/js/verificationNumbers.js'></c:url>"></script>
<script src="<c:url value='/brs/js/Particleground.js'></c:url>"></script>
<script>
$(document).ready(function() {
  //粒子背景特效
  $('body').particleground({
    dotColor: '#5cbdaa',
    lineColor: '#5cbdaa'
  });
  //验证码
  createCode();
});
</script>

<script type="text/javascript" src="<c:url value='/brs/js/_global.js'></c:url>"></script>
<script type="text/javascript" src="<c:url value='/brs/js/_login.js'></c:url>"></script>
<script type="text/javascript" src="<c:url value='/brs/js/_msgWin.js'></c:url>"></script>
<script type="text/javascript" src="<c:url value='/brs/js/_loadingModel.js'></c:url>"></script>


</html>

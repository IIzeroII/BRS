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
<link rel="shortcut icon" href="#" type="image/png">

<title>reminder Page</title>

<link href="<c:url value='/brs/css/style-a.css'></c:url>" rel="stylesheet">
<link href="<c:url value='/brs/css/style-responsive.css'></c:url>" rel="stylesheet">

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
<script src="<c:url value='/brs/js/html5shiv.js'></c:url>"></script>
<script src="<c:url value='/brs/js/respond.min.js'></c:url>"></script>
<![endif]-->
</head>

<body class="error-page">

<section>
    <div class="container " >
        <section class="error-wrapper text-center" >
        	<h2>温馨提示</h2>
        	<br/>
        	<h2>${msg }</h2>
        	<a class="back-btn" href='<c:url value="/rentalAction!rentalList.action"></c:url>' target="J_iframe" > Back To Home</a>
        </section>

    </div>
</section>

<!-- Placed js at the end of the document so the pages load faster -->
<script src="<c:url value='/brs/js/jquery-1.10.2.min.js'></c:url>"></script>
<script src="<c:url value='/brs/js/jquery-migrate-1.2.1.min.js'></c:url>"></script>
<script src="<c:url value='/brs/js/bootstrap.min.js'></c:url>"></script>
<script src="<c:url value='/brs/js/modernizr.min.js'></c:url>"></script>


<!--common scripts for all pages-->
<!--<script src="<c:url value='/brs/js/scripts.js'></c:url>"></script>-->

</body>
</html>
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
<title> - 自行车管理</title>
<meta name="keywords" content="">
<meta name="description" content="">

<link rel="shortcut icon" href="favicon.ico"> <link href="<c:url value='/brs/css/bootstrap.min.css?v=3.3.6'></c:url>" rel="stylesheet">
<link href="<c:url value='/brs/css/font-awesome.css?v=4.4.0'></c:url>" rel="stylesheet">

<link href="<c:url value='/brs/css/animate.css'></c:url>" rel="stylesheet">
<link href="<c:url value='/brs/css/style-h.css?v=4.1.0'></c:url>" rel="stylesheet">
</head>

<body class="gray-bg">
	
    <div class="wrapper wrapper-content animated fadeInUp">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox">
                    <div class="ibox-title">
                        <h5>所有</h5>
                        <div class="ibox-tools">
                            <a  href="<c:url value='/brs/jsp/bicycle_add.jsp'></c:url>" class="btn btn-primary btn-xs">创建自行车信息</a>
                        </div>
                    </div>
                    <div class="ibox-content">
                        <div class="row m-b-sm m-t-sm">
                            <div class="col-md-8">
                                <button type="button" id="loadingBtn" onclick="window.location.href='<c:url value='/bicycleAction!bicycleList.action'></c:url>'" class="btn btn-white btn-sm"><i class="fa fa-refresh"></i> 刷新</button>
                            </div>
                            <div class="col-md-4 ">
                            	<form action="<c:url value="/bicycleAction!bicycleSearch.action"></c:url>" method="post" target="J_iframe">
	                                <div class="input-group">
	                                    <input type="text" name="searchContent" placeholder="请输入相关信息" class="input-sm form-control">
	                                     <span class="input-group-btn">
	                               			<button id="searchBtn" type="submit" class="btn btn-sm btn-primary"> 搜索</button> 
	                               		</span>
	                                </div>
                                </form>
                            </div>
                        </div>

                        <div class="project-list bicycle">
                            <table class="table table-hover">
                                <tbody>
                                    <c:forEach items="${bicycleList}" var="bicycle" >
	                                    <tr>
	                                        <td class="project-status">
	                                        	<!-- label-primary为热门样式 ;label-default为闲置样式-->
	                                            <span class="stas label label-default">${bicycle.status}</span>
	                                        </td>
	                                        <td class="project-title">
	                                        	种类：
	                                            <span class="bicType">${bicycle.type}</span>
	                                        </td>
	                                        <td style="display: none">
	                                        	编号：
	                                            <span class="bicId">${bicycle.bicId}</span>
	                                        </td>
	                                        <td class="project-price">
	                                        	单价：
	                                        	<span class="price">${bicycle.price}</span>
	                                        	元/小时
	                                        </td>
	                                        <td class="project-img">
                                            	<img class="bicImgId img-circle" src="<c:url value='/bicycleAction!getImgByImgId.action?imgId=${bicycle.imgId}'></c:url>">
	                                        </td>
	                                        <td class="project-actions">
	                                            <a  href="<c:url value='/bicycleAction!bicycleDatails.action?op=0&bicId=${bicycle.bicId}'></c:url>" target="J_iframe"  class="btn btn-white btn-sm"><i class="fa fa-folder"></i> 查看 </a>
	                                            <a  href="<c:url value='/bicycleAction!bicycleDatails.action?op=1&bicId=${bicycle.bicId}'></c:url>"  target="J_iframe" class="btn btn-white btn-sm"><i class="fa fa-pencil"></i> 编辑 </a>
	                                            <a  href="<c:url value='/bicycleAction!bicycleDel.action?bicId=${bicycle.bicId}'></c:url>" target="J_iframe" class="delBtn btn btn-white btn-sm"><i class="fa fa-trash"></i> 删除 </a>
	                                        </td>
	                                   	</tr>
                                   	</c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                 </div>
             </div>
         </div>
     </div>

     <!-- 全局js -->
    <script src="<c:url value='/brs/js/jquery.min.js?v=2.1.4'></c:url>"></script>
    <script src="<c:url value='/brs/js/bootstrap.min.js?v=3.3.6'></c:url>"></script>


    <!-- 自定义js -->
    <script src="<c:url value='/brs/js/content.js?v=1.0.0'></c:url>"></script>
	<script type="text/javascript" src="<c:url value='/brs/js/_bicycle.js'></c:url>"></script>

    </body>
    

    <script>
	     $(document).ready(function(){
	
	         $('#loadingBtn').click(function () {
	             btn = $(this);
	             simpleLoad(btn, true)
	
	             // Ajax example
		// $.ajax().always(function () {
		// simpleLoad($(this), false)
		// });
	
	             simpleLoad(btn, false)
	         });
	     });
		/* 刷新按钮 */
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
    
</html>

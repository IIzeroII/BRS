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
<title> - 租赁管理</title>
<meta name="keywords" content="">
<meta name="description" content="">

<link rel="shortcut icon" href="favicon.ico"> <link href="<c:url value='/brs/css/bootstrap.min.css?v=3.3.6'></c:url>" rel="stylesheet">
<link href="<c:url value='/brs/css/font-awesome.css?v=4.4.0'></c:url>" rel="stylesheet">
<link href="<c:url value='/brs/css/plugins/iCheck/custom.css'></c:url>" rel="stylesheet">
<link href="<c:url value='/brs/css/animate.css'></c:url>" rel="stylesheet">
<link href="<c:url value='/brs/css/style-h.css?v=4.1.0'></c:url>" rel="stylesheet">

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>租赁管理</h5>
                    </div>
                    <div class="ibox-content">
                        <form  class="form-horizontal"  >
                            <div class="form-group">
                                <label class="col-sm-2 control-label">订单编号</label>

                                <div class="col-sm-5">
                                    <input type="text" class="form-control" value="${rental.id }" readonly="readonly">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">种类名</label>

                                <div class="col-sm-5">
                                    <input type="text" class="form-control" value="${rental.type }" readonly="readonly">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">自行车图片</label>

                                <div class="col-sm-1" >
                                    <img  src="<c:url value='/rentalAction!getImgByImgId.action?bicycleImgId=${rental.bicycleImgId}'></c:url>" readonly="readonly" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">单价</label>

                                <div class="col-sm-2">
                                    <input  type="text" class="form-control" value="${rental.price }" readonly="readonly">
                                </div>
                                <label class="control-label">元/小时</label>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">租赁数量</label>

                                <div class="col-sm-2">
                                    <input  type="text" class="form-control" value="${rental.number }" readonly="readonly">
                                </div>
                                <label class="control-label">辆</label>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">租赁时间</label>

                                <div class="col-sm-2">
                                	<input class="form-control layer-date" placeholder="开始日期" value="${rental.startDate }" readonly="readonly">
                                </div>
                                <div class="col-sm-1">
                                	<hr/>
                                </div>
                                <div class="col-sm-2">
                                	<input class="form-control layer-date" placeholder="结束日期" value="${rental.endDate }" readonly="readonly">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">金额</label>

                                <div class="col-sm-2">
                                    <input  type="text" class="form-control" value="${rental.money }" readonly="readonly">
                                </div>
                                <label class="control-label">元</label>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">租赁人ID</label>

                                <div class="col-sm-5">
                                    <input type="text" class="form-control" value="${rental.userId }" readonly="readonly">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">租赁人姓名</label>

                                <div class="col-sm-5">
                                    <input type="text" class="form-control" value="${rental.userName }" readonly="readonly">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">用户图片</label>

                                <div class="col-sm-1" >
                                    <img  src="<c:url value='/rentalAction!getImgByImgId.action?userImgId=${rental.userImgId}'></c:url>" readonly="readonly" />
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-4">
                                    <button onclick="window.location.href='<c:url value='/rentalAction!rentalList.action'></c:url>'" class="btn btn-primary" type="button">返回</button>
                                </div>
                            </div>
                        </form>
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

    <!-- iCheck -->
    <script src="<c:url value='/brs/js/plugins/iCheck/icheck.min.js'></c:url>"></script>
    <script>
        $(document).ready(function () {
            $('.i-checks').iCheck({
                checkboxClass: 'icheckbox_square-green',
                radioClass: 'iradio_square-green',
            });
        });
    </script>
    

</body>

</html>

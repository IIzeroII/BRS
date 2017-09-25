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
                        <form  method="post"  action='<c:url value="/rentalAction!editRental.action"></c:url>'  class="form-horizontal"   target="J_iframe">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">订单编号</label>

                                <div class="col-sm-5">
                                    <input name="id" type="text" class="form-control" value="${rental.id }" readonly="readonly">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">租赁人ID</label>

                                <div class="col-sm-5">
                                    <input name="userId" type="text" class="form-control" value="${rental.userId }">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">种类名</label>

                                <div class="col-sm-5">
                                    <input name="type" type="text" class="form-control" value="${rental.type }">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">数量</label>

                                <div class="col-sm-2">
                                    <input name="number" type="text" class="form-control" value="${rental.number }">
                                </div>
                                <label class="control-label">辆</label>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">租赁时间</label>

                                <div class="col-sm-2">
                                	<input id="start" name="startDate" class="form-control layer-date" placeholder="开始日期" value="${rental.startDate }">
                                </div>
                                <div class="col-sm-1">
                                	<hr/>
                                </div>
                                <div class="col-sm-2">
                                	<input id="end" name="endDate" class="form-control layer-date" placeholder="结束日期" value="${rental.endDate }">
                                </div>
                            </div>
                            
                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-4">
                                    <button class="btn btn-primary" type="submit">保存内容</button>
                                    <button onclick="window.location.href='<c:url value='/rentalAction!rentalList.action'></c:url>'" class="btn btn-white" type="button">取消</button>
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
    
    <!-- layerDate plugin javascript -->
    <script src="<c:url value='/brs/js/plugins/layer/laydate/laydate.js'></c:url>"></script>
    <script>
        //日期范围限制
        var start = {
            elem: '#start',
            format: 'YYYY-MM-DD hh:mm:ss',
            min: laydate.now(), //设定最小日期为当前日期
            max: '2099-06-16 23:59:59', //最大日期
            istime: true,
            istoday: false,
            choose: function (datas) {
                end.min = datas; //开始日选好后，重置结束日的最小日期
                end.start = datas //将结束日的初始值设定为开始日
            }
        };
        var end = {
            elem: '#end',
            format: 'YYYY-MM-DD hh:mm:ss',
            min: laydate.now(),
            max: '2099-06-16 23:59:59',
            istime: true,
            istoday: false,
            choose: function (datas) {
                start.max = datas; //结束日选好后，重置开始日的最大日期
            }
        };
        laydate(start);
        laydate(end);
    </script>

    
    

</body>

</html>

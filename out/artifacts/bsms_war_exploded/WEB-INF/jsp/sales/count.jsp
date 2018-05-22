<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <script type="text/javascript" src="common/bjui/B-JUI/plugins/echarts/echarts.min.js"></script>
    <script src="common/bjui/layui/layui.js"></script>
    <script type="text/javascript" src="common/bsms/js/sales/count.js"></script>
    <link href="common/bsms/css/productIndex.css" rel="stylesheet" media="all">
</head>
<body>

<div class="type-head"style="margin-bottom:1%;">
    <div class="layui-btn-group">
        <button class="layui-btn" id="week">一周</button>
        <button class="layui-btn" id="thirtyDay">30天</button>
        <button class="layui-btn" id="nighty">90天</button>
    </div>
</div>
<div id="container" style="width:100%;height:80%;"></div>
</body>
</html>
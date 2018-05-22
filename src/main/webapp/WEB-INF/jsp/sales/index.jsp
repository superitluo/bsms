<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>用户管理</title>
    <script src="common/bsms/js/sales/index.js"></script>
    <link href="common/bsms/css/productIndex.css" rel="stylesheet" media="all">
</head>
<body>
<div class="type-head">
    <div>
        <!--操作按钮-->
        <div class="layui-btn-group">
            <button class="layui-btn" onclick="addSales()"><i class="layui-icon">&#xe654;</i></button>
            <button class="layui-btn" onclick="editSales()"><i class="layui-icon">&#xe642;</i></button>
            <button class="layui-btn" onclick="delSales()"><i class="layui-icon">&#xe640;</i></button>
        </div>
        <!--搜索-->
        <div style="display:inline-block;margin-left:20px;float:right;">
            <div class="layui-btn-group">
                <button class="layui-btn" id="noship">未发货</button>
                <button class="layui-btn" id="payed">已付款</button>
                <button class="layui-btn" id="returned">已退货</button>
                <button id="reset" class="layui-btn"><i class="layui-icon">&#x1002;</i></button>
            </div>
        </div>
    </div>
</div>
<div class="type-content">
    <div class="right-table">
        <table id="sales-datagrid-filter" class="table table-bordered"></table>
    </div>
</div>
</body>
</html>
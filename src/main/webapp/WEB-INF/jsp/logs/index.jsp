<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>用户管理</title>
    <script src="common/bsms/js/logs/index.js"></script>
    <link href="common/bsms/css/productIndex.css" rel="stylesheet" media="all">
</head>
<body>
<div class="type-head">
    <div>
        <!--操作按钮-->
        <div class="layui-btn-group">
            <button class="layui-btn" id="refresh"><i class="layui-icon">&#x1002;</i></button>
        </div>
        <!--搜索-->

    </div>
</div>
<div class="type-content">
    <div class="right-table">
        <table id="logs-datagrid-filter" class="table table-bordered"></table>
    </div>
</div>
</body>
</html>
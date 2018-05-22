<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>用户管理</title>
    <script src="common/bsms/js/user/index.js"></script>
    <link href="common/bsms/css/productIndex.css" rel="stylesheet" media="all">
</head>
<body>
<div class="type-head">
    <%--<form data-toggle="ajaxsearch" >--%>
    <div>
        <!--操作按钮-->
        <div class="layui-btn-group">
            <button class="layui-btn" onclick="addUser()"><i class="layui-icon">&#xe654;</i></button>
            <button class="layui-btn" onclick="editUser()"><i class="layui-icon">&#xe642;</i></button>
            <button class="layui-btn" onclick="delUser()"><i class="layui-icon">&#xe640;</i></button>
        </div>
        <!--搜索-->
        <div style="display:inline-block;margin-left:20px;float:right;">
            <input type="text" name="user-name" class="form-control" size="15" placeholder="名字、地址、电话、用户名模糊查询">
            <div class="layui-btn-group">
                <button type="submit" class="layui-btn" id="user-search"><i class="layui-icon">&#xe615;</i></button>
                <button type="reset" id="user-reset" class="layui-btn" data-icon="times"><i
                        class="layui-icon">&#x1002;</i></button>
            </div>
        </div>
    </div>
    <%--</form>--%>
</div>
<div class="type-content">
    <div class="right-table">
        <table id="user-datagrid-filter" class="table table-bordered"></table>
    </div>
</div>
</body>
</html>
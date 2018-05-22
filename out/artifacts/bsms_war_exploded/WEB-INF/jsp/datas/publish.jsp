<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv='pragma' content="no-cache"/>
    <meta http-equiv='cache-control' content="no-cache"/>
    <title>图书出版社管理</title>
    <meta name="content-type" content="text/html;charset=utf-8">
    <script src="common/bsms/js/publish/index.js"></script>
    <link href="common/bsms/css/bookType.css" rel="stylesheet" media="all">
</head>
<body>
<div class="my-head">
    <div class="layui-btn-group">
        <button class="layui-btn" onclick="addPublish()"><i class="layui-icon">&#xe654;</i></button>
        <button class="layui-btn" onclick="editPublish()"><i class="layui-icon">&#xe642;</i></button>
        <button class="layui-btn" onclick="delPublish()"><i class="layui-icon">&#xe640;</i></button>
    </div>
</div>
<div class="my-content">
    <div class="left-table">
        <table id="unusablePublish" class="table table-bordered">
        </table>
    </div>
    <div class="bt-items">
        <div class="div-space"></div>
        <div class="div-items">
            <button class="bt-item" onclick="addAll()"><i class="layui-icon">&#xe65b;</i></button>
            <button class="bt-item" onclick="add()"><i class="layui-icon">&#xe602;</i></button>
            <button class="bt-item" onclick="remove()"><i class="layui-icon">&#xe603;</i></button>
            <button class="bt-item" onclick="removeAll()"><i class="layui-icon">&#xe65a;</i></button>
        </div>
    </div>
    <div class="rightTable">
        <table id="usablePublish" class="table table-bordered">
        </table>
    </div>
</div>
</body>
</html>
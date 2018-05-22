<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta name="content-type" content="text/html;charset=utf-8">
    <!-- layui-js、css -->
    <script src="../common/bjui/layui/layui.js"></script>
    <link href="../common/bjui/layui/css/layui.css" rel="stylesheet" media="all">
    <script src="../common/bsms/js/user/update.js"></script>
    <title>修改用户</title>
    <style>
        .addform {
            padding: 50px;
        }

        .button-items {
            text-align: center;
        }
    </style>
</head>
<body>
<form class="layui-form layui-form-pane">
    <input type="hidden" name="id" value=${id}>
    <div class="addform">

        <div class="layui-form-item" padding="10px">
            <label class="layui-form-label">用户名:</label>
            <div class="layui-input-block">
                <input type="text" name="usercode" lay-verify="required" lay-verType='tips'
                       autocomplete="off" lay-verType="tips" placeholder="请输入用户名" class="layui-input"
                       disabled="disabled">
            </div>
        </div>

        <div class="layui-form-item" padding="10px">
            <label class="layui-form-label">姓名:</label>
            <div class="layui-input-block">
                <input type="text" name="username" lay-verify="required" lay-verType='tips'
                       autocomplete="off" lay-verType="tips" placeholder="请输入姓名" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item" padding="10px">
            <label class="layui-form-label">性别:</label>
            <div class="layui-input-block">
                <input type="radio" name="gender" value="2" title="男">
                <input type="radio" name="gender" value="1" title="女">
            </div>
        </div>

        <div class="layui-form-item" padding="10px">
            <label class="layui-form-label" width="30%">出生日期:</label>
            <div class="layui-input-block">
                <input type="text" id="birthday" name="birthday" lay-verify="required" lay-verType='tips'
                       autocomplete="off" placeholder="请选择生日" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item" padding="10px">
            <label class="layui-form-label">手机号:</label>
            <div class="layui-input-block">
                <input type="text" name="phone" lay-verify="required|phone" lay-verType='tips'
                       autocomplete="off" lay-verType="tips" placeholder="请输入手机号" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item" padding="10px">
            <label class="layui-form-label">地址:</label>
            <div class="layui-input-block">
                <input type="text" name="address" lay-verType='tips' autocomplete="off" lay-verType="tips"
                       placeholder="请输入地址" class="layui-input">
            </div>
        </div>


        <div class="layui-form-item" padding="10px">
            <label class="layui-form-label">角色:</label>
            <div class="layui-input-block">
                <select name="userrole" id="userrole" lay-filter="typeSelect" lay-search="">
                    <option value=''>-请选择角色(可以输入搜索)-</option>
                </select>
            </div>
        </div>

        <div class="button-items">
            <button class="layui-btn" lay-submit lay-filter="save">保存</button>
            <button class="layui-btn" id="Cancel">取消</button>
        </div>
    </div>
</form>
</body>
</html>
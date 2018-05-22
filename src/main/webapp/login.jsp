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
    <script src="common/bjui/layui/layui.js"></script>
    <link href="common/bjui/layui/css/layui.css" rel="stylesheet" media="all">
    <script src="common/bsms/js/user/login.js"></script>
    <title>登录</title>
    <style>
        .addform {
            padding: 50px;
        }

        .button-items {
            text-align: center;
        }

        .content {
            margin-top: 200px;
            text-align: center;
        }

        .content > form {
            background-color: grey;
            height: 40%;
            margin-left: 35%;
            width: 30%;
        }

        .content > form > label {
            color: white;
        }
    </style>
</head>
<body>
<div class="content">
    <form class="layui-form layui-form-pane">
        <div class="addform" style="text-align:center ;">
            <h1 style="color:white">智慧书店管理系统</h1><br>
            <div class="layui-form-item" padding="10px">
                <label class="layui-form-label">账户名：</label>
                <div class="layui-input-block">
                    <input type="text" name="usercode" lay-verify="required" lay-verType='tips'
                           autocomplete="off" lay-verType="tips" placeholder="请输入账户名" class="layui-input">
                </div>
            </div>

            <div class="layui-form-item" padding="10px">
                <label class="layui-form-label">密&nbsp &nbsp码：</label>
                <div class="layui-input-block">
                    <input type="password" name="userpassword" lay-verify="required" lay-verType='tips'
                           autocomplete="off" lay-verType="tips" placeholder="请输入密码" class="layui-input">
                </div>
            </div>

            <div style="width:100%; margin: 0;">
                <button class="layui-btn layui-btn-fluid" lay-submit lay-filter="save">登录</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
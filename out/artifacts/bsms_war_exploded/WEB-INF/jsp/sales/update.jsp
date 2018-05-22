<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta name="content-type" content="text/html;charset=utf-8">
    <!-- layui-js、css -->
    <script src="../common/bjui/layui/layui.js"></script>
    <link href="../common/bjui/layui/css/layui.css" rel="stylesheet" media="all">
    <script src="../common/bsms/js/sales/update.js"></script>
    <title>修改销售单</title>
    <style>
        .addform{
            padding:50px;
        }
        .button-items{
            text-align: center;
        }
    </style>
</head>
<body>
<form class="layui-form layui-form-pane">
    <input type="hidden" name="id" value=${id}>
    <div class="addform">

        <div class="layui-form-item" padding="10px">
            <label class="layui-form-label">图书名:</label>
            <div class="layui-input-block">
                <select name="bookId" id="bookId" lay-filter="bookId"lay-search="" lay-verify="required">
                    <option value=''>-请选择图书名(可以输入搜索)-</option>
                </select>
            </div>
        </div>

        <div class="layui-form-item" padding="10px">
            <label class="layui-form-label">会员卡号:</label>
            <div class="layui-input-block">
                <select name="gkcardnumber" id="gkcardnumber" lay-filter="gkcardnumber"lay-search="" lay-verify="required">
                    <option value=''>-请选择会员卡号(可以输入搜索)-</option>
                </select>
            </div>
        </div>

        <div class="layui-form-item" padding="10px">
            <label class="layui-form-label">数量:</label>
            <div class="layui-input-block">
                <input type="text" name="number" lay-verify="required|number"lay-verType='tips'
                       autocomplete="off" lay-verType="tips"placeholder="请输入数量" class="layui-input">
            </div>
        </div>


        <div class="layui-form-item" padding="10px">
            <label class="layui-form-label">单价:</label>
            <div class="layui-input-block">
                <input type="text" name="price" lay-verify="required|price"lay-verType='tips'
                       autocomplete="off" lay-verType="tips" class="layui-input" disabled="disabled">
            </div>
        </div>


        <div class="layui-form-item" padding="10px">
            <label class="layui-form-label">总价:</label>
            <div class="layui-input-block">
                <input type="text" name="totalPrice" lay-verify="required|price"lay-verType='tips'
                       autocomplete="off" lay-verType="tips"placeholder="请输入单价" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item" padding="10px">
            <label class="layui-form-label">支付状态:</label>
            <div class="layui-input-block">
                <select name="payStatus" id="payStatus" lay-filter="payStatus" lay-verify="required">
                    <option value=''>-请选择支付状态-</option>
                    <option value='0'>已支付</option>
                    <option value='1'>未支付</option>
                </select>
            </div>
        </div>

        <div class="layui-form-item" padding="10px">
            <label class="layui-form-label">发货状态:</label>
            <div class="layui-input-block">
                <select name="shipStatus" id="shipStatus" lay-filter="shipStatus" lay-verify="required">
                    <option value=''>-请选择发货状态-</option>
                    <option value='0'>已发货</option>
                    <option value='1'>未发货</option>
                </select>
            </div>
        </div>

        <div class="layui-form-item" padding="10px">
            <label class="layui-form-label">退货状态:</label>
            <div class="layui-input-block">
                <select name="returns" id="returns" lay-filter="returns"lay-verify="required">
                    <option value=''>-请选择退货状态-</option>
                    <option value='0'>已退货</option>
                    <option value='1'>未退货</option>
                </select>
            </div>
        </div>

        <div class="button-items">
            <button class="layui-btn" lay-submit  lay-filter="save" >保存</button>
            <button class="layui-btn" id="Cancel">取消</button>
        </div>

    </div>
</form>
</body>
</html>
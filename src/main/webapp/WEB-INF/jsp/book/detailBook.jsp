<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta name="content-type" content="text/html;charset=utf-8">
    <title>查看图书</title>
    <!-- layui-js、css -->
    <script src="../common/bjui/layui/layui.js"></script>
    <link href="../common/bjui/layui/css/layui.css" rel="stylesheet" media="all">
    <script src="../common/bsms/js/book/detailBook.js"></script>
    <link href="../common/bsms/css/detailBook.css" rel="stylesheet" media="all">
</head>
<body>
<div class="content">
    <div class="layui-row layui-col-space10 baseIfo">
        <div class="layui-col-md4">
            <div class="layui-carousel" id="bookImages">
                <div carousel-item>
                    <img src="http://localhost:8021/bsms-Image/book/${book.imageUrl1}">
                    <img src="http://localhost:8021/bsms-Image/book/${book.imageUrl2}">
                    <img src="http://localhost:8021/bsms-Image/book/${book.imageUrl3}">
                </div>
            </div>
        </div>
        <div class="layui-col-md4 base">
            <div>ISBN号：${book.isbn}</div>
            <div>图书名称：${book.bookName}</div>
            <div>作者：${book.author}</div>
            <div>出版社：${book.publishId}</div>
            <div>类型：${book.typeId}</div>
            <div>价格：${book.bookPrice}&nbsp;￥</div>
            <div>添加时间：${book.addTime}</div>
        </div>
    </div>
    <br>
    <div class="blurb"><h2> 简介：</h2>${book.blurb}</div>
</div>
</body>
</html>
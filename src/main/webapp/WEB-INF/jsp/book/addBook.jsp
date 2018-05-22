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
    <script src="../common/bsms/js/book/addBook.js"></script>
    <!-- 自己的css -->
    <link href="../Static/bsms.css" rel="stylesheet" media="all">
    <title>添加图书</title>
    <style type="text/css">
        .addbookform {
            padding: 40px;
        }

        .upload-items {
            display: inline-block;
            width: 100%;
            height: 200px;
        }

        .uploadbt {
            margin-top: 0px;
        }
    </style>

</head>
<body>
<script type="text/javascript">
    var picBaseUrl = "http://localhost/bsms-Image/book";
</script>
<form class="layui-form layui-form-pane">
    <input type="hidden" name="bookId" value="${book.bookId}">
    <div class="addbookform">
        <!-- 上传控件以外的控件-->
        <!-- ISBN输入框 -->
        <div class="layui-form-item" padding="10px">
            <label class="layui-form-label">
                <i class="layui-icon" style="font-size:20px;color:red;">&#xe60f;</i>&nbsp;ISBN:</label>
            <div class="layui-input-block">
                <input type="text" name="isbn" value="${book.isbn}" lay-verify="required|isbn" lay-verType='tips'
                       autocomplete="off" lay-verType="tips" placeholder="请输入图书ISBN" class="layui-input">
            </div>
        </div>
        <!-- 书名输入框 -->
        <div class="layui-form-item" padding="10px">
            <label class="layui-form-label">
                <i class="layui-icon" style="font-size:20px;color: red;">&#xe705;</i>&nbsp;书名:</label>
            <div class="layui-input-block">
                <input type="text" name="bookName" value="${book.bookName}" lay-verify="required" lay-verType='tips'
                       autocomplete="off" placeholder="请输入图书名称" class="layui-input">
            </div>
        </div>
        <!-- 作者输入框 -->
        <div class="layui-form-item" padding="10px">
            <label class="layui-form-label">
                <i class="layui-icon" style="font-size:20px;color: #1E9FFF;">&#xe612;</i>&nbsp;作者:</label>
            <div class="layui-input-block">
                <input type="text" name="author" value="${book.author}" lay-verify="title" autocomplete="off"
                       placeholder="请输入作者姓名" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item" padding="10px">
            <label class="layui-form-label">出版社:</label>
            <div class="layui-input-block">
                <select name="publishId" lay-search="" value="${book.publishId}" id="publishId">
                    <option value="0">--选择出版社--</option>
                    <%--<option value="1">清华大学出版社</option>--%>
                </select>
            </div>
        </div>
        <div class="layui-form-item" padding="10px">
            <label class="layui-form-label">图书类型:</label>
            <div class="layui-input-block">
                <select name="typeId" lay-search="" value="${book.typeId}" id="typeId">
                    <option value="0">--选择图书类型--</option>
                    <%--<option value="1">外语</option>--%>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">
                <i class="layui-icon" style="font-size:20px;color: red;">&#xe65e;</i>&nbsp;售价</label>
            <div class="layui-input-block" style="width: 100px;">
                <input type="text" name="bookPrice" value="${book.bookPrice}" lay-verify="required|price"
                       lay-verType='tips' placeholder="￥" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">图书简介</label>
            <div class="layui-input-block">
                <textarea placeholder="图书简介" name="blurb" class="layui-textarea">${book.blurb}</textarea>
            </div>
        </div>
        <div class="upload-items">
            <!-- 上传图片1 -->
            <div class="layui-input-inline">
                <div class="layui-upload">
                    <button type="button" class="layui-btn uploadbt" id="bookImageUrl1">
                        <i class="layui-icon">&#xe67c;</i>上传图片
                    </button>
                    <div class="layui-upload-list">
                        <img class="layui-upload-img" id="demo1" width="100px" height="120px"
                             src="http://localhost:8021/bsms-Image/book/${book.imageUrl1}">
                        <p id="demoText1"></p>
                    </div>
                </div>
            </div>
            <!-- 上传图片2 -->
            <div class="layui-input-inline">
                <div class="layui-upload">
                    <button type="button" class="layui-btn uploadbt" id="bookImageUrl2">
                        <i class="layui-icon">&#xe67c;</i>上传图片
                    </button>
                    <div class="layui-upload-list">
                        <img class="layui-upload-img" id="demo2" width="100px" height="120px"
                             src="http://localhost:8021/bsms-Image/book/${book.imageUrl2}">
                        <p id="demoText2"></p>
                    </div>
                </div>
            </div>
            <!-- 上传图片3 -->
            <div class="layui-input-inline">
                <div class="layui-upload">
                    <button type="button" class="layui-btn uploadbt" id="bookImageUrl3">
                        <i class="layui-icon">&#xe67c;</i>上传图片
                    </button>
                    <div class="layui-upload-list">
                        <img class="layui-upload-img" id="demo3" width="115.172px" height="120px"
                             src="http://localhost:8021/bsms-Image/book/${book.imageUrl3}">
                        <p id="demoText3"></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="button-items">
        <button class="layui-btn" lay-submit lay-filter="addBook">保存</button>
        <button class="layui-btn" id="addBookCancel">取消</button>
    </div>

</form>
</body>
</html>
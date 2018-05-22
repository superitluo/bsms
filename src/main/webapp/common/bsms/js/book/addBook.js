layui.use(['jquery', 'layer', 'form', 'upload'], function () {
    var $ = layui.$;//重点处
    var layer = layui.layer
        , form = layui.form
        , upload = layui.upload;
    var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
    layer.iframeAuto(index)
    var defaultImageUrl = "http://192.168.10.223:8021/bsms-Image/noimage.png";//默认没有上传图片的url
    var images = new Array(defaultImageUrl, defaultImageUrl, defaultImageUrl);//上传的图片的数组

    //页面加载
    $(document).ready(function () {
        //动态初始化下拉框(出版社)
        $.post('../publish/queryAllPublish', function (data) {
            makeOptions(data, '#publishId', 'publishId', 'publishName');
            form.render('select');
        });
        //动态初始化下拉框(图书类型)
        $.post('../bookType/queryAllBookType', function (data) {
            makeOptions(data, '#typeId', 'bookTypeId', 'bookTypeName');
            form.render('select');
        });
    });
    //上传组件1
    var uploadImage1 = upload.render({
        elem: '#bookImageUrl1'
        , url: '../upload/uploadImage'
        , method: "post"
        , before: function (obj) {
            obj.preview(function (index, file, result) {
                $('#demo1').attr('src', result);
            });
        }
        , done: function (res) {
            if (res.code > 0) {
                layer.msg('上传失败');
            } else {
                layer.msg('上传成功');
                images[0] = res.message;//将上传成功后的url存到image数组中
                var demoText = $('#demoText1');
                demoText.html('<br><button class="layui-btn remove1"><i class="layui-icon">&#x1006;</i>取消</button>');
                demoText.find('.remove1').on('click', function () {
                    $('#demo1').attr("src", defaultImageUrl);
                    images[0] = defaultImageUrl;//当取消上传的图片后删除数组中对应的url
                    return false;
                });
            }
        }
        , error: function () {
            var demoText = $('#demoText1');
            demoText.html('<span style="color: #FF5722;">上传失败</span>' +
                '<br><button class="layui-btn demo-reload1"></i>重试</button>');
            demoText.find('.demo-reload1').on('click', function () {
                uploadImage1.upload();
                return false;
            });
        }
    });
    //上传组件2
    var uploadImage2 = upload.render({
        elem: '#bookImageUrl2'
        , url: '../upload/uploadImage'
        , method: "post"
        , before: function (obj) {
            obj.preview(function (index, file, result) {
                $('#demo2').attr('src', result);
            });
        }
        , done: function (res) {
            if (res.code > 0) {
                layer.msg('上传失败');
            } else {
                layer.msg('上传成功');
                images[1] = res.message;//将上传成功后的url存到image数组中
                var demoText = $('#demoText2');
                demoText.html('<br><button class="layui-btn remove2"><i class="layui-icon">&#x1006;</i>取消</button>');
                demoText.find('.remove2').on('click', function () {
                    $('#demo2').attr("src", defaultImageUrl);
                    images[1] = defaultImageUrl;//当取消上传的图片后删除数组中对应的url
                    return false;
                });
            }
        }
        , error: function () {
            var demoText = $('#demoText2');
            demoText.html('<span style="color: #FF5722;">上传失败</span>' +
                '<br><button class="layui-btn demo-reload2">重试</button>');
            demoText.find('.demo-reload2').on('click', function () {
                uploadImage2.upload();
                return false;
            });
        }
    });
    //上传组件3
    var uploadImage3 = upload.render({
        elem: '#bookImageUrl3'
        , url: '../upload/uploadImage'
        , method: "post"
        , before: function (obj) {
            obj.preview(function (index, file, result) {
                $('#demo3').attr('src', result);
            });
        }
        , done: function (res) {
            if (res.code > 0) {
                layer.msg('上传失败');
            } else {
                layer.msg('上传成功');
                images[2] = res.message;//将上传成功后的url存到image数组中
                var demoText = $('#demoText3');
                demoText.html('<br><button class="layui-btn remove3"><i class="layui-icon">&#x1006;</i>取消</button>');
                demoText.find('.remove3').on('click', function () {
                    $('#demo3').attr('src', ('src', defaultImageUrl));
                    images[2] = defaultImageUrl;//当取消上传的图片后删除数组中对应的url
                    return false;
                });
            }
        }
        , error: function () {
            var demoText = $('#demoText3');
            demoText.html('<span style="color: #FF5733;">上传失败</span>' +
                '<br><button class="layui-btn demo-reload3">重试</button>');
            demoText.find('.demo-reload3').on('click', function () {
                uploadImage3.upload();
                return false;
            });
        }
    });
    //表单提交按钮
    form.on('submit(addBook)', function (data) {
        var bookId = $('input[name="bookId"]').val();
        var isbn = $('input[name="isbn"]').val();
        var bookName = $('input[name="bookName"]').val();
        var author = $('input[name="author"]').val();
        var bookPrice = $('input[name="bookPrice"]').val();
        var publishId = $('select[name="publishId"]').val();
        var typeId = $('select[name="typeId"]').val();
        var blurb = $('textarea[name="blurb"]').val();
        alert(images[0] + images[1] + images[2]);
        $.ajax({
            type: "POST",
            url: "../book/addBook",
            data: {
                bookId: bookId, isbn: isbn, bookName: bookName, author: author, bookPrice: bookPrice
                , publishId: publishId, typeId: typeId, blurb: blurb, imageUrl1: images[0], imageUrl2: images[1],
                imageUrl3: images[2]
            },
            dataType: "json",
            success: function (result) {
                parent.layer.msg(result.message)
                parent.layer.close(index); //关闭当前弹窗
                parent.$("#book_datagrid").datagrid('refresh', false);
            }
            , error: function () {
                layer.msg("添加失败");
            }
        });
        return false;//阻止表单跳转。如果需要表单跳转，去掉这段即可。
    });

    //取消按钮单击事件
    $('#addBookCancel').on('click', function () {
        parent.layer.close(index); //关闭当前弹窗
    });
    //表单验证
    form.verify({
        isbn: [
            /^\+?[1-9][0-9]*$/
            , 'isbn号不正确'
        ]
        , price: [
            /^(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*))$/
            , "请输入正确的金额！"
        ]
    });
    //makeOptions(url[获得数据链接],selectId[下拉框对应的id],value[值],valueName[值对应的名称])
    function makeOptions(data, id, valueIdName, valueName) {
        if (data && data.length > 0) {
            var appendString = '';
            for (var i = 0; i < data.length; i++) {
                appendString = appendString + '<option value="' + data[i][valueIdName] + '"> ' + data[i][valueName] + '</option>';
            }
        }
        $(id).append(appendString);
    }
});


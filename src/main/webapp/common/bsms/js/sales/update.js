layui.use(['jquery', 'layer', 'form'], function () {
    var $ = layui.$;//重点处
    var layer = layui.layer;
    var form = layui.form;
    var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
    layer.iframeAuto(index);


    //页面加载
    $(document).ready(function () {
        $.get('../book/queryNameById', function (data) {
            makeOptions(data, '#bookId', 'mkey', 'mvalue');
            form.render('select');
        });
        $.get('../customer/queryNameById', function (data) {
            makeOptions2(data, '#gkcardnumber', 'mkey', 'mvalue');
            form.render('select');
        });
        //动态初始化下拉框(产品类型)
        var id = $('input[name="id"]').val();
        $.get('../sales/salesById', {id: id}, function (sales) {
            $('select[name="gkcardnumber"]').val(sales.gkcardnumber);
            form.render('select');
            $('select[name="bookId"]').val(sales.bookid);
            form.render('select');
            $('input[name="number"]').val(sales.number);
            $('input[name="price"]').val(sales.price);
            $('input[name="totalPrice"]').val(sales.totalprice);
            $('select[name="payStatus"]').val(sales.paystatus);
            form.render('select');
            $('select[name="shipStatus"]').val(sales.shipstatus);
            form.render('select');
            $('select[name="returns"]').val(sales.returns);
            form.render('select');
        });
    });
    //表单提交按钮
    form.on('submit(save)', function (data) {
        var id = $('input[name="id"]').val();
        var gkcardnumber = $('select[name="gkcardnumber"]').val();
        var bookId = $('select[name="bookId"]').val();
        var number = $('input[name="number"]').val();
        var price = $('input[name="price"]').val();
        var totalPrice = $('input[name="totalPrice"]').val();
        var payStatus = $('select[name="payStatus"]').val();
        var shipStatus = $('select[name="shipStatus"]').val();
        var returns = $('select[name="returns"]').val();

        $.ajax({
            type: "POST",
            url: "../sales/salesUpdate",
            data: {
                id: id, gkcardnumber: gkcardnumber, bookId: bookId, number: number, price: price, totalPrice: totalPrice
                , payStatus: payStatus, shipStatus: shipStatus, returns: returns
            },
            dataType: "json",
            success: function (result) {
                parent.layer.alert('修改销售单成功', {offset: 't', icon: 1, time: 2000});
                parent.layer.close(index); //关闭当前弹窗
                parent.$('#sales-datagrid-filter').datagrid('refresh', false);
            }
            , error: function () {
                parent.layer.alert('修改销售单失败', {offset: 't', icon: 5, time: 2000});
            }
        });
        return false;//阻止表单跳转。如果需要表单跳转，去掉这段即可。
    });

    $('input[name="number"]').change(function () {
        setTotalPrice();
    });

    function setTotalPrice() {
        var number = $('input[name="number"]').val();
        var price = $('input[name="price"]').val();
        $('input[name="totalPrice"]').val(number * price);
    }

    //取消按钮单击事件
    $('#Cancel').on('click', function () {
        parent.layer.close(index); //关闭当前弹窗
    });
    //表单验证
    form.verify({
        price: [
            /^(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*))$/
            , "请输入正确的金额！"
        ],
        number: [
            /^[1-9]\d*$/
            , "请输入正确的数量！"
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

    $('input[name="number"]').change(function () {
        $.get('../book/queryBookById?id=' + $('select[name="bookId"]').val(), function (data) {
            var price = data.bookPrice;
            $('input[name="price"]').val(price);
        });
        setTotalPrice();
    });
    $('input[name="price"]').change(function () {
        setTotalPrice();
    });
    function makeOptions2(data, id, valueIdName, valueName) {
        if (data && data.length > 0) {
            var appendString = '';
            for (var i = 0; i < data.length; i++) {
                appendString = appendString + '<option value="' + data[i][valueIdName] + '"> ' + data[i][valueIdName] + '-' + data[i][valueName] + '</option>';
            }
        }
        $(id).append(appendString);
    }
});


layui.use(['jquery', 'layer', 'form', 'laydate'], function () {
    var $ = layui.$;//重点处
    var layer = layui.layer;
    var form = layui.form;
    var laydate = layui.laydate;
    var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
    layer.iframeAuto(index);
    //时间控件渲染
    laydate.render({
        elem: '#birthday'
        , type: 'datetime'
    });

    //页面加载
    $(document).ready(function () {
        var timestamp = new Date().getTime();
        var cardnumber = new Date().getFullYear() + timestamp;
        $('input[name="cardnumber"]').val(cardnumber);
        //动态初始化下拉框(会员卡类型)
        $.get('../cardType/getAll', function (data) {
            makeOptions(data, '#cardtypeid', 'id', 'name');
            form.render('select');
        });
    });
    //表单提交按钮
    form.on('submit(save)', function (data) {
        var name = $('input[name="name"]').val();
        var cardnumber = $('input[name="cardnumber"]').val();
        var gender = $('input[name="gender"]').val();
        var birthday = $('input[name="birthday"]').val();
        var phone = $('input[name="phone"]').val();
        var address = $('input[name="address"]').val();
        var cardtypeid = $('select[name="cardtypeid"]').val();
        $.ajax({
            type: "POST",
            url: "../customer/customerInsert",
            data: {
                name: name, cardnumber: cardnumber, gender: gender, birthday: birthday
                , phone: phone, address: address, cardtypeid: cardtypeid
            },
            dataType: "json",
            success: function (result) {
                parent.layer.alert('添加会员成功', {offset: 't', icon: 1, time: 2000});
                parent.layer.close(index); //关闭当前弹窗
                parent.$('#customer-datagrid-filter').datagrid('refresh', false);
            }
            , error: function () {
                parent.layer.alert('添加会员失败', {offset: 't', icon: 5, time: 2000});
            }
        });
        return false;//阻止表单跳转。如果需要表单跳转，去掉这段即可。
    });
    //取消按钮单击事件
    $('#Cancel').on('click', function () {
        parent.layer.close(index); //关闭当前弹窗
    });
    //表单验证
    form.verify({
        phone: [
            /^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/
            , "请输入正确的手机号！"
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


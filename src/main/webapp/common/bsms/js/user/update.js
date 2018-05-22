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
        , type: 'date'
    });

    //页面加载
    $(document).ready(function () {
        //动态初始化下拉框(产品类型)
        $.get('../role/roleAll', function (data) {
            makeOptions(data, '#userrole', 'id', 'rolename');
            form.render('select');
        });
        var id = $('input[name="id"]').val();
        $.get('../user/userById', {id: id}, function (user) {
            var usercode = $('input[name="usercode"]').val(user.usercode);
            var username = $('input[name="username"]').val(user.username);
            // var gender = $('input[value='+user.gender+']').prop("checked",true);
            $(":radio[name='gender'][value='" + user.gender + "']").prop("checked", true);
            form.render();
            var birthday = $('input[name="birthday"]').val(user.birthday);
            var phone = $('input[name="phone"]').val(user.phone);
            var address = $('input[name="address"]').val(user.address);
            var userrole = $('select[name="userrole"]').val(user.userrole);
            form.render('select');
        });
    });
    //表单提交按钮
    form.on('submit(save)', function (data) {
        var id = $('input[name="id"]').val();
        var username = $('input[name="username"]').val();
        var gender = $('input[name="gender"]:checked').val();
        var birthday = $('input[name="birthday"]').val();
        var phone = $('input[name="phone"]').val();
        var address = $('input[name="address"]').val();
        var userrole = $('select[name="userrole"]').val();
        $.ajax({
            type: "POST",
            url: "../user/userUpdate",
            data: {
                id: id, username: username, gender: gender, birthday: birthday
                , phone: phone, address: address, userrole: userrole
            },
            dataType: "json",
            success: function (result) {
                parent.layer.alert('修改用户成功', {offset: 't', icon: 1, time: 2000});
                parent.layer.close(index); //关闭当前弹窗
                parent.$('#user-datagrid-filter').datagrid('refresh', false);
            }
            , error: function () {
                parent.layer.alert('修改用户失败', {offset: 't', icon: 5, time: 2000});
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


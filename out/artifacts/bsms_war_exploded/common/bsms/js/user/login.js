layui.use(['jquery', 'layer', 'form', 'laydate'], function () {
    var $ = layui.$;//重点处
    var layer = layui.layer;
    var form = layui.form;
    var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
    layer.iframeAuto(index);
    //表单提交按钮
    form.on('submit(save)', function (data) {
        var usercode = $('input[name="usercode"]').val();
        var userpassword = $('input[name="userpassword"]').val();
        $.ajax({
            type: "POST",
            url: "user/login",
            data: {
                usercode: usercode, userpassword: userpassword
            },
            dataType: "json",
            success: function (user) {
                // layer.alert('登陆成功', {offset: 't',icon: 1, time: 2000});
                layui.sessionData('carparts', {key: 'usercode', value: user.usercode});
                layui.sessionData('carparts', {key: 'userpassword', value: user.userpassword});
                // var localSession =layui.sessionData('carparts');
                // alert(localSession.usercode);
                // $.post('index',{ usercode: user.usercode, userpassword:user.userpassword});
                window.location.replace("showIndex");
            }
            , error: function () {
                layer.alert('登录失败', {offset: 't', icon: 5, time: 2000});
            }
        });
        // $.post('user/login',{ usercode: usercode, userpassword:userpassword},function (data) {
        //     alert(data.userpassword);
        // });
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
});


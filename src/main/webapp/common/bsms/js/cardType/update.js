layui.use(['jquery', 'layer', 'form'], function () {
    var $ = layui.$;//重点处
    var layer = layui.layer;
    var form = layui.form;
    var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
    layer.iframeAuto(index);
    $(document).ready(function () {
        var id = $('input[name="id"]').val();
        $.post('../cardType/cardTypeById', {id: id}, function (cardType) {
            $('input[name="name"]').val(cardType.name);
            $('input[name="discount"]').val(cardType.discount);
        });
    });
    //表单提交按钮
    form.on('submit(save)', function (data) {
        var id = $('input[name="id"]').val();
        var name = $('input[name="name"]').val();
        var discount = $('input[name="discount"]').val();
        $.ajax({
            type: "POST",
            url: "../cardType/cardTypeUpdate",
            data: {
                id: id, name: name, discount: discount
            },
            dataType: "json",
            success: function (result) {
                parent.layer.alert('修改会员卡类型成功', {offset: 't', icon: 1, time: 2000});
                parent.layer.close(index); //关闭当前弹窗
                parent.$('#cardType-datagrid-filter').datagrid('refresh', false);
            }
            , error: function () {
                parent.layer.alert('修改会员卡类型失败', {offset: 't', icon: 5, time: 2000});
            }
        });
        return false;//阻止表单跳转。如果需要表单跳转，去掉这段即可。
    });
    //表单验证
    form.verify({
        discount: [
            /^([1-9][0-9]{0,1}|100)$/
            , "请输入正确的折扣！"
        ]
    });
    //取消按钮单击事件
    $('#Cancel').on('click', function () {
        parent.layer.close(index); //关闭当前弹窗
    });
});


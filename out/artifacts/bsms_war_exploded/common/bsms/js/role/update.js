layui.use(['jquery', 'layer', 'form'], function () {
    var $ = layui.$;//重点处
    var layer = layui.layer;
    var form = layui.form;
    var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
    layer.iframeAuto(index);
    $(document).ready(function () {
        var id = $('input[name="id"]').val();
        $.post('../role/roleById', {id: id}, function (role) {
            $('input[name="rolecode"]').val(role.rolecode);
            $('input[name="rolename"]').val(role.rolename);
        });
    });
    //表单提交按钮
    form.on('submit(save)', function (data) {
        var id = $('input[name="id"]').val();
        var rolecode = $('input[name="rolecode"]').val();
        var rolename = $('input[name="rolename"]').val();
        $.ajax({
            type: "POST",
            url: "../role/roleUpdate",
            data: {
                id: id, rolecode: rolecode, rolename: rolename
            },
            dataType: "json",
            success: function (result) {
                parent.layer.alert('修改角色成功', {offset: 't', icon: 1, time: 2000});
                parent.layer.close(index); //关闭当前弹窗
                parent.$('#role-datagrid-filter').datagrid('refresh', false);
            }
            , error: function () {
                parent.layer.alert('角色失败', {offset: 't', icon: 5, time: 2000});
            }
        });
        return false;//阻止表单跳转。如果需要表单跳转，去掉这段即可。
    });
    //取消按钮单击事件
    $('#Cancel').on('click', function () {
        parent.layer.close(index); //关闭当前弹窗
    });
});


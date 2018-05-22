$(function () {
    //加载表格
    onLoadProduct();
    setTimeout(function () {
    }, "1000");
    $("#user-datagrid-filter").datagrid('refresh', true);
});
//加载图书列表
function onLoadProduct() {
    var roles = function () {
        return $.getJSON('role/roleAll')
    };
    var user = function () {
        return $.getJSON('user/userList')
    };
    $('#user-datagrid-filter').datagrid({
        height: '90%',
        tableWidth: '100%',
        gridTitle: '用户列表',
        showToolbar: false,
        // loadType:'GET',
        local: 'remote',
        dataUrl: 'user/selectUser',
        filterThead: false,
        columnFilter: false,
        showCheckboxcol: true,
        linenumberAll: true,
        date: {username: null},
        PK: "id",
        columns: [
            {name: 'id', label: '用户id', align: 'center', hide: true},
            {name: 'usercode', label: '用户名', align: 'center'},
            {name: 'username', label: '姓名', align: 'center'},
            {
                name: 'gender', label: '性别', align: 'center', itemattr: {value: 'key', label: 'value'},
                items: [{key: '1', value: "女"}, {key: '2', value: "男"}], render: $.datagrid.renderItem
            },
            {name: 'birthday', label: '出生日期', align: 'center', type: 'date', pattern: 'yyyy-MM-dd'},
            {name: 'phone', label: '手机号', align: 'center'},
            {name: 'address', label: '地址', align: 'center'},
            {
                name: 'userrole', label: '角色', align: 'center', itemattr: {value: 'id', label: 'rolename'},
                items: roles, render: $.datagrid.renderItem
            },
            {
                name: 'createdby', label: '创建者', align: 'center', itemattr: {value: 'id', label: 'username'},
                items: user, render: $.datagrid.renderItem
            },
            {name: 'creationdate', label: '创建时间', align: 'center', type: 'date', pattern: 'yyyy-MM-dd HH:mm:ss'},
            {
                name: 'modifyby', label: '更新者', align: 'center', itemattr: {value: 'id', label: 'username'},
                items: user, render: $.datagrid.renderItem
            },
            {name: 'modifydate', label: '更新时间', align: 'center', type: 'date', pattern: 'yyyy-MM-dd HH:mm:ss'}
        ],
        paging: {
            pageSize: 10,
            pageCurrent: 1,
            selectPageSize: '10,20,40,70,100,150,200'
        }
    });
}

function addUser() {
    layer.open({
        type: 2,
        title: "添加用户",
        area: ['50%', '80%'],
        resize: true,
        scrollbar: true,
        maxmin: true,
        shade: [0.8, '#393D49'],
        shadeClose: true,
        content: ['user/showAddUser', 'yes']
    });
}
//编辑用户信息
function editUser() {
    var selectUser = $("#user-datagrid-filter").data("selectedDatas");
    if (selectUser != null && selectUser != '') {
        if (selectUser.length == 1) {
            var id = selectUser[0].id;
            layer.open({
                type: 2,
                area: ['50%', '80%'],
                maxmin: true,
                content: "user/showUpdateUser?id=" + id
            });
        } else {
            layer.alert('请勿选择多条记录！', {offset: 't', icon: 5, time: 2000});
        }
    } else {
        layer.alert('未选中任何行！', {offset: 't', icon: 5, time: 2000});
    }
    setNotSelected();
}
//删除产品
function delUser() {
    var selectUser = $("#user-datagrid-filter").data("selectedDatas");
    if (selectUser != null && selectUser != '') {
        if (selectUser.length == 1) {
            var id = selectUser[0].id;
            layer.confirm('确定要删除记录？', {offset: 't', icon: 3, title: '提示'}, function (index) {
                $.ajax({
                    url: "user/userDeleteById",
                    type: "POST",
                    dataType: "json",
                    data: {id: id},
                    success: function (msg) {
                        layer.alert('删除记录成功！', {offset: 't', icon: 1, time: 2000});
                        $("#user-datagrid-filter").datagrid('refresh', false);
                    },
                    error: function (h) {
                        layer.alert('删除记录失败！', {offset: 't', icon: 2, time: 2000});
                    }
                });
                layer.close(index);
            });
        } else {
            layer.alert('请勿选择多条记录！', {offset: 't', icon: 5, time: 2000});
        }
    } else {
        layer.alert('未选中任何行！', {offset: 't', icon: 5, time: 2000});
    }
    setNotSelected();
}


$("#user-search").on('click', function () {
    var username = $('input[name="user-name"]').val();
    $("#user-datagrid-filter").datagrid('filter', {username: username});
});
$("#user-reset").on('click', function () {
    $('input[name="user-name"]').val(null);
    $("#user-datagrid-filter").datagrid('filter', {username: null});
})
function setNotSelected() {
    $("#user-datagrid-filter").datagrid('selectedRows', $("#user-datagrid-filter").data("selectedTrs"), false);
}
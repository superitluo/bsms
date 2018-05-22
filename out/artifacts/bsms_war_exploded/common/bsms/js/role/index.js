//初始化
$(function () {
    loadDatagrid('#role-datagrid-filter', 'role/roleAll', '角色列表');
});

function loadDatagrid(datagrid, url, title) {
    var user = function () {
        return $.getJSON('user/userList')
    };
    $(datagrid).datagrid({
        height: '100%',
        tableWidth: '100%',
        gridTitle: title,
        showToolbar: false,
        local: 'remote',
        loadType: 'GET',
        dataUrl: url,
        columns: [
            {name: 'id', label: '角色id', align: 'center', hide: true, width: '10%'},
            {name: 'rolecode', label: '角色代码', align: 'center', width: '20%'},
            {name: 'rolename', label: '角色名称', align: 'center', width: '15%'},
            {
                name: 'createdby',
                label: '创建者',
                align: 'center',
                width: '15%',
                itemattr: {value: 'id', label: 'username'},
                items: user,
                render: $.datagrid.renderItem
            },
            {name: 'creationdate', label: '创建时间', align: 'center', width: '15%'},
            {
                name: 'modifyby',
                label: '修改者',
                align: 'center',
                width: '10%',
                itemattr: {value: 'id', label: 'username'},
                items: user,
                render: $.datagrid.renderItem
            },
            {name: 'modifydate', label: '修改时间', align: 'center', width: '15%'}
        ],
        filterThead: false,
        columnFilter: false,
        showCheckboxcol: true,
        paging: {
            pageSize: 20,
            pageCurrent: 1,
            selectPageSize: '10,20,40,70,100,150,200'
        },
        linenumberAll: true
    });
}
//添加角色
function addRole() {
    layer.open({
        type: 2,
        title: "添加角色",
        area: ['50%', '40%'],
        resize: true,
        scrollbar: true,
        maxmin: true,
        shade: [0.8, '#393D49'],
        shadeClose: true,
        content: ['role/showAddRole', 'yes']
    });
}
//修改角色
function editRole() {
    var selectRole = $("#role-datagrid-filter").data("selectedDatas");
    if (selectRole != null && selectRole != '') {
        if (selectRole.length == 1) {
            var id = selectRole[0].id;
            layer.open({
                type: 2,
                title: "修改角色",
                area: ['50%', '40%'],
                maxmin: true,
                content: 'role/showUpdateRole?id=' + id
            });
        } else {
            layer.alert('请勿选择多条记录！', {offset: 't', icon: 5, time: 2000});
        }
    } else {
        layer.alert('未选中任何行！', {offset: 't', icon: 5, time: 2000});
    }
    setNotSelected();
}
//删除产品类型
function delRole() {
    var selectRole = $("#role-datagrid-filter").data("selectedDatas");
    if (selectRole != null && selectRole != '') {
        if (selectRole.length == 1) {
            var id = selectRole[0].id;
            layer.confirm('确定要删除记录？', {offset: 't', icon: 3, title: '提示'}, function (index) {
                $.ajax({
                    url: "role/roleDeleteById",
                    type: "POST",
                    dataType: "json",
                    data: {id: id},
                    success: function (msg) {
                        layer.alert('删除记录成功！', {offset: 't', icon: 1, time: 2000});
                        $("#role-datagrid-filter").datagrid('refresh', false);
                    },
                    error: function (msg) {
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
function refreshTabel() {
    $("#productType").datagrid('refresh', false);
    setNotSelected();
}
function setNotSelected() {
    $("#productType").datagrid('selectedRows', $("#productType").data("selectedTrs"), false);
}
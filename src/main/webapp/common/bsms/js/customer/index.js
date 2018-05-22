$(function () {
    //加载表格
    onLoadProduct();
    setTimeout(function () {
    }, "1000");
    $("#customer-datagrid-filter").datagrid('refresh', true);
});
//加载图书列表
function onLoadProduct() {
    var user = function () {
        return $.getJSON('user/userList')
    };
    var cardType = function () {
        return $.getJSON('cardType/getAll')
    }
    $('#customer-datagrid-filter').datagrid({
        height: '90%',
        tableWidth: '100%',
        gridTitle: '会员列表',
        showToolbar: false,
        // loadType:'GET',
        local: 'remote',
        dataUrl: 'customer/selectList',
        filterThead: false,
        columnFilter: false,
        showCheckboxcol: true,
        linenumberAll: true,
        date: {customername: null},
        PK: "id",
        columns: [
            {name: 'cardnumber', label: '卡号', align: 'center'},
            {name: 'id', label: '会员id', align: 'center', hide: true},
            {name: 'name', label: '姓名', align: 'center'},
            {
                name: 'gender', label: '性别', align: 'center', itemattr: {value: 'key', label: 'value'},
                items: [{key: '0', value: "女"}, {key: '1', value: "男"}], render: $.datagrid.renderItem
            },
            {name: 'birthday', label: '出生日期', align: 'center', type: 'date', pattern: 'yyyy-MM-dd'},
            {name: 'phone', label: '手机号', align: 'center'},
            {name: 'address', label: '地址', align: 'center'},
            {
                name: 'cardtypeid', label: '卡类型', align: 'center', itemattr: {value: 'id', label: 'name'},
                items: cardType, render: $.datagrid.renderItem
            },
            {
                name: 'creatuserid', label: '创建者', align: 'center', itemattr: {value: 'id', label: 'username'},
                items: user, render: $.datagrid.renderItem
            },
            {name: 'creattime', label: '创建时间', align: 'center', type: 'date', pattern: 'yyyy-MM-dd HH:mm:ss'},
            {
                name: 'updateuserid', label: '更新者', align: 'center', itemattr: {value: 'id', label: 'username'},
                items: user, render: $.datagrid.renderItem
            },
            {name: 'updatetime', label: '更新时间', align: 'center', type: 'date', pattern: 'yyyy-MM-dd HH:mm:ss'}
        ],
        paging: {
            pageSize: 20,
            pageCurrent: 1,
            selectPageSize: '10,20,40,70,100,150,200'
        }
    });
}

function addCustomer() {
    layer.open({
        type: 2,
        title: "添加会员",
        area: ['50%', '80%'],
        resize: true,
        scrollbar: true,
        maxmin: true,
        shade: [0.8, '#393D49'],
        shadeClose: true,
        content: ['customer/showAdd', 'yes']
    });
}
//编辑用户信息
function editCustomer() {
    var selectUser = $("#customer-datagrid-filter").data("selectedDatas");
    if (selectUser != null && selectUser != '') {
        if (selectUser.length == 1) {
            var id = selectUser[0].id;
            layer.open({
                type: 2,
                area: ['50%', '80%'],
                maxmin: true,
                content: "customer/showUpdate?id=" + id
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
function delCustomer() {
    var selectUser = $("#customer-datagrid-filter").data("selectedDatas");
    if (selectUser != null && selectUser != '') {
        if (selectUser.length == 1) {
            var id = selectUser[0].id;
            layer.confirm('确定要删除记录？', {offset: 't', icon: 3, title: '提示'}, function (index) {
                $.ajax({
                    url: "customer/customerDeleteById",
                    type: "POST",
                    dataType: "json",
                    data: {id: id},
                    success: function (msg) {
                        layer.alert('删除记录成功！', {offset: 't', icon: 1, time: 2000});
                        $("#customer-datagrid-filter").datagrid('refresh', false);
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

$("#customer-search").on('click', function () {
    var customername = $('input[name="customer-name"]').val();
    $("#customer-datagrid-filter").datagrid('filter', {customername: customername});
});
$("#customer-reset").on('click', function () {
    var name = $('input[name="customer-name"]').val(null);
    $("#customer-datagrid-filter").datagrid('filter', {customername: null});
})
function setNotSelected() {
    $("#customer-datagrid-filter").datagrid('selectedRows', $("#customer-datagrid-filter").data("selectedTrs"), false);
}
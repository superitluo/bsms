//初始化
$(function () {
    loadDatagrid('#cardType-datagrid-filter', 'cardType/selectAll', '会员卡类型列表');
});

function loadDatagrid(datagrid, url, title) {
    $(datagrid).datagrid({
        height: '100%',
        tableWidth: '100%',
        gridTitle: title,
        showToolbar: false,
        local: 'remote',
        loadType: 'Post',
        dataUrl: url,
        columns: [
            {name: 'id', label: '会员卡类型id', align: 'center', hide: true},
            {name: 'name', label: '类型名称', align: 'center', width: '40%'},
            {name: 'discount', label: '折扣', align: 'center', width: '40%'}
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
function addCardType() {
    layer.open({
        type: 2,
        title: "添加会员卡类型",
        area: ['50%', '40%'],
        resize: true,
        scrollbar: true,
        maxmin: true,
        shade: [0.8, '#393D49'],
        shadeClose: true,
        content: ['cardType/showAddCardType', 'yes']
    });
}
//修改角色
function editCardType() {
    var selectRole = $("#cardType-datagrid-filter").data("selectedDatas");
    if (selectRole != null && selectRole != '') {
        if (selectRole.length == 1) {
            var id = selectRole[0].id;
            layer.open({
                type: 2,
                title: "修改会员卡类型",
                area: ['50%', '40%'],
                maxmin: true,
                content: 'cardType/showUpdateCardType?id=' + id
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
function delCardType() {
    var selectRole = $("#cardType-datagrid-filter").data("selectedDatas");
    if (selectRole != null && selectRole != '') {
        if (selectRole.length == 1) {
            var id = selectRole[0].id;
            layer.confirm('确定要删除记录？', {offset: 't', icon: 3, title: '提示'}, function (index) {
                $.ajax({
                    url: "cardType/cardTypeDeleteById",
                    type: "POST",
                    dataType: "json",
                    data: {id: id},
                    success: function (msg) {
                        layer.alert('删除记录成功！', {offset: 't', icon: 1, time: 2000});
                        $("#cardType-datagrid-filter").datagrid('refresh', false);
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
    $("##cardType-datagrid-filter").datagrid('refresh', false);
    setNotSelected();
}
function setNotSelected() {
    $("#cardType-datagrid-filter").datagrid('selectedRows', $("#productType").data("selectedTrs"), false);
}
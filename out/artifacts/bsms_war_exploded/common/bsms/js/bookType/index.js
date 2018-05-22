//初始化
$(function () {
    onLoadBookType();
});

//表格初始化
function onLoadBookType() {
    loadDatagrid('#unusableBookType', 'bookType/queryUnusableBookTypeList', '无效的图书类型');
    loadDatagrid('#usableBookType', 'bookType/queryUsableBookTypeList', '有效的图书类型');
}
function addBookType() {
    layer.prompt({
        formType: 3,
        value: '',
        shade: 0,
        title: '添加类型',
    }, function (value, index, elem) {
        if (value != '' && value != null) {
            $.ajax({
                url: "bookType/addBookType",
                type: "post",
                data: {bookTypeName: value},
                dataType: "json",
                success: function (result) {
                    if (result.statusCode == 200) {
                        layer.alert(result.message, {offset: 't', icon: 1, time: 2000});
                        refreshTabel();
                    } else {
                        layer.alert(result.message, {offset: 't', icon: 1, time: 2000});
                    }
                },
                error: function (h) {
                    layer.alert('添加类型失败！', {offset: 't', icon: 1, time: 2000});
                }
            });
            layer.close(index);
        }
    })
}
function addAll() {
    addOrRemoveAll("#unusableBookType", "bookType/addAllBookType");
}
function removeAll() {
    addOrRemoveAll("#usableBookType", "bookType/removeAllBookType");
}
function add() {
    addOrRemove("#unusableBookType", "bookType/setToUsable");
}
function remove() {
    addOrRemove("#usableBookType", "bookType/setToUnusable");
}
function loadDatagrid(datagrid, url, title) {
    $(datagrid).datagrid({
        height: '100%',
        tableWidth: '100%',
        gridTitle: title,
        showToolbar: false,
        // toolbarCustom : globallistbar,
        local: 'remote',
        dataUrl: url,
        columns: [
            {name: 'bookTypeId', label: '类型代码', align: 'center'},
            {name: 'bookTypeName', label: '类型名称', align: 'center'}
        ],
        filterThead: false,
        columnFilter: false,
        showCheckboxcol: true,
        PK: "bookTypeId",
        paging: {
            pageSize: 20,
            pageCurrent: 1,
            selectPageSize: '10,20,40,70,100,150,200'
        },
        linenumberAll: true
    });
}
function addOrRemoveAll(datagrid, url) {
    if ($(datagrid).data("allData").length != null && $(datagrid).data('allData').length != '') {
        layer.confirm('确定要移动全部记录？', {offset: 't', icon: 3, title: '提示'}, function (index) {
            $.ajax({
                url: url,
                type: 'post',
                cache: false,
                dataType: "json",
                success: function (result) {
                    if (result.statusCode == 200) {
                        layer.alert(result.message, {offset: 't', icon: 1, time: 2000});
                        refreshTabel();
                    } else {
                        layer.alert("移动记录失败！", {offset: 't', icon: 1, time: 2000});
                    }
                },
                error: function (h) {
                    layer.alert('移动记录失败！', {offset: 't', icon: 1, time: 2000});
                }
            });
        });
    } else {
        layer.alert('没有可移动的数据！', {offset: 't', icon: 1, time: 2000});
        setNotSelected();
    }
    setNotSelected();
}
function addOrRemove(datagraid, url) {
    if ($(datagraid).data("selectedDatas") != null && $(datagraid).data("selectedDatas") != '') {
        var selectBookType = $(datagraid).data("selectedDatas");
        var bookTypeIds = getIds(selectBookType);
        layer.confirm('确定要移动' + selectBookType.length + '条记录？', {
            offset: 't',
            icon: 3,
            title: '提示'
        }, function (index) {
            $.ajax({
                url: url,
                type: "POST",
                cache: false,
                dataType: "json",
                data: {bookTypeIds: bookTypeIds},
                success: function (result) {
                    if (result.statusCode == 200) {
                        layer.alert('移动' + selectBookType.length + '条记录成功！', {offset: 't', icon: 1, time: 2000});
                        refreshTabel();
                    } else {
                        layer.alert('移动' + selectBookType.length + '条记录失败！', {offset: 't', icon: 2, time: 2000});
                    }
                },
                error: function (h) {
                    layer.alert('移动' + selectBookType.length + '条记录失败！', {offset: 't', icon: 2, time: 2000});
                }
            });
        });
    } else {
        layer.alert('未选中任何行！', {offset: 't', icon: 5, time: 2000});
        setNotSelected();
    }
    setNotSelected();
}

function refreshTabel() {
    $("#usableBookType").datagrid('refresh', false);
    $("#unusableBookType").datagrid('refresh', false);
    setNotSelected();
}

function setNotSelected() {
    $("#usableBookType").datagrid('selectedRows', $("#usableBookType").data("selectedTrs"), false);
    $("#unusableBookType").datagrid('selectedRows', $("#unusableBookType").data("selectedTrs"), false);
}

//得到id列表
function getIds(selectRows) {
    var ids = '';
    for (var i = 0; i < selectRows.length; i++) {
        if (i + 1 == selectRows.length) {
            ids += selectRows[i].bookTypeId;
        } else {
            ids += selectRows[i].bookTypeId + ",";
        }
    }
    return ids;
}
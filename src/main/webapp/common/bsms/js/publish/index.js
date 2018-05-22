//初始化
$(function () {
    onLoadPublish();
});

//表格初始化
function onLoadPublish() {
    loadDatagrid('#unusablePublish', 'publish/queryUnusablePublishList', '无效的图书出版社');
    loadDatagrid('#usablePublish', 'publish/queryUsablePublishList', '有效的图书出版社');
}
function addPublish() {
    layer.prompt({
        formType: 3,
        value: '',
        shade: 0,
        title: '添加出版社',
    }, function (value, index, elem) {
        if (value != '' && value != null) {
            $.ajax({
                url: "publish/addPublish",
                type: "post",
                data: {publishName: value},
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
                    layer.alert('添加出版社失败！', {offset: 't', icon: 1, time: 2000});
                }
            });
            layer.close(index);
        }
    })
}
function addAll() {
    addOrRemoveAll("#unusablePublish", "publish/addAllPublish");
}
function removeAll() {
    addOrRemoveAll("#usablePublish", "publish/removeAllPublish");
}
function add() {
    addOrRemove("#unusablePublish", "publish/setToUsable");
}
function remove() {
    addOrRemove("#usablePublish", "publish/setToUnusable");
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
            {name: 'publishId', label: '出版社代码', align: 'center'},
            {name: 'publishName', label: '出版社名称', align: 'center'}
        ],
        filterThead: false,
        columnFilter: false,
        showCheckboxcol: true,
        PK: "publishId",
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
    }
    setNotSelected();
}
function addOrRemove(datagraid, url) {
    if ($(datagraid).data("selectedDatas") != null && $(datagraid).data("selectedDatas") != '') {
        var selectPublish = $(datagraid).data("selectedDatas");
        var publishIds = getIds(selectPublish);
        layer.confirm('确定要移动' + selectPublish.length + '条记录？',
            {offset: 't', icon: 3, title: '提示'},
            function (index) {
                $.ajax({
                    url: url,
                    type: "POST",
                    cache: false,
                    dataType: "json",
                    data: {publishIds: publishIds},
                    success: function (result) {
                        if (result.statusCode == 200) {
                            layer.alert('移动' + selectPublish.length + '条记录成功！', {offset: 't', icon: 1, time: 2000});
                            refreshTabel();
                        } else {
                            layer.alert('移动' + selectPublish.length + '条记录失败！', {offset: 't', icon: 2, time: 2000});
                        }
                    },
                    error: function (h) {
                        layer.alert('移动' + selectPublish.length + '条记录失败！', {offset: 't', icon: 2, time: 2000});
                    }
                });
            });
    } else {
        layer.alert('未选中任何行！', {offset: 't', icon: 5, time: 2000});
    }
    setNotSelected();
}

function refreshTabel() {
    $("#usablePublish").datagrid('refresh', false);
    $("#unusablePublish").datagrid('refresh', false);
    setNotSelected();
}

function setNotSelected() {
    $("#usablePublish").datagrid('selectedRows', $("#usablePublish").data("selectedTrs"), false);
    $("#unusablePublish").datagrid('selectedRows', $("#unusablePublish").data("selectedTrs"), false);
}

//得到id列表
function getIds(selectRows) {
    var ids = '';
    for (var i = 0; i < selectRows.length; i++) {
        if (i + 1 == selectRows.length) {
            ids += selectRows[i].publishId;
        } else {
            ids += selectRows[i].publishId + ",";
        }
    }
    return ids;
}
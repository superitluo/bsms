$(function () {
    //加载表格
    onLoadBook();
    $("#book_datagrid").datagrid('refresh', false);
});
//图书表格对象
var bookDataGrid;
//加载图书列表
function onLoadBook() {
    bookDataGrid = $('#book_datagrid').datagrid({
        height: '90%',
        tableWidth: '100%',
        gridTitle: '图书列表',
        showToolbar: false,
        local: 'remote',
        dataUrl: 'book/queryBookListJson',
        data: {bookName: null},
        columns: [
            {name: 'bookId', label: '图书号', align: 'center', hide: true},
            {name: 'isbn', label: '图书ISBN', align: 'center',},
            {name: 'bookName', label: '图书名称', align: 'center'},
            {name: 'author', label: '作者'},
            {
                name: 'publishId',
                label: '出版社',
                itemattr: {value: 'publishId', label: 'publishName'},
                items: function () {
                    return $.getJSON('publish/queryAllPublish')
                },
                render: $.datagrid.renderItem,
            },
            {
                name: 'typeId',
                label: '图书类型',
                itemattr: {value: 'bookTypeId', label: 'bookTypeName'},
                items: function () {
                    return $.getJSON('bookType/queryAllBookType')
                },
                render: $.datagrid.renderItem,
                align: 'center'
            },
            {name: 'addTime', label: '添加时间', align: 'center', type: 'date', pattern: 'yyyy-MM-dd HH:mm:ss'},
            {name: 'bookPrice', label: '图书售价', align: 'center',},
        ],
        filterThead: false,
        columnFilter: false,
        showCheckboxcol: true,
        PK: "id",
        paging: {
            pageSize: 20,
            pageCurrent: 1,
            selectPageSize: '10,20,40,70,100,150,200'
        },
        linenumberAll: true
    });
}

//添加图书
function addBook() {
    layer.open({
        type: 2,
        title: "添加图书（带有红色图标的为必填项）",
        area: ['40%', '90%'],
        resize: true,
        scrollbar: true,
        maxmin: true,
        shade: [0.8, '#393D49'],
        shadeClose: true,
        content: ['book/addBookJsp', 'yes']
    });
}
//编辑图书
function editBook() {
    var selectBook = $("#book_datagrid").data("selectedDatas");
    if (selectBook != null && selectBook != '') {
        if (selectBook.length == 1) {
            var bookId = selectBook[0].bookId;
            layer.open({
                type: 2,
                area: ['40%', '90%'],
                maxmin: true,
                content: "book/updateBook?bookId=" + bookId
            });
        } else {
            layer.alert('请选择仅一行纪录！', {offset: 't', icon: 5, time: 2000});
        }
    } else {
        layer.alert('未选中任何行！', {offset: 't', icon: 5, time: 2000});
    }
    setNotSelected();
}
//查看图书
function detailBook() {
    var selectBook = $("#book_datagrid").data("selectedDatas");
    if (selectBook != null && selectBook != '') {
        if (selectBook.length == 1) {
            var bookId = selectBook[0].bookId;
            layer.open({
                type: 2,
                area: ['40%', '90%'],
                maxmin: true,
                shade: [0.8, '#393D49'],
                shadeClose: true,
                content: "book/detailBookJsp?bookId=" + bookId
            });
        } else {
            layer.alert('请选择仅一行纪录！', {offset: 't', icon: 5, time: 2000});
        }
    } else {
        layer.alert('未选中任何行！', {offset: 't', icon: 5, time: 2000});
    }
    setNotSelected();
}
//删除图书
function delBook() {
    if ($("#book_datagrid").data("selectedDatas") != null && $("#book_datagrid").data("selectedDatas") != '') {
        var selectBook = $("#book_datagrid").data("selectedDatas");
        var ids = getIds(selectBook);
        layer.confirm('确定要删除' + selectBook.length + '条记录？', {offset: 't', icon: 3, title: '提示'}, function (index) {
            $.ajax({
                url: "book/deleteBook",
                type: "POST",
                dataType: "json",
                data: {ids: ids},
                success: function (msg) {
                    if (msg.status == 1) {
                        layer.alert('删除' + selectBook.length + '条记录成功！', {offset: 't', icon: 1, time: 2000});
                        $("#book_datagrid").datagrid('refresh', false);
                    }
                },
                error: function (h) {
                    layer.alert('删除' + selectBook.length + '条记录失败！', {offset: 't', icon: 2, time: 2000});
                }
            });
            layer.close(index);
        });
    } else {
        layer.alert('未选中任何行！', {offset: 't', icon: 5, time: 2000});
    }
    setNotSelected();
}

$("#book-search").on('click', function () {
    var bookName = $('input[name="book-name"]').val();
    $("#book_datagrid").datagrid('filter', {bookName: bookName});
});
$("#book-reset").on('click', function () {
    $('input[name="book-name"]').val(null);
    $("#book_datagrid").datagrid('filter', {bookName: null});
});
function setNotSelected() {
    $("#book_datagrid").datagrid('selectedRows', $("#book_datagrid").data("selectedTrs"), false);
}

//得到id列表
function getIds(selectRows) {
    var ids = '';
    for (var i = 0; i < selectRows.length; i++) {
        if (i + 1 == selectRows.length) {
            ids += selectRows[i].bookId;
        } else {
            ids += selectRows[i].bookId + ",";
        }
    }
    return ids;
}
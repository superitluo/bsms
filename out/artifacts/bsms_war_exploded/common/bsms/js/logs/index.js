$(function () {
    //加载表格
    onLoadProduct();
    $("#logs-datagrid-filter").datagrid('refresh', false);
});
//加载产品列表
function onLoadProduct() {
    var name = $('input[name="name"]').val();
    $('#logs-datagrid-filter').datagrid({
        height: '90%',
        tableWidth: '100%',
        gridTitle: '日志列表',
        showToolbar: false,
        local: 'remote',
        dataUrl: "logs/selectAllLogs",
        filterThead: false,
        columnFilter: false,
        showCheckboxcol: true,
        linenumberAll: true,
        PK: "id",
        columns: [
            {name: 'logId', label: '日志id', align: 'center', hide: true},
            {name: 'operationtype', label: '操作类型', align: 'center', width: "20%"},
            {name: 'operationresult', label: '操作结果', align: 'center', width: "20%"},
            {
                name: 'operationuserid',
                label: '操作者',
                width: "20%",
                align: 'center',
                type: 'date',
                pattern: 'yyyy-MM-dd HH:mm:ss'
            },
            {name: 'ip', label: '操作ip', align: 'center', width: "20%"},
            {
                name: 'operationdate',
                label: '操作日期',
                width: '20%',
                align: 'center',
                type: 'date',
                pattern: 'yyyy-MM-dd HH:mm:ss'
            }
        ],
        paging: {
            pageSize: 20,
            pageCurrent: 1,
            selectPageSize: '10,20,40,70,100,150,200'
        }
    });
}

$("#refresh").on('click', function () {
    $("#logs-datagrid-filter").datagrid('refresh', false);
})
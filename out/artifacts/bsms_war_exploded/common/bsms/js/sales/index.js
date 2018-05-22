$(function() {
    //加载表格
    onLoadProduct();
    setTimeout(function(){},"1000");
    $("#sales-datagrid-filter").datagrid('refresh',true);
});
//加载图书列表
function onLoadProduct() {
    var user=function(){return $.getJSON('user/userList')};
    var book=function(){return $.getJSON('book/queryNameById')};
    $('#sales-datagrid-filter').datagrid({
        height: '90%',
        tableWidth:'100%',
        gridTitle : '销售列表',
        showToolbar: false,
        loadType:'Post',
        local: 'remote',
        dataUrl: 'sales/selectSales',
        filterThead : false,
        columnFilter:false,
        showCheckboxcol:true,
        linenumberAll: true,
        data:{payStatus:null,shipStatus:null,returns:1},
        PK:"id",
        columns: [
            {name: 'id', label: '销售id',align: 'center',hide:true},
            {name: 'bookid',label: '图书名',align: 'center',itemattr:{value:'mkey',label:'mvalue'},
                items:book,render: $.datagrid.renderItem},
            {name: 'number',label: '数量',align: 'center'},
            {name: 'price',label: '单价',align: 'center'},
            {name: 'totalprice',label: '总价',align: 'center'},
            {name: 'gkcardnumber',label: '会员卡号',align: 'center'},
            {name: 'paystatus',label: '支付状态',align: 'center',itemattr:{value:'key',label:'value'},
                items:[{key:'0',value:"已支付"},{key:'1',value:"未支付"}] ,render: $.datagrid.renderItem},
            {name: 'shipstatus',label: '发货状态',align: 'center',itemattr:{value:'key',label:'value'},
                items:[{key:'0',value:"已发货"},{key:'1',value:"未发货"}] ,render: $.datagrid.renderItem},
            {name: 'returns',label: '退货状态',align: 'center',itemattr:{value:'key',label:'value'},
                items:[{key:'0',value:"已退货"},{key:'1',value:"未退货"}] ,render: $.datagrid.renderItem},
            {name: 'createuser',label: '创建者',align: 'center',itemattr:{value:'id',label:'username'},
                items:user ,render: $.datagrid.renderItem},
            {name: 'createtime',label: '创建时间',align: 'center',type: 'date',pattern: 'yyyy-MM-dd HH:mm:ss'},
            {name: 'updateuser',label: '更新者',align: 'center',itemattr:{value:'id',label:'username'},
                items:user ,render: $.datagrid.renderItem},
            {name: 'updatetime',label: '更新时间',align: 'center',type: 'date',pattern: 'yyyy-MM-dd HH:mm:ss'}
        ],
        paging : {
            pageSize :20,
            pageCurrent : 1,
            selectPageSize : '10,20,40,70,100,150,200'
        }
    });
}

function addSales() {
    layer.open({
        type:2,
        title:"添加销售单",
        area:['50%','80%'],
        resize:true,
        scrollbar:true,
        maxmin:true,
        shade: [0.8, '#393D49'],
        shadeClose:true,
        content: ['sales/showAddSales', 'yes']
    });
}
//编辑用户信息
function editSales(){
    var selectSales =  $("#sales-datagrid-filter").data("selectedDatas");
    if(selectSales!=null&&selectSales!=''){
        if(selectSales.length==1){
            var id =  selectSales[0].id;
            layer.open({
                type: 2,
                area: ['50%', '80%'],
                maxmin:true,
                content:"sales/showUpdateSales?id="+id
            });
        }else{
            layer.alert('请勿选择多条记录！', {offset: 't',icon: 5, time: 2000});
        }
    }else{
        layer.alert('未选中任何行！', {offset: 't',icon: 5, time: 2000});
    }
    setNotSelected();
}
//删除产品
function delSales(){
    var selectSales =$("#sales-datagrid-filter").data("selectedDatas");
    if(selectSales!=null&&selectSales!=''){
        if(selectSales.length==1){
            var id=selectSales[0].id;
            layer.confirm('确定要删除记录？', {offset:'t',icon: 3, title:'提示'}, function(index){
                $.ajax({
                    url:"sales/salesDeleteById",
                    type:"POST",
                    dataType:"json",
                    data:{id:id},
                    success:function(msg){
                        layer.alert('删除记录成功！', {offset: 't',icon: 1, time: 2000});
                        $("#sales-datagrid-filter").datagrid('refresh',false);
                    },
                    error:function(h){
                        layer.alert('删除记录失败！', {offset: 't',icon: 2, time: 2000});
                    }
                });
                layer.close(index);
            });
        }else{layer.alert('请勿选择多条记录！', {offset: 't',icon: 5, time: 2000});}
    }else{
        layer.alert('未选中任何行！', {offset: 't',icon: 5, time: 2000});
    }
    setNotSelected();
}

$("#noship").on('click',function(){
    $("#sales-datagrid-filter").datagrid('filter', {payStatus:null,shipStatus:1,returns:1});
})

$("#payed").on('click',function(){
    $("#sales-datagrid-filter").datagrid('filter', {payStatus:0,shipStatus:null,returns:1});
})

$("#returned").on('click',function(){
    $("#sales-datagrid-filter").datagrid('filter',{payStatus:null,shipStatus:null,returns:0});
})

$("#reset").on('click',function(){
    $("#sales-datagrid-filter").datagrid('filter', {payStatus:null,shipStatus:null,returns:1});
})
function setNotSelected(){
    $("#sales-datagrid-filter").datagrid('selectedRows', $("#sales-datagrid-filter").data("selectedTrs"),false);
}
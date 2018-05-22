// //初始化chart
var myChart = echarts.init(document.getElementById("container"));

printChart(7, '销售量一周统计表')
function initTable(xValueArray, yValueArray, chart, title) {
    option = {
        title: {
            text: title,
            subtext: ''
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data: ['销售量']
        },
        toolbox: {
            show: true,
            feature: {
                dataView: {show: true, readOnly: false},
                magicType: {show: true, type: ['line', 'bar']},
                restore: {show: true},
                saveAsImage: {show: true}
            }
        },
        calculable: true,
        xAxis: [
            {
                type: 'category',
                name: '日期',
                data: xValueArray
            }
        ],
        yAxis: [
            {
                type: 'value',
                name: '数量'
            }
        ],
        series: [
            {
                name: '销售量',
                type: 'bar',
                data: yValueArray,
                smooth: true
            }
        ]
    };
    chart.setOption(option);
}

//一周
$('#week').click('click', function () {
    printChart(7, '销售量一周统计表')
})
//30天
$('#thirtyDay').click('click', function () {
    printChart(30, '销售量30天统计表')
});
//90天
$('#nighty').click('click', function () {
    printChart(90, '销售量90天统计表')
});

//绘制图表number（过去天数），name(表名)
function printChart(number, name) {
    $.post("sales/selectSalesByDayNumber", {number: number}, function (data) {
        var xValueArray = getDateJson(number);
        var yValueArray = data;
        initTable(xValueArray, yValueArray, myChart, name);
    });
}

//未来/过去日期获取
function GetDateStr(AddDayCount) {
    var dd = new Date();
    dd.setDate(dd.getDate() + AddDayCount);//获取AddDayCount天后的日期
    var y = dd.getFullYear();
    var m = (dd.getMonth() + 1) < 10 ? "0" + (dd.getMonth() + 1) : (dd.getMonth() + 1);//获取当前月份的日期，不足10补0
    var d = dd.getDate() < 10 ? "0" + dd.getDate() : dd.getDate();//获取当前几号，不足10补0
    return m + "-" + d;
}

//获取过去/未来时间的数组
function getDateJson(number) {
    var dates = new Array()
    for (var i = 0, j = number - 1; i < number; i++, j--) {
        dates[j] = GetDateStr(-i);
    }
    return dates;
    // var datesJson=JSON.stringify(dates);
    // return datesJson;
}
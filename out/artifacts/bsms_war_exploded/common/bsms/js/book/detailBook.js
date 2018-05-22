layui.use('carousel', function () {
    var carousel = layui.carousel;
    //建造实例
    carousel.render({
        elem: '#bookImages'
        , width: '100%' //设置容器宽度
        , heigth: '50%'
        , arrow: 'always' //始终显示箭头
        //,anim: 'updown' //切换动画方式
    });
});
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>后台管理系统</title>
    <meta name="keyword" content="">
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <link href="/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="/static/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="/static/css/plugins/toastr/toastr.min.css" rel="stylesheet">
    <link href="/static/css/plugins/gritter/jquery.gritter.css" rel="stylesheet">
    <link href="/static/css/plugins/multiselect/tree-multiselect.min.css" rel="stylesheet">
    <link href="/static/css/animate.css" rel="stylesheet">
    <link href="/static/css/style.css" rel="stylesheet">
</head>

<body class="fixed-sidebar">
    <div id="wrapper">
        <!----左侧导航开始----->
        <nav class="navbar-default navbar-static-side animated fadeInLeft" role="navigation" id="leftnav"></nav>
        <!----左侧导航结束----->

        <!---右侧内容区开始---->
        <div id="page-wrapper" class="gray-bg">
            <!---顶部状态栏 star-->
            <div class="row ">
              <nav class="navbar navbar-fixed-top" role="navigation" id="topnav"></nav>
            </div>
            <!---顶部状态栏 end-->

            <!--------当前位置----->


            <!-----内容区域---->
            <div class="wrapper wrapper-content">
                <div id="home" class="container tab-pane active" style="overflow: hidden"><br>
                    <div style="margin-left: 40%; margin-top: 10%">
                        <img src="/static/img/home.png">
                    </div><br>
                    <div style="text-align: center">
                        <h4>Hi!  ${username! " "},欢迎登录!</h4>
                    </div>

                </div>
            </div>
            <!-----内容结束----->
        </div>
        <!---右侧内容区结束----->
    </div>
<!-- 全局 scripts -->
<script src="/static/js/jquery-2.1.1.js"></script>
<script src="/static/js/bootstrap.js"></script>
<script src="/static/js/wuling.js"></script>
<script src="/static/js/plugins/pace/pace.min.js"></script>
<script src="/static/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="/static/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="/static/js/plugins/multiselect/tree-multiselect.min.js"></script>
<!-- 插件 scripts -->
<script src="/static/js/plugins/toastr/toastr.min.js" async></script>
<!---顶部弹出提示--->


<script>

    $(document).ready(function () {
        function a() {
            $("select#demo1").treeMultiselect(c)
        }

        var c = {
            sortable:false,
            allowBatchSelection:true,
            collapsible:true,
            hideSidePanel:false, //Hide the right panel showing all the selected items
            sectionDelimiter:'/',	//Separator between sections in the select option data-section attribute
            showSectionOnSelected:true,//Show section name on the selected items
            startCollapsed:true
        };
        a()
    });

    /**        
    $('#my_multi_select3').multiSelect({
     selectableHeader: "<div class='custom-header '><h4>未开通城市<small>（列表中点击即可开通）</small></h4></div><input type='text' class='form-control search-input' autocomplete='off' placeholder='搜索城市...'>",
     selectionHeader: "<div class='custom-header '><h4 class='text-navy'>已开通城市</h4></div><input type='text' class='form-control search-input' autocomplete='off' placeholder='search...'>",

     selectableOptgroup: true,
     afterInit: function (ms) {

     var that = this,
     $selectableSearch = that.$selectableUl.prev(),
     $selectionSearch = that.$selectionUl.prev(),

     selectableSearchString = '#' + that.$container.attr('id') + ' .ms-elem-selectable:not(.ms-selected)',
     selectionSearchString = '#' + that.$container.attr('id') + ' .ms-elem-selection.ms-selected';

     that.qs1 = $selectableSearch.quicksearch(selectableSearchString)
     .on('keydown', function (e) {
     if (e.which === 40) {
     that.$selectableUl.focus();
     return false;
     }
     });

     that.qs2 = $selectionSearch.quicksearch(selectionSearchString)
     .on('keydown', function (e) {
     if (e.which == 40) {
     that.$selectionUl.focus();
     return false;
     }
     });
     $('.ms-list').slimScroll({
     height: '500px',
     railVisible: true,
     color:"#65cea7",
     opacity:.8,
     size: '4px',
     borderRadius: '0', //滚动条圆角
     railBorderRadius: '0',//轨道圆角

     distance:0,
     allowPageScroll: true,
     alwaysVisible: false
     });
     },
     afterSelect: function (values) {
     this.qs1.cache();
     this.qs2.cache();
     toastr.success('本次开通的城市！'+values, '城市开通成功！');
     },
     afterDeselect: function (values) {
     this.qs1.cache();
     this.qs2.cache();
     toastr.success('本次删除的城市！'+values, '城市成功删除！');
     }
     }) **/


</script>
</body>
</html>

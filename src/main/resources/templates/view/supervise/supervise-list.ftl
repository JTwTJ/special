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
    <link rel="stylesheet" type="text/css" href="/static/css/home.css">
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
            <div id="menu1"><br>
                <div class="content-header">
                    任务督办表
                </div>
                <div class="op-area">
                    <span>查询结果:</span>
                    <div class="op-area-right">
                        <button style="display: none" id="query" type="button" class="btn btn-primary"><span class="glyphicon glyphicon-search"> 查询</button>
                        <button style="display: none" id="import" type="button" class="btn btn-default"><span class="glyphicon glyphicon-log-in"></span> 导入</button>
                        <button style="display: none" id="export" type="button" class="btn btn-default"><span class="glyphicon glyphicon-share"></span> 导出基本信息</button>
                        <button style="display: none" id="delivery" type="button" class="btn btn-default"><span class="glyphicon glyphicon-share-alt"></span> 导出登记表</button>
                        <button style="display: none" id="add" type="button" class="btn btn-default"><span class="glyphicon glyphicon-plus"></span> 新增</button>
                    </div>
                </div>
                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <div class="ibox" style="overflow: scroll" id="ibox">
                            <table class="table" style="min-width:2000px;">
                                <thead>
                                <tr>
                                    <th>
                                        操作
                                    </th>
                                    <th>
                                        文件名称
                                    </th>
                                    <th>
                                        收文日期
                                    </th>
                                    <th>
                                        电话
                                    </th>
                                    <th>
                                        板块
                                    </th>
                                    <th>
                                        公司名称
                                    </th>
                                    <th>
                                        职能中心
                                    </th>
                                    <th>
                                        流转部门(领导)
                                    </th>
                                    <th>
                                        备注
                                    </th>
                                    <th>
                                        批示日期
                                    </th>
                                    <th>
                                        杜总批示意见
                                    </th>
                                    <th>
                                        最后一次修改人名字
                                    </th>
                                    <th>
                                        创建时间
                                    </th>
                                    <th>
                                        修改时间
                                    </th>
                                </tr>
                                </thead>
                                <tbody>
                                    <#if page?? && page.list?? && (page.list?size > 0) >
                                    <h1>hahahahhaha</h1>
                                        <#--<#list page.list as n>
                                            <td>编辑</td>
                                            <td>${n.fileName }</td>
                                            <td>${n.fileTime }</td>
                                            <td>${n.phone }</td>
                                            <td>${n.plate }</td>
                                            <td>${n.companyName }</td>
                                            <td>${n.functions }</td>
                                            <td>${n.leader }</td>
                                            <td>${n.remark }</td>
                                            <td>${n.handleTime }</td>
                                            <td>${n.handleIdea }</td>
                                            <td>${n.leader }</td>
                                            <td>${n.operator }</td>
                                            <td>${n.leader }</td>
                                            <td>${n.createTime }</td>
                                            <td>${n.updateTime }</td>
                                        </#list>-->
                                    </#if>
                                <#--<tr>
                                    <td>
                                        1
                                    </td>
                                    <td>
                                        TB - Monthly
                                    </td>
                                    <td>
                                        01/04/2012
                                    </td>
                                    <td>
                                        Default
                                    </td>
                                    <td>
                                        1
                                    </td>
                                    <td>
                                        TB - Monthly
                                    </td>
                                    <td>
                                        01/04/2012
                                    </td>
                                    <td>
                                        Default
                                    </td>
                                    <td>
                                        1
                                    </td>
                                    <td>
                                        TB - Monthly
                                    </td>
                                    <td>
                                        01/04/2012
                                    </td>
                                    <td>
                                        Default
                                    </td>
                                    <td>
                                        1
                                    </td>
                                    <td>
                                        TB - Monthly
                                    </td>
                                </tr>-->
                                </tbody>
                            </table>
                        </div>
                        <ul class="pagination">
                            <li>
                                <a href="#">Prev</a>
                            </li>
                            <li>
                                <a href="#">1</a>
                            </li>
                            <li>
                                <a href="#">2</a>
                            </li>
                            <li>
                                <a href="#">3</a>
                            </li>
                            <li>
                                <a href="#">4</a>
                            </li>
                            <li>
                                <a href="#">5</a>
                            </li>
                            <li>
                                <a href="#">Next</a>
                            </li>
                        </ul>
                    </div>
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
<script type="text/javascript" src="https://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.js"></script>
<!-- 插件 scripts -->
<script src="/static/js/plugins/toastr/toastr.min.js" async></script>
<!---顶部弹出提示--->


<script>

    $(document).ready(function () {
        jQuery.post("/links/queryCurrentUserSetUrl", {
            "token": /*$.cookie("token")*/"${token! " "}"
        }, function (data) {
            var menuArr  = new Array();
            menuArr = data.result;
            for (var i=0;i<menuArr.length;i++)
            {
                switch (menuArr[i].linkId) {
                    case "001":
                        $("#001").show();
                        for (var j=0;j<menuArr[i].privilege.length;j++){
                            switch (menuArr[i].privilege[j].key) {
                                case "query":
                                    $("#query").show();
                                    break;
                                case "import":
                                    $("#import").show();
                                    break;
                                case "export":
                                    $("#export").show();
                                case "delivery":
                                    $("#delivery").show();
                                    break;
                                case "add":
                                    $("#add").show();
                                    break;
                            }
                        }
                        break;
                    case "002":
                        $("#002").show();
                        break;
                    case "003":
                        $("#003").show();
                        break;
                    case "004":
                        $("#004").show();
                        break;
                    case "005":
                        $("#005").show();
                        break;
                    case "006":
                        $("#006").show();
                        break;
                    case "007":
                        $("#007").show();
                        break;
                }
            }
        }, "json");
        jQuery.post("/transact/pager",
                {
                    "token": /*$.cookie("token")*/"${token! " "}",
                    "pageNo": 1,
                    "pageSize": 10
                }, function (data) {
                    var page = data.result;
                    console.dir(page.list)
                    $("#ibox").html(page);
        }, "json");
        function a() {
            $("select#demo1").treeMultiselect(c)
        };

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
</script>
</body>
</html>
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
    <#--修改密码模态框-->
    <div class="modal fade" id="editPwd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                        修改密码
                    </h4>
                </div>
                <div class="modal-body">
                    <div style="width: 568px; height: 255px"><br>
                        <br>
                        <input id="oldPwd" name="oldpwd" class="form-control" type="password" placeholder="原密码" style="width: 350px; margin-left: 90px"/>
                        <br>
                        <input id="newPwd" name="newpwd" class="form-control" type="password" placeholder="新密码" style="width: 350px; margin-left: 90px"/>
                        <br>
                        <input id="confirmPwd" name="confirmpwd" class="form-control" type="password" placeholder="确认密码" style="width: 350px; margin-left: 90px">
                        <span id="span01" style="margin-left: 90px"></span>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                    </button>
                    <button type="button" class="btn btn-primary" onclick="return updatePwd()">
                        保存
                    </button>
                </div>
            </div>
        </div>
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
        $.cookie("token", "${token! " "}", {expires:30*60});
        jQuery.post("/links/queryCurrentUserSetUrl", {
            "token": $.cookie("token")
        }, function (data) {
            var menuArr  = new Array();
            menuArr = data.result;
            for (var i=0;i<menuArr.length;i++)
            {
                switch (menuArr[i].linkId) {
                    case "001":
                        $("#001").show();
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
</script>
</body>
</html>

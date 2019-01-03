<!DOCTYPE html>
<html>
<head>
    <title>首页</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/static/css/home.css">
   <#-- <link rel="stylesheet" href="/static/css/bootstrap.min.css">-->
    <#--<script src="/static/js/jquery-3.3.1.min.js"></script>
    <script src="/static/js/bootstrap.min.js"-->
    <script src="/static/js/home.js"></script>
    <script src="https://cdn.staticfile.org/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.js"></script>
    <script>
        $(document).ready(function () {
            $.cookie("token", "${token! " "}", {expires:30*60});
            jQuery.post("/links/queryCurrentUserSetUrl", {
                "token": $.cookie("token")
            }, function (data) {
                var myArr = new Array();
                myArr = data.result;
                for (var i = 0; i<myArr.length;i++) {
                    if (myArr[i].linkId == '001') {

                    }
                }
            }, "json");
        });
    </script>
</head>
<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="row clearfix">
                <div class="col-md-10 column">
                    <h1>
                        (CEO/董事长)专项任务后台管理
                    </h1>
                </div>
                <div class="col-md-2 column" style="height: 69px">
                    <div class="btn-group" style="margin-top: 20px">
                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">${username! " "}
                            <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu" role="menu">
                            <li>
                                <a data-toggle="modal" data-target="#editPwd">修改密码</a>
                            </li>
                            <li>
                                <a onclick="logout()">退出</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <br>
    <!-- Nav pills -->
    <ul class="nav nav-tabs" role="tablist" style="font-size: 20px">
        <li class="nav-item">
            <a class="nav-link" data-toggle="tab" href="#menu1">(CEO/董事长)督办表</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" data-toggle="tab" href="#menu2">生日提醒</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" data-toggle="tab" href="#menu2">库存管理</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" data-toggle="tab" href="#menu2">台账支出管理</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" data-toggle="tab" href="#menu2">台账收入管理</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" data-toggle="tab" href="#menu2">费用报销管理</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" data-toggle="tab" href="#menu2">系统设置</a>
        </li>
    </ul>

    <!-- Tab panes -->
    <div class="tab-content">
        <div id="home" class="container tab-pane active" style="overflow: hidden"><br>
            <div style="margin-left: 40%; margin-top: 10%">
                <img src="/static/img/home.png">
            </div><br>
            <div style="text-align: center">
                <h4>Hi!  ${username! " "},欢迎登录!</h4>
            </div>

        </div>
        <div id="menu1" class="container tab-pane fade"><br>
            <div class="content-header">
                任务督办表
            </div>
            <div class="op-area">
                <span>查询结果:</span>
                <div class="op-area-right">
                    <button type="button" class="btn btn-primary"><span class="glyphicon glyphicon-search"> 查询</button>
                    <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-log-in"></span> 导入</button>
                    <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-share"></span> 导出基本信息</button>
                    <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-share-alt"></span> 导出登记表</button>
                    <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-plus"></span> 新增</button>
                </div>
            </div>
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <div style="overflow: scroll">
                    <table class="table" style="min-width:2000px;">
                        <thead>
                        <tr>
                            <th>
                                操作
                            </th>
                            <th>
                                序号
                            </th>
                            <th>
                                收文日期
                            </th>
                            <th>
                                接收时间
                            </th>
                            <th>
                                电话
                            </th>
                            <th>
                                文件编号
                            </th>
                            <th>
                                文件名称
                            </th>
                            <th>
                                批示日期
                            </th>
                            <th>
                                杜总批示意见
                            </th>
                            <th>
                                是否签字
                            </th>
                            <th>
                                签字日期
                            </th>
                            <th>
                                流转部门(领导)
                            </th>
                            <th>
                                董事长批示文号
                            </th>
                            <th>
                                备注
                            </th>
                            <th>
                                修改人
                            </th>
                            <th>
                                修改时间
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
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
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
                        </tr>
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
        <div id="menu2" class="container tab-pane fade"><br>
            <h3>Menu 2</h3>
            <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.</p>
        </div>
    </div>
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
</body>
</html>
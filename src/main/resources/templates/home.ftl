<!DOCTYPE html>
<html>
<head>
    <title>首页</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script>
        function updatePwd() {
            var oldPwd = $("#oldPwd").val();
            var newPwd = $("#newPwd").val();
            var confirmPwd = $("#confirmPwd").val();
            if (oldPwd == "") {
                $("#span01").html("<font color='red'>请输入原密码!</font>");
                return false;
            } else if (newPwd == "") {
                $("#span01").html("<font color='red'>请输入新密码!</font>");
                return false;
            } else if (confirmPwd == "") {
                $("#span01").html("<font color='red'>请输入确认密码!</font>");
                return false;
            } else if (confirmPwd != newPwd) {
                $("#span01").html("<font color='red'>两次密码不一致!</font>");
                return false;
            } else {
                jQuery.post("/user/updatePassword", {"oldPwd": oldPwd, "newPwd": newPwd}, function (data) {
                    /*$("#span01").html("<font color='red'>!</font>");*/
                    console.dir(data);
                }, "json");
                /*alert(oldPwd+"11"+newPwd+"11"+confirmPwd);*/
            }
        }
    </script>
</head>
<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="row clearfix">
                <div class="col-md-10 column">
                    <h3>
                        (CEO/董事长)专项任务后台管理
                    </h3>
                </div>
                <div class="col-md-2 column">
                    <div class="btn-group">
                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">${username! " "}
                            <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu" role="menu">
                            <li>
                                <a data-toggle="modal" data-target="#editPwd">修改密码</a>
                            </li>
                            <li>
                                <a href="/user/index">退出</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <br>
    <!-- Nav pills -->
    <ul class="nav nav-tabs" role="tablist">
        <li class="nav-item">
            <a class="nav-link active" data-toggle="tab" href="#home">首页</a>
        </li>
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
            <h3>Menu 1</h3>
            <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
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
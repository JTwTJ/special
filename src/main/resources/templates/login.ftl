<!DOCTYPE>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <title>登录</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="/static/css/login.css" rel="stylesheet"></head>
    <#--<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>-->
    <#--<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>-->
</head>
<script>
    function check()
    {
        var username = $("#username").val();
        var password = $("#password").val();
        if(username=="" || password=="")
        {
            $("#message").text("账号或密码不能为空！");
            return false;
        }
        return true;
    }
</script>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-offset-3 col-md-6">
            <form class="form-horizontal" action="/user/home" method="post" onsubmit="return check()">
                <span class="heading">CEO/董事长·专项任务后台管理</span>
                <div class="form-group">
                    <input type="email" class="form-control" id="username" placeholder="用户名或电子邮件">
                    <i class="fa fa-user"></i>
                </div>
                <div class="form-group help">
                    <input type="password" class="form-control" id="password" placeholder="密　码">
                    <i class="fa fa-lock"></i>
                    <a href="#" class="fa fa-question-circle"></a>
                </div>
                <div class="form-group">
                    <div class="main-checkbox">
                        <input type="checkbox" value="None" id="checkbox1" name="check"/>
                        <label for="checkbox1"></label>
                    </div>
                    <span class="text">Remember me</span>
                    <button type="submit" class="btn btn-default">登录</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
<!DOCTYPE>
<html xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html"
      xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <title>登录</title>
    <#--<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">-->
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/static/css/login.css">
    <script src="/static/js/home.js"></script>
    <#--<script src="https://cdn.staticfile.org/jquery/3.3.1/jquery.min.js"></script>-->
    <script src="/static/js/jquery-2.1.1.js"></script>
    <script src="/static/js/bootstrap.min.js"></script>
    <#--<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>-->
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-offset-3 col-md-6">
            <form class="form-horizontal" action="/user/login" method="post" onsubmit="return loginCheck()">
                <br>
                <br>
                <br>
                <span class="heading">CEO/董事长·专项任务后台管理</span>
                <br>
                <br>
                <br>
                <div id="div_err">
                    <p>
                        <span id="message" style="color: rgb(241, 0, 0);">${msg!" "}</span>
                    </p>
                </div>
                <div class="form-group">
                    <div style="position: absolute; left: 40px; top: 10px; width: 40px; height: 40px; line-height: 40px; text-align: center">
                        <span class="glyphicon glyphicon-user"></span>
                    </div>
                    <input type="text" class="form-control" id="account" name="account" placeholder="账  号">
                </div>
                <div class="form-group help">
                    <div style="position: absolute; left: 40px; top: 10px; width: 40px; height: 40px; line-height: 40px; text-align: center">
                        <span class="glyphicon glyphicon-lock"></span>
                    </div>
                    <input type="password" class="form-control" id="password" name="password" placeholder="密  码">
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
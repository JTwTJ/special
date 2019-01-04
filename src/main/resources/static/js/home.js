
/*
 * 判断是登录账号和密码是否为空
 */
function loginCheck() {
    var account = $("#account").val();
    var password = $("#password").val();
    if(account=="" || password=="")
    {
        $("#div_err").html("<p><span id=\"message\" class=\"glyphicon glyphicon-warning-sign\" style=\"color: rgb(241, 0, 0);\"> 账号或密码不能为空！</span></p>");
        return false;
    }
    return true;
}
/*修改密码*/
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
        jQuery.post("/user/updatePassword", {
            "oldPwd": oldPwd,
            "newPwd": newPwd,
            "token": $.cookie("token")
        }, function (data) {
            if (data.ok) {
                $("#span01").html("<font color='red'>修改成功!</font>");
                return true;
            }
            $("#span01").html("<font color='red'>" + data.error + "</font>");
            return false;
        }, "json");
    }
}
    /*注销用户登录*/
    function logout() {
        var token = $.cookie("token");
        jQuery.post("/user/logout", {"token": token}, function (data) {
            if (data.ok) {
                window.location.href = "/user/index";
            }
        }, "json");
    }
    /*生日模块*/
    function birth() {
        console.dir("hahahahahaha");
        var token = $.cookie("token");
        jQuery.post("/user/birth", {"token": token}, function (data) {
            if (data.ok) {
                window.location.href = "/templates/supervise-list";
            }
        }, "json");
    }

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

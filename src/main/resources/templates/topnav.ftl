<div class="navbar-header">
	<a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i class="fa fa-bars"></i> </a>
</div>
<ul class="nav navbar-top-links navbar-right notification-menu">
	<li class="user-dropdown">
        <a href="#" class="btn  dropdown-toggle" data-toggle="dropdown"> <img src="/static/images/photos/user-avatar.png" alt="" width="20">
            <span>${username! " "}</span>
	    <span class="caret"></span>
	    </a>
		<ul class="dropdown-menu dropdown-menu-usermenu pull-right">
			<li><a data-toggle="modal" data-target="#editPwd"><i class="fa fa-user"></i> 修改密码</a></li>
			<li><a onclick="logout()"><i class="fa fa-cog"></i> 注销</a></li>
		</ul></li>
</ul>
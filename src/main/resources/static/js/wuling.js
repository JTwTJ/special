//加载左侧导航
$("#leftnav").load('/leftnav', function(response,status,xhr){
    if(status=='success'){
        //加载完成执行导航组件
        $('#side-menu').metisMenu();
    }
});
//加载顶部导航
$("#topnav").load('/topnav',function(response,status,xhr){
    if(status=='success'){
        //加载完成执行按钮点击事件
        $('.navbar-minimalize').click(function () {
            $("body").toggleClass("mini-navbar");
            SmoothlyMenu();
        });
    }
});

$(document).ready(function () {
    // Add body-small class if window less than 768px
    if ($(this).width() < 769) {
        $('body').addClass('body-small')
    } else {
        $('body').removeClass('body-small')
    }
    // Collapse ibox function
    $('.collapse-link').click(function () {
        var ibox = $(this).closest('div.ibox');
        var button = $(this).find('i');
        var content = ibox.find('div.ibox-content');
        content.slideToggle(200);
        button.toggleClass('fa-chevron-up').toggleClass('fa-chevron-down');
        ibox.toggleClass('').toggleClass('border-bottom');
        setTimeout(function () {
            ibox.resize();
            ibox.find('[id^=map-]').resize();
        }, 50);
    });

    // Close ibox function
    $('.close-link').click(function () {
        var content = $(this).closest('div.ibox');
        content.remove();
    });

    // Close menu in canvas mode
    $('.close-canvas-menu').click(function () {
        $("body").toggleClass("mini-navbar");
        SmoothlyMenu();
    });

    // Open close right sidebar
    $('.right-sidebar-toggle').click(function () {
        $('#right-sidebar').toggleClass('sidebar-open');
    });

    // Initialize slimscroll for right sidebar
   $('.sidebar-container').slimScroll({
        height: '100%',
        railOpacity: 0.4,
        wheelStep: 10
    });

    // Open close small chat
    $('.open-small-chat').click(function () {
        $(this).children().toggleClass('fa-comments').toggleClass('fa-remove');
        $('.small-chat-box').toggleClass('active');
    });

    // Initialize slimscroll for small chat
    $('.small-chat-box .content').slimScroll({
        height: '234px',
        railOpacity: 0.4
    });

    $('.check-link').click(function () {
        var button = $(this).find('i');
        var label = $(this).next('span');
        button.toggleClass('fa-check-square').toggleClass('fa-square-o');
        label.toggleClass('todo-completed');
        return false;
    });

    
    // Tooltips demo
    $('.tooltip-demo').tooltip({
        selector: "[data-toggle=tooltip]",
        container: "body"
    });

    // Move modal to body
    // Fix Bootstrap backdrop issu with animation.css
    $('.modal').appendTo("body");

    // Full height of sidebar
    function fix_height() {
        var heightWithoutNavbar = $("body > #wrapper");
        $(".sidebard-panel").css("min-height", heightWithoutNavbar + "px");

        var navbarHeigh = $('nav.navbar-default').height()+61;
        var wrapperHeigh = $('#page-wrapper').height()+61;

        if (navbarHeigh > wrapperHeigh) {
            $('#page-wrapper').css("min-height", navbarHeigh + "px");
        }

        if (navbarHeigh < wrapperHeigh) {
            $('#page-wrapper').css("min-height", $(window).height() + "px");
        }

        if ($('body').hasClass('fixed-nav')) {
            $('#page-wrapper').css("min-height", $(window).height() + "px");
        }

    }

    fix_height();

    // Fixed Sidebar
    $(window).bind("load", function () {
        if ($("body").hasClass('fixed-sidebar')) {
            $('.sidebar-scroll').slimScroll({
                height: '100%',
                railVisible: false,
                color:"#65cea7",
                opacity:.8,
                size: '4px',
                borderRadius: '0',
                railBorderRadius: '0',
                distance:0
            });
        }
    });

    // Move right sidebar top after scroll
    $(window).scroll(function () {
        if ($(window).scrollTop() > 0 && !$('body').hasClass('fixed-nav')) {
            $('#right-sidebar').addClass('sidebar-top');
        } else {
            $('#right-sidebar').removeClass('sidebar-top');
        }
    });

    $(window).bind("load resize scroll", function () {
        if (!$("body").hasClass('body-small')) {
            fix_height();
        }
    });

    $("[data-toggle=popover]").popover();

    // Add slimscroll to element
    $('.full-height-scroll').slimscroll({
        height: '100%'
    })
});


// Minimalize menu when screen is less than 768px
$(window).bind("resize", function () {
    if ($(this).width() < 769) {
        $('body').addClass('body-small')
    } else {
        $('body').removeClass('body-small')
    }
});

// Local Storage functions
// Set proper body class and plugins based on user configuration
$(document).ready(function () {
    if (localStorageSupport) {

        var collapse = localStorage.getItem("collapse_menu");
        var fixedsidebar = localStorage.getItem("fixedsidebar");
        var fixednavbar = localStorage.getItem("fixednavbar");
        var boxedlayout = localStorage.getItem("boxedlayout");
        var fixedfooter = localStorage.getItem("fixedfooter");

        var body = $('body');

        if (fixedsidebar == 'on') {
            body.addClass('fixed-sidebar');
            $('.sidebar-collapse').slimScroll({
                height: '100%',
                railOpacity: 0.9
            });
        }

        if (collapse == 'on') {
            if (body.hasClass('fixed-sidebar')) {
                if (!body.hasClass('body-small')) {
                    body.addClass('mini-navbar');
                }
            } else {
                if (!body.hasClass('body-small')) {
                    body.addClass('mini-navbar');
                }

            }
        }

        if (fixednavbar == 'on') {
            $(".navbar-static-top").removeClass('navbar-static-top').addClass('navbar-fixed-top');
            body.addClass('fixed-nav');
        }

        if (boxedlayout == 'on') {
            body.addClass('boxed-layout');
        }

        if (fixedfooter == 'on') {
            $(".footer").addClass('fixed');
        }
    }
});

// check if browser support HTML5 local storage
function localStorageSupport() {
    return (('localStorage' in window) && window['localStorage'] !== null)
}

// For demo purpose - animation css script
function animationHover(element, animation) {
    element = $(element);
    element.hover(
        function () {
            element.addClass('animated ' + animation);
        },
        function () {
            //wait for animation to finish before removing classes
            window.setTimeout(function () {
                element.removeClass('animated ' + animation);
            }, 2000);
        });
}

function SmoothlyMenu() {
    if (!$('body').hasClass('mini-navbar') || $('body').hasClass('body-small')) {
        // Hide menu in order to smoothly turn on when maximize menu
        $('#side-menu','#side-head').hide();
        //$().hide();
        // For smoothly turn on menu
        setTimeout(
            function () {
                $('#side-menu','#side-head').fadeIn(200);
            }, 200);
    } else if ($('body').hasClass('fixed-sidebar')) {
        $('#side-menu','#side-head').hide();
        setTimeout(
            function () {
                $('#side-menu').fadeIn(400)

            }, 100);
    } else {
        // Remove all inline style from jquery fadeIn function to reset menu state
        $('#side-menu').removeAttr('style');
    }
};
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
        jQuery.post("/updatePassword", {
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
    jQuery.post("/logout", {"token": $.cookie("token")}, function (data) {
        if (data.ok) {
            /*$.cookie("token", null);*/
            $.cookie('token', '', { expires: -1 });
            window.location.href = "/index";
        }
    }, "json");
}
/*返回查询列表信息*/
/*function queryDictionaryList() {
    $.get("/dictionary/queryList", function (data) {
        console.dir(data.plate)
        /!*$("#plateList").html("<select th:each='item:${data.plate}'  class='form-control' id='plate' name='plate'>\n" +
            "<option value=\"\">--选择--</option>\n" +
            "<option th:text='${item.value}'></option>\n" +
            "</select>")*!/
        var i = 0;
        for (i; i< data.plate.length; i++) {
            $("#option").append("<option value='${data.plate[i].value}'></option>")
        }
    })
}*/
function getMyDate(str){
    var oDate = new Date(str),
        oYear = oDate.getFullYear(),
        oMonth = oDate.getMonth()+1,
        oDay = oDate.getDate(),
        oTime = getzf(oMonth) +'/'+ getzf(oDay) +'/'+ getzf(oYear);//最后拼接时间
    return oTime;
}
//补0操作
function getzf(num){
    if(parseInt(num) < 10){
        num = '0'+num;
    }
    return num;
}



package com.jwt.special.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.jwt.special.model.User;
import com.jwt.special.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.applet.resources.MsgAppletViewer;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jiangwentao
 * @date 2018/12/14 0014 下午 1:54
 */
@Controller
@RequestMapping(value = "/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/index")
    public String sendToLogin() {
        log.info("进入登录页面");
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String userLogin(HttpServletRequest request, Model model, @RequestParam(value = "account") String account,
                            @RequestParam(value = "password") String password) {
        account = account.trim();
        password = password.trim();
        User user = userService.findUserByAccount(account);
        if (user == null) {
            model.addAttribute("msg", "账号不存在");
            return "login";
        }
        if (password.equals(user.getPassword())) {
            log.info("跳转到首页");
            return "home";
        } else {
            model.addAttribute("msg", "密码错误!");
            return "login";
        }
    }
}


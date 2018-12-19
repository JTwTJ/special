package com.jwt.special.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jiangwentao
 * @date 2018/12/14 0014 下午 1:54
 */
@Controller
@RequestMapping(value = "/user")
@Slf4j
public class UserController {

    @RequestMapping(value = "/index")
    public String sendToLogin() {
        log.info("进入登录页面");
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String userLogin(HttpServletRequest request, @RequestParam(value = "username", required = false) String username,
                            @RequestParam(value = "password", required = false) String password) {
        System.out.println(username + "1111111111" + password);
        log.info("跳转到首页");
        return "home";
    }
}


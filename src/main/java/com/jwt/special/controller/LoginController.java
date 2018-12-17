package com.jwt.special.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author jiangwentao
 * @date 2018/12/14 0014 下午 1:54
 */
@Controller
@RequestMapping(value = "/user")
@Slf4j
public class LoginController {

    @RequestMapping(value = "/index")
    public ModelAndView sendHello(ModelAndView mav) {
        log.info("跳转freemarker页面");
        mav.addObject("name", "jwt");
        mav.setViewName("login");
        return mav;
    }
}


package com.jwt.special.controller;

import com.jwt.special.web.NeedLoggedUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author jiangwentao
 * @date 2019/1/11 0011 下午 2:15
 */
@Controller
@Slf4j
public class MainController {

    @NeedLoggedUser
    @RequestMapping(value = {"/home"})
    String home() {
        return "index";
    }
    @RequestMapping(value = "/leftnav", method = RequestMethod.GET)
    String leftnav() {
        return "leftnav";
    }

    @RequestMapping(value = "/topnav", method = RequestMethod.GET)
    String topnav() {
        return "topnav";
    }
}

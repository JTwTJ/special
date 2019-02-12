package com.jwt.special.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author jiangwentao
 * @date 2019/2/12 0012 上午 11:37
 */
@Controller
@Slf4j
@RequestMapping(value = "/birthday")
public class BirthdayController {

    @RequestMapping(value = "/list")
    public String list() {
        return "view/birthday/birthday";
    }
}

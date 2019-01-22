package com.jwt.special.controller;

import com.github.pagehelper.PageInfo;
import com.jwt.special.model.Transact;
import com.jwt.special.model.request.TransactQueryParam;
import com.jwt.special.service.TransactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author jiangwentao
 * @date 2019/1/11 0011 下午 2:15
 */
@Controller
@Slf4j
public class MainController {

    @RequestMapping(value = {"/home"}, method = RequestMethod.GET)
     public String home() { return "index"; }

    @RequestMapping(value = "/leftnav", method = RequestMethod.GET)
    public String leftnav() { return "leftnav"; }

    @RequestMapping(value = "/topnav", method = RequestMethod.GET)
    public String topnav() {
        return "topnav";
    }
}

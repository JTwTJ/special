package com.jwt.special.controller;

import com.github.pagehelper.PageInfo;
import com.jwt.special.model.dto.TransactDto;
import com.jwt.special.service.TransactService;
import com.jwt.special.web.NeedLoggedUser;
import com.jwt.special.web.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jiangwentao
 * @date 2019/1/11 0011 下午 2:15
 */
@Controller
@Slf4j
public class MainController {

    @Autowired
    private TransactService transactService;

    @RequestMapping(value = {"/home"}, method = RequestMethod.GET)
     public String home() { return "index"; }

    @RequestMapping(value = "/leftnav", method = RequestMethod.GET)
    public String leftnav() { return "leftnav"; }

    @RequestMapping(value = "/topnav", method = RequestMethod.GET)
    public String topnav() {
        return "topnav";
    }

    @RequestMapping(value = "/supervise", method = RequestMethod.GET)
    public String supervise(ModelMap map) {
        /*PageInfo<TransactDto> page = transactService.pager();*/
        return "view/supervise/supervise-list";
    }
}

package com.jwt.special.controller;

import com.jwt.special.web.NeedLoggedUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jiangwentao
 * @date 2019/1/2 0002 下午 6:15
 */
@Controller
@RequestMapping("/links")
@Slf4j
public class LinksController {

    @RequestMapping(value = "/queryCurrentUserSetUrl", method = RequestMethod.POST)
    @NeedLoggedUser
    @ResponseBody

}

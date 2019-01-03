package com.jwt.special.controller;

import com.alibaba.fastjson.JSON;
import com.jwt.special.model.User;
import com.jwt.special.model.UserLinks;
import com.jwt.special.model.vo.LinksVo;
import com.jwt.special.service.UserLinksService;
import com.jwt.special.util.UserUtil;
import com.jwt.special.web.NeedLoggedUser;
import com.jwt.special.web.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author jiangwentao
 * @date 2019/1/2 0002 下午 6:15
 */
@Controller
@RequestMapping("/links")
@Slf4j
public class LinksController {

    @Autowired
    private UserLinksService userLinksService;

    /**
     * 根据用户信息查询权限菜单
     * @return
     */
    @RequestMapping(value = "/queryCurrentUserSetUrl", method = RequestMethod.POST)
    @NeedLoggedUser
    @ResponseBody
    public Result<List<UserLinks>> queryCurrentUserSetUrl() {
        User userOper = UserUtil.getCurrentUser();
        log.info("current user user:{}", JSON.toJSONString(userOper));
        if (userOper == null) {
            return Result.fail("当前用户不存在!");
        }
        Long userId =  userOper.getUserId();
        List<UserLinks> linksList = userLinksService.queryByUserId(userId);
        System.out.println(linksList);

        return Result.ok(linksList);
    }
}

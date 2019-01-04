package com.jwt.special.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jwt.special.component.LoginUserInfo;
import com.jwt.special.model.User;
import com.jwt.special.model.dto.UserDto;
import com.jwt.special.service.UserService;
import com.jwt.special.util.UserUtil;
import com.jwt.special.web.NeedLoggedUser;
import com.jwt.special.web.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

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
    @Autowired
    private LoginUserInfo loginUserInfo;

    /**
     * 登录页面
     * @return
     */
    @RequestMapping(value = "/index")
    public String sendToLogin() {
        log.info("进入登录页面");
        return "login";
    }

    /**
     * 登录功能实现
     * @param request
     * @param model
     * @param account
     * @param password
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String userLogin(HttpServletRequest request, Model model, @RequestParam(value = "account") String account,
                            @RequestParam(value = "password") String password) {
        account = account.trim();
        password = password.trim();
        User user = userService.findUserByAccount(account);
        if (user == null) {
            model.addAttribute("msg", "账号不存在！");
            return "login";
            /*return Result.fail("账号不存在!");*/
        }
        if (password.equals(user.getPassword())) {
            String token = UUID.randomUUID().toString().replaceAll("-", "");
            loginUserInfo.setUserInfo(token, UserDto.convert(user));
            model.addAttribute("username", user.getUsername());
            model.addAttribute("token", token);
            return "home";
            /*return Result.ok(token);*/
        } else {
            model.addAttribute("msg", "密码错误!");
            return "login";
            /*return  Result.fail("密码错误!");*/
        }
    }

    /**
     * 修改密码
     * @param oldPwd
     * @param newPwd
     * @return
     */
    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    @ResponseBody
    @NeedLoggedUser
    public Result<Boolean> updatePassword(@RequestParam(value = "oldPwd") String oldPwd, @RequestParam(value = "newPwd") String newPwd) {
        User userOper = UserUtil.getCurrentUser();
        log.info("update password user user:{}", JSON.toJSONString(userOper));
        try {
            User user = UserUtil.getCurrentUser();
            if (user == null) {
                log.warn("update password fail. user={} not find.", user);
                return Result.fail("修改密码失败，当前用户记录不存在!");
            }
            if (!user.getPassword().equals(oldPwd)) {
                log.warn("updatePassword fail. password={}/oldPwd={} ", user.getPassword(), oldPwd);
                return Result.fail("修改密码失败，原密码错误!");
            }
            userService.updatePassword(user.getUserId(), newPwd);
            return Result.ok(Boolean.TRUE);
        } catch (Exception e) {
            log.error("update password error.error:{}", e.getMessage());
            return Result.fail("修改密码失败!");
        }
    }

    /**
     * 用户注销
     * @param token
     * @return
     */
    @NeedLoggedUser
    @ResponseBody
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public Result<Boolean> logout(String token) {
        loginUserInfo.clearUserInfo(token);
        return Result.ok(Boolean.TRUE);
    }

    @NeedLoggedUser
    @ResponseBody
    @RequestMapping(value = "/birth", method = RequestMethod.POST)
    public Result<Boolean> birthPage() {
        System.out.println("hahahahah");
        return Result.ok(Boolean.TRUE);
    }

}


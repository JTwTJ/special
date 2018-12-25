package com.jwt.special.controller;

import com.jwt.special.component.LoginUserInfo;
import com.jwt.special.model.User;
import com.jwt.special.model.dto.UserDto;
import com.jwt.special.service.UserService;
import com.jwt.special.web.NeedLoggedUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
        }
        if (password.equals(user.getPassword())) {
            String token = UUID.randomUUID().toString().replaceAll("-", "");
            loginUserInfo.setUserInfo(token, UserDto.convert(user));
            model.addAttribute("username", user.getUsername());
            return "home";
        } else {
            model.addAttribute("msg", "密码错误!");
            return "login";
        }
    }
}


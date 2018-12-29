package com.jwt.special.web;

import com.alibaba.fastjson.JSON;
import com.jwt.special.component.LoginUserInfo;
import com.jwt.special.model.User;
import com.jwt.special.service.UserService;
import com.jwt.special.util.SpringContextUtils;
import com.jwt.special.util.UserUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录拦截器
 * @author jiangwentao
 * @date 2018/12/26 0026 下午 6:06
 */

@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    private UserService userService;
    private LoginUserInfo loginUserInfo;

    public LoginInterceptor () {

    }

    public LoginInterceptor (UserService userService, LoginUserInfo loginUserInfo) {
        this.userService = userService;
        this.loginUserInfo = loginUserInfo;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
    throws Exception {
        UserUtil.clearCurrentUser();
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
    throws Exception {
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getParameter("token");
        boolean isPut = false;

        if (!StringUtils.isEmpty(token)) {
            isPut = putUserInfo(request, token);
        }
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            NeedLoggedUser userAnnotation = handlerMethod.getMethod().getAnnotation(NeedLoggedUser.class);

            if (userAnnotation == null) {
                userAnnotation = handlerMethod.getBeanType().getAnnotation(NeedLoggedUser.class);
            }
            if (userAnnotation != null) {
                if (isPut) {
                    return true;
                } else {
                    log.warn("not login user to operation:{}", request.getRequestURI());
                    forbitOperation(response);
                    return false;
                }
            }
        }
        return true;
    }


   /**
     * 将用户信息存入当前线程
     * @param req
     * @param token
     * @return
     */

    private boolean putUserInfo(HttpServletRequest req, String token) {
        Long userId = getLoginUserInfo().getUserInfo(token).getUserId();
        if (userId != null) {
            User user = getUserService().getUserById(userId);
            if (user != null) {
                UserUtil.putCurrentUser(user);
                return true;
            }
        }
        return false;
    }

    public LoginUserInfo getLoginUserInfo() {
        if (loginUserInfo == null) {
            loginUserInfo = SpringContextUtils.getBean(LoginUserInfo.class);
        }
        return loginUserInfo;
    }

    public void setLoginUserInfo(LoginUserInfo loginUserInfo) {
        this.loginUserInfo = loginUserInfo;
    }

    public UserService getUserService() {
        if (userService == null) {
            userService = SpringContextUtils.getBean(UserService.class);
        }
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    private void forbitOperation(HttpServletResponse rsp) throws IOException {
        rsp.getWriter().append(JSON.toJSONString(Result.fail("user.not.login")));
        rsp.setHeader("Content-Type", "text/json");
        rsp.setStatus(401);
    }
}

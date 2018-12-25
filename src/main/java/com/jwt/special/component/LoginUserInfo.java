package com.jwt.special.component;

import com.alibaba.fastjson.JSON;
import com.jwt.special.model.User;
import com.jwt.special.model.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author jiangwentao
 * @date 2018/12/25 0025 下午 2:51
 */
@Component
public class LoginUserInfo {

    @Autowired
    private RedisComponent redisComponent;

    /** 设置用户登录超时时间: 30毫秒 单位:毫秒 */
    private Long LoginTimeOut = 1000*60*60*3L;
    /** 设置用户登录超时时间: 30分钟 单位:分钟 */
    private  Long RedisLoginTimeOut = 60*24*30L;

    public User getUserInfo(String key){
        String user = redisComponent.get(key);
        if(user != null){
            UserDto userBo =JSON.parseObject(user, UserDto.class);
            // 验证上次登录时间
            if(new Date().getTime() - userBo.getLoginTime().getTime() > LoginTimeOut){
                // 更新Redis中保存的用户信息
                this.setUserInfo(key, userBo);
            }
            return userBo;
        }
        return new User();
    }

    public void setUserInfo(String key, UserDto userVo){
        userVo.setLoginTime(new Date());
        redisComponent.set(key, JSON.toJSONString(userVo), RedisLoginTimeOut, TimeUnit.MINUTES);
    }

    public void clearUserInfo(String key){
        redisComponent.delete(key);
    }

}

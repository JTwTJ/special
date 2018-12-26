package com.jwt.special.service.impl;

import com.jwt.special.dao.UserMapper;
import com.jwt.special.model.User;
import com.jwt.special.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jiangwentao
 * @date 2018/12/24 0024 下午 1:36
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User findUserByAccount(String account) {
        return userMapper.findUserByAccount(account);
    }

    @Override
    public Integer updatePassword(long userId, String newPwd) {
        return userMapper.updatePassword(userId, newPwd);
    }
}

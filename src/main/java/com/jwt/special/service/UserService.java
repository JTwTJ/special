package com.jwt.special.service;

import com.jwt.special.model.User;

/**
 * @author jiangwentao
 * @date 2018/12/24 0024 下午 1:35
 */
public interface UserService {
    /** 通过账户查询用户 */
    User findUserByAccount(String account);
    /** 修改密码 */
    Integer updatePassword(long userId, String newPwd);
    /** 通过id查询用户 */
    User getUserById(long userId);
}

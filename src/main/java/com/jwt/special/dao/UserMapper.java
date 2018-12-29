package com.jwt.special.dao;

import com.jwt.special.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author jiangwentao
 * @date 2018/12/24 0024 下午 1:49
 */
@Mapper
public interface UserMapper {
    /** 通过账号查询用户 */
    User findUserByAccount(@Param("account") String account);
    /** 修改密码 */
    Integer updatePassword(@Param("userId") long userId, @Param("newPwd") String newPwd);
    /** 通过id查询用户 */
    User getUserById(@Param("userId") long userId);
}

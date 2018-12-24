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
}

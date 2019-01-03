package com.jwt.special.dao;

import com.jwt.special.model.UserLinks;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author jiangwentao
 * @date 2019/1/3 0003 下午 4:33
 */
@Mapper
public interface UserLinksMapper {

    List<UserLinks> queryByUserId(@Param("userId") long userId);
}

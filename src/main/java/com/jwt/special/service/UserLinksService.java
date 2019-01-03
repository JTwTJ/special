package com.jwt.special.service;

import com.jwt.special.model.UserLinks;

import java.util.List;

/**
 * @author jiangwentao
 * @date 2019/1/3 0003 下午 4:31
 */
public interface UserLinksService {

    List<UserLinks> queryByUserId(long userId);
}

package com.jwt.special.service.impl;

import com.jwt.special.dao.UserLinksMapper;
import com.jwt.special.model.UserLinks;
import com.jwt.special.service.UserLinksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jiangwentao
 * @date 2019/1/3 0003 下午 4:32
 */
@Service
public class UserLinksServiceImpl implements UserLinksService {

    @Autowired
    private UserLinksMapper userLinksMapper;

    @Override
    public List<UserLinks> queryByUserId(long userId) {
        return userLinksMapper.queryByUserId(userId);
    }
}

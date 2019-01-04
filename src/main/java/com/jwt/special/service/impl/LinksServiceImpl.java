package com.jwt.special.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.jwt.special.dao.LinksMapper;
import com.jwt.special.model.Links;
import com.jwt.special.service.LinksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jiangwentao
 * @date 2019/1/3 0003 下午 4:24
 */
@Service
public class LinksServiceImpl implements LinksService {

    @Autowired
    private LinksMapper linksMapper;

    @Override
    public List<Links> findAll() {
        return linksMapper.findAll();
    }

    @Override
    public Links getById(String linkId) {
        if(StringUtils.isEmpty(linkId)){
            return null;
        }
        return linksMapper.getById(linkId);
    }
}

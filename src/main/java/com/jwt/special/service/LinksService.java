package com.jwt.special.service;

import com.jwt.special.model.Links;

import java.util.List;

/**
 * @author jiangwentao
 * @date 2019/1/3 0003 下午 4:23
 */
public interface LinksService {

    List<Links> findAll();

    Links getById(String linkId);
}

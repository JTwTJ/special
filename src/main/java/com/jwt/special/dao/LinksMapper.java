package com.jwt.special.dao;

import com.jwt.special.model.Links;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author jiangwentao
 * @date 2019/1/3 0003 下午 4:25
 */
@Mapper
public interface LinksMapper {

    List<Links> findAll();

    Links getById(@Param("linkId") String linkId);

}

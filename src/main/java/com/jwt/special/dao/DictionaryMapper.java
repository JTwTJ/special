package com.jwt.special.dao;

import com.jwt.special.model.Dictionary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author jiangwentao
 * @date 2019/1/23 0023 下午 1:43
 */
@Mapper
public interface DictionaryMapper {

    Dictionary findByGroupCodeAndKey(@Param("key") String key, @Param("groupCode") String groupCode);

    List<Dictionary> findByGroupCode(@Param("groupCode") String groupCode);
}

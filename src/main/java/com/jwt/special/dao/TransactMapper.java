package com.jwt.special.dao;

import com.jwt.special.model.Transact;
import com.jwt.special.model.dto.TransactDto;
import com.jwt.special.model.request.TransactQueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TransactMapper {

    /**
     * 分页查询
     * @param transactQueryParam
     * @return
     */
    List<Transact> pager(TransactQueryParam transactQueryParam);

    int deleteByPrimaryKey(Long transactId);

    int insert(Transact record);

    int insertSelective(Transact record);

    Transact selectByPrimaryKey(Long transactId);

    int updateByPrimaryKeySelective(Transact record);

    int updateByPrimaryKey(Transact record);
}
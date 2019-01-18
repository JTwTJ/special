package com.jwt.special.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jwt.special.dao.TransactMapper;
import com.jwt.special.model.Transact;
import com.jwt.special.model.dto.TransactDto;
import com.jwt.special.model.request.TransactQueryParam;
import com.jwt.special.service.TransactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jiangwentao
 * @date 2019/1/17 0017 下午 3:49
 */
@Service
@Slf4j
public class TransactServiceImpl implements TransactService {

    @Autowired
    private TransactMapper transactMapper;

    @Override
    public PageInfo<Transact> pager(TransactQueryParam transactQueryParam) {

        Page<Object> page = PageHelper.startPage(transactQueryParam.getPageNo(), transactQueryParam.getPageSize());
        List<Transact> transact = transactMapper.pager(transactQueryParam);
        PageInfo<Transact> pageInfo = new PageInfo<>(transact);
        pageInfo.setPageNum(page.getPageNum());
        pageInfo.setPageSize(page.getPageSize());
        pageInfo.setTotal(page.getTotal());
        return pageInfo;
    }
}


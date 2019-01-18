package com.jwt.special.service;

import com.github.pagehelper.PageInfo;
import com.jwt.special.model.Transact;
import com.jwt.special.model.request.TransactQueryParam;

/**
 * @author jiangwentao
 * @date 2019/1/17 0017 下午 3:48
 */
public interface TransactService {

    PageInfo<Transact> pager(TransactQueryParam transactQueryParam);
}

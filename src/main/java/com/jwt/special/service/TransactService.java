package com.jwt.special.service;

import com.github.pagehelper.PageInfo;
import com.jwt.special.model.Dictionary;
import com.jwt.special.model.Transact;
import com.jwt.special.model.dto.TransactDto;
import com.jwt.special.model.request.TransactQueryParam;

import java.util.List;
import java.util.Map;

/**
 * @author jiangwentao
 * @date 2019/1/17 0017 下午 3:48
 */
public interface TransactService {

    /**
     * 分页查询
     * @param transactQueryParam
     * @return
     */
    PageInfo<TransactDto> pager(TransactQueryParam transactQueryParam);

    Map<String,Dictionary> getDictionary(String plate, String plateGroupCode,String companyName, String companyNameGroupCode,
                                               String functions,String functionsGroupCode,String leader,String leaderGroupCode);
}

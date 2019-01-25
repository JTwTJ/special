package com.jwt.special.service;

import com.jwt.special.model.Dictionary;

import java.util.List;
import java.util.Map;

/**
 * @author jiangwentao
 * @date 2019/1/24 0024 上午 10:07
 */
public interface DictionaryService {

    /**
     * 返回查询列表
     * @return
     */
   Map<String, List<Dictionary>> queryList();
}

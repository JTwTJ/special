package com.jwt.special.service.impl;

import com.jwt.special.dao.DictionaryMapper;
import com.jwt.special.model.Dictionary;
import com.jwt.special.model.enums.DictionaryGroup;
import com.jwt.special.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jiangwentao
 * @date 2019/1/24 0024 上午 10:22
 */
@Service
public class DictionaryServiceImpl implements DictionaryService {

    @Autowired
    private DictionaryMapper dictionaryMapper;

    @Override
    public Map<String, List<Dictionary>> queryList() {

        List<Dictionary> plateList = dictionaryMapper.findByGroupCode(DictionaryGroup.plate.getGroupCode());
        List<Dictionary> companyList = dictionaryMapper.findByGroupCode(DictionaryGroup.companyName.getGroupCode());
        List<Dictionary> functionList = dictionaryMapper.findByGroupCode(DictionaryGroup.abilityCenter.getGroupCode());
        List<Dictionary> leaderList = dictionaryMapper.findByGroupCode(DictionaryGroup.transDepartMent.getGroupCode());

        Map<String, List<Dictionary>> map = new HashMap<>();
        map.put("plate", plateList);
        map.put("companyName", companyList);
        map.put("functions", functionList);
        map.put("leader", leaderList);
        return map;
    }
}

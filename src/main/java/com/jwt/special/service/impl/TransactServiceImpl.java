package com.jwt.special.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jwt.special.dao.DictionaryMapper;
import com.jwt.special.dao.TransactMapper;
import com.jwt.special.model.Dictionary;
import com.jwt.special.model.Transact;
import com.jwt.special.model.dto.TransactDto;
import com.jwt.special.model.enums.DictionaryGroup;
import com.jwt.special.model.request.TransactQueryParam;
import com.jwt.special.service.TransactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jiangwentao
 * @date 2019/1/17 0017 下午 3:49
 */
@Service
@Slf4j
public class TransactServiceImpl implements TransactService {

    @Autowired
    private TransactMapper transactMapper;

    @Autowired
    private DictionaryMapper dictionaryMapper;

    @Override
    public PageInfo<TransactDto> pager(TransactQueryParam transactQueryParam) {

        Page<Object> page = PageHelper.startPage(transactQueryParam.getPageNo(), transactQueryParam.getPageSize());
        List<Transact> transactList = transactMapper.pager(transactQueryParam);

        List<TransactDto> transactDtoList = new ArrayList<>();
        TransactDto transactDto = null;
        for (Transact transact : transactList) {
            Map<String, Dictionary> map = getDictionary(transact.getPlate(), DictionaryGroup.plate.getGroupCode(),
                    transact.getCompanyName(), DictionaryGroup.companyName.getGroupCode(),
                    transact.getFunctions(), DictionaryGroup.abilityCenter.getGroupCode(), transact.getLeader(),
                    DictionaryGroup.transDepartMent.getGroupCode());
            transactDto = new TransactDto();
            transactDto.setTransactId(transact.getTransactId());
            transactDto.setFileName(transact.getFileName());
            transactDto.setFileTime(transact.getFileTime());
            transactDto.setPhone(transact.getPhone());
            if (null == map.get("plate")) {
                transactDto.setPlateKey("");
                transactDto.setPlateValue("");
            } else {
                transactDto.setPlateKey(map.get("plate").getKey());
                transactDto.setPlateValue(map.get("plate").getValue());
            }
            if (null == map.get("companyName")) {
                transactDto.setCompanyNameKey("");
                transactDto.setCompanyNameValue("");
            } else {
                transactDto.setCompanyNameKey(map.get("companyName").getKey());
                transactDto.setCompanyNameValue(map.get("companyName").getValue());
            }
            if (null == map.get("functions")) {
                transactDto.setFunctionsKey("");
                transactDto.setFunctionsValue("");
            } else {
                transactDto.setFunctionsKey(map.get("functions").getKey());
                transactDto.setFunctionsValue(map.get("functions").getValue());
            }
            if (null == map.get("leader")) {
                transactDto.setLeaderKey("");
                transactDto.setLeaderValue("");
            } else {
                transactDto.setLeaderKey(map.get("leader").getKey());
                transactDto.setLeaderValue(map.get("leader").getValue());
            }
            transactDto.setRemark(transact.getRemark());
            transactDto.setHandleTime(transact.getHandleTime());
            transactDto.setHandleIdea(transact.getHandleIdea());
            transactDto.setOperator(transact.getOperator());
            transactDto.setCreateTime(transact.getCreateTime());
            transactDto.setUpdateTime(transact.getUpdateTime());
            transactDtoList.add(transactDto);
        }
        /*System.out.println(transactList);*/
       /* System.out.println(transactDtoList);*/

        PageInfo<TransactDto> pageInfo = new PageInfo<>();
        pageInfo.setPageNum(page.getPageNum());
        pageInfo.setList(transactDtoList);
        pageInfo.setPageSize(page.getPageSize());
        pageInfo.setTotal(page.getTotal());
        pageInfo.setPages(page.getPages());
        /*System.out.println(pageInfo);*/
        return pageInfo;
    }

    /**
     *获取有效的板块，公司名称，职能中心，流转部门
     * @param plate 板块
     * @param plateGroupCode
     * @param companyName 公司名称
     * @param companyNameGroupCode
     * @param functions 职能中心
     * @param functionsGroupCode
     * @param leader 流转部门
     * @param leaderGroupCode
     * @return
     */
    @Override
    public Map<String,Dictionary> getDictionary(String plate, String plateGroupCode,String companyName, String companyNameGroupCode,
                                                       String functions,String functionsGroupCode,String leader,String leaderGroupCode){
        Map<String,Dictionary> map = new HashMap<>();
        if (StringUtils.isEmpty(plate)) {

        }
        Dictionary plateDictionary = dictionaryMapper.findByGroupCodeAndKey(plate, plateGroupCode);
        Dictionary companyNameDictionary = dictionaryMapper.findByGroupCodeAndKey(companyName, companyNameGroupCode);
        Dictionary functionsDictionary = dictionaryMapper.findByGroupCodeAndKey(functions, functionsGroupCode);
        Dictionary leaderDictionary = dictionaryMapper.findByGroupCodeAndKey(leader, leaderGroupCode);

        map.put("plate",plateDictionary);
        map.put("companyName",companyNameDictionary);
        map.put("functions",functionsDictionary);
        map.put("leader",leaderDictionary);
        return map;
    }
}


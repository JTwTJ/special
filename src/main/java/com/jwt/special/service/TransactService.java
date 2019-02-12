package com.jwt.special.service;

import com.github.pagehelper.PageInfo;
import com.jwt.special.model.Dictionary;
import com.jwt.special.model.Transact;
import com.jwt.special.model.dto.TransactDto;
import com.jwt.special.model.request.TransactAddParam;
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

    /**
     * 获取下拉菜单信息
     * @param plate
     * @param plateGroupCode
     * @param companyName
     * @param companyNameGroupCode
     * @param functions
     * @param functionsGroupCode
     * @param leader
     * @param leaderGroupCode
     * @return
     */
    Map<String,Dictionary> getDictionary(String plate, String plateGroupCode,String companyName, String companyNameGroupCode,
                                               String functions,String functionsGroupCode,String leader,String leaderGroupCode);

    /**
     * 添加督办
     * @param transactAddParam
     */
    void add(TransactAddParam transactAddParam);

    /**
     * 通过id查询督办信息
     * @param transactId
     * @return
     */
    TransactDto queryById(Long transactId);

    /**
     * 修改督办
     * @param transactAddParam
     */
    void update(TransactAddParam transactAddParam);

    /**
     * 删除督办信息
     * @param transactId
     */
    void delete(Long transactId);

    /**
     * 查询所有
     * @return
     */
    List<TransactDto> queryAll();

    /**
     * 对象转换
     * @param transactList
     * @return
     */
    List<TransactDto> convertToDto(List<Transact> transactList);
}

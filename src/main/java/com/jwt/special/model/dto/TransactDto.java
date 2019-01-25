package com.jwt.special.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jwt.special.model.enums.Handle;
import com.jwt.special.model.enums.Sign;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 专项督办请求封装对象
 * @author jiangwentao
 * @date 2019/1/2 0002 下午 4:18
 */
@Data
public class TransactDto implements Serializable {

    public static final long serialVersionUID = 1L;

    /**
     * 督办表主键
     */
    private Long transactId;

    /**
     * 文件名称
     */
    private String fileName;

    /**
     * 收文日期
     */
    private Date fileTime;

    /**
     * 督办申请人电话
     */
    private String phone;

    /**
     * 板块键
     */
    private String plateKey;

    /**
     * 板块值
     */
    private String plateValue;

    /**
     * 公司名称键
     */
    private String companyNameKey;

    /**
     * 公司名称值
     */
    private String companyNameValue;

    /**
     * 职能中心键
     */
    private String functionsKey;

    /**
     * 职能中心值
     */
    private String functionsValue;

    /**
     * 流转部门(领导)键
     */
    private String leaderKey;

    /**
     * 流转部门(领导)值
     */
    private String leaderValue;

    /**
     * 备注
     */
    private String remark;

    /**
     * 批示日期
     */
    private Date handleTime;

    /**
     * 批示意见
     */
    private String handleIdea;

    /**
     * 修改人
     */
    private String operator;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;
}

package com.jwt.special.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * special_transact
 * @author 
 */
@Data
public class Transact implements Serializable {
    /**
     * 主键Id
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
     * 电话
     */
    private String phone;

    /**
     * 板块
     */
    private String plate;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 职能中心
     */
    private String functions;

    /**
     * 流转部门(领导)
     */
    private String leader;

    /**
     * 备注
     */
    private String remark;

    /**
     * 批示日期
     */
    private Date handleTime;

    /**
     * 杜总批示意见
     */
    private String handleIdea;

    /**
     * 最后一次修改人的名字
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

    private static final long serialVersionUID = 1L;

}
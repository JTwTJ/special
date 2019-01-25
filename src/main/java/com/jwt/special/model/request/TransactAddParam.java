package com.jwt.special.model.request;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author jiangwentao
 * @date 2019/1/25 0025 下午 5:11
 */
@Data
public class TransactAddParam implements Serializable {

    private static final long serialVersionUID = 1L;

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

}

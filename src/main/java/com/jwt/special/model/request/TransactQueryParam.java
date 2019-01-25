package com.jwt.special.model.request;
import lombok.Data;

import java.io.Serializable;

/**
 * @author jiangwentao
 * @date 2019/1/17 0017 下午 4:24
 */
@Data
public class TransactQueryParam implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * 电话
     */
    private String phone;
    /**
     * 文件名称
     */
    private String fileName;
    /**
     * 流转部门领导
     */
    private String leader;
    /**
     * 收文开始日期
     */
    private String receiptStartTime;
    /**
     * 收文结束日期
     */
    private String receiptEndTime;
    /**
     * 批示开始日期
     */
    private String handleStartTime;
    /**
     * 批示开始日期
     */
    private String handleEndTime;

    private Integer pageSize = 10;

    private Integer pageNo = 1;
}

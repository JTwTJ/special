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
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date fileTime;

    /**
     * 督办申请人电话
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
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
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
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:SS",timezone="GMT+8")
    private Date updateTime;
}

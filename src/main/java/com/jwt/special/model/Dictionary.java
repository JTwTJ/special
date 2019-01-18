package com.jwt.special.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author jiangwentao
 * @date 2019/1/18 0018 上午 10:44
 */
@Data
public class Dictionary implements Serializable {
    private static final long serialVersionUID = -1L;
    /** 编号 **/
    private Long id;
    /** 分组编码 **/
    private String groupCode;
    /** 分组名称 **/
    private String groupName;
    /** 键 **/
    private String key;
    /** 值 **/
    private String value;
    /** 是否删除 **/
    private boolean isDel;
    /** 创建时间 **/
    private Date createTime;
    /** 修改时间 **/
    private Date updateTime;
}

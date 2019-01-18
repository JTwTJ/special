package com.jwt.special.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jwt.special.model.enums.UserState;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author jiangwentao
 * @date 2018/12/24 0024 上午 11:41
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 5334242068483520259L;
    /** 用户编号 **/
    private Long userId;
    /** 账户 **/
    private String account;
    /** 密码 **/
    @JsonIgnore
    private String password;
    /** 手机号码 **/
    private String mobile;
    /** 用户名称 **/
    private String username;
    /** 状态 **/
    private UserState state;
    /** 部门编号 **/
    private Long departmentId;
    /** 部门名称 **/
    private String departmentName;
    /** 是否删除 **/
    @JsonIgnore
    private boolean isDel;
    /** 创建时间 **/
    private Date createTime;
    /** 修改时间 **/
    private Date updateTime;
}

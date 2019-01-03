package com.jwt.special.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author jiangwentao
 * @date 2019/1/3 0003 下午 4:29
 */
@Data
public class UserLinks implements Serializable {
    private static final long serialVersionUID = 7353956825807073458L;

    /** userId 用户id**/
    private Long userId;
    /** linkid linkid **/
    private String linkId;
    /** 权限设置 字符串 **/
    private String privilege;
}

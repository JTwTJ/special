package com.jwt.special.model.dto;

import lombok.Data;

/**
 * @author jiangwentao
 * @date 2019/1/3 0003 下午 2:35
 */
@Data
public class UserPagePrivilegeDto {
    private String key;
    private String name;

    public UserPagePrivilegeDto() {}
    public UserPagePrivilegeDto(String key, String name) {
        this.key = key;
        this.name = name;
    }
}

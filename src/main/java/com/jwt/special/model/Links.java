package com.jwt.special.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.jwt.special.util.UserPagePrivilegeSerializer;
import lombok.Data;

import java.io.Serializable;

/**
 * @author jiangwentao
 * @date 2019/1/3 0003 下午 2:24
 */
@Data
public class Links implements Serializable {

    private static final long serialVersionUID = -13152462098686094L;
    private String linkId;
    private String name;
    private String parentId;
    @JsonSerialize(using = UserPagePrivilegeSerializer.class)
    private String privilege;
    private boolean isLeaf;
}

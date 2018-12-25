package com.jwt.special.model.dto;

import com.jwt.special.model.User;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * @author jiangwentao
 * @date 2018/12/25 0025 下午 3:47
 */
@Data
public class UserDto extends User implements Serializable {

    private static final long serialVersionUID = -4343890713251406697L;

    /** 登录时间 */
    private Date loginTime;
    private Boolean ifSetLinks=false;

    public static UserDto convert(User user) {
        UserDto userVo = new UserDto();
        BeanUtils.copyProperties(user, userVo);
        return userVo;
    }
}

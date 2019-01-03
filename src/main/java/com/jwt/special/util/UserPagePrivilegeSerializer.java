package com.jwt.special.util;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.jwt.special.model.dto.UserPagePrivilegeDto;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

/**
 * @author jiangwentao
 * @date 2019/1/3 0003 下午 2:32
 */
    public class UserPagePrivilegeSerializer extends JsonSerializer<String> {
    @Override
    public void serialize(String value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
        if(!StringUtils.isEmpty(value)) {
            gen.writeObject(JSON.parseArray(value, UserPagePrivilegeDto.class));
        }
    }
}

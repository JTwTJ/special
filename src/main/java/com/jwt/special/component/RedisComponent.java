package com.jwt.special.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.concurrent.TimeUnit;

/**
 * <Redis常用操作>
 * @author jiangwentao
 * @date 2018/12/25 0025 下午 2:59
 */
@Slf4j
@Component
public class RedisComponent {
    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * <根据key获取value>
     * @param key
     * @return
     */
    public String get(String key) {
        String value = redisTemplate.opsForValue().get(key);
        if (StringUtils.isEmpty(value)) {
            log.info("redis not fund. key={}, value={}", key, value);
        }
        return value;
    }

    /**
     * <根据键值存入redis>
     * @param key 键
     * @param data 值
     * @param timeout 超时时间
     * @param unit 超时时间类型
     */
    public void set(String key, String data, Long timeout, TimeUnit unit) {
        redisTemplate.opsForValue().set(key, data, timeout, unit);
    }

    /**
     * <根据键从redis中删除>
     * @param key
     */
    public void delete(String key) {
        redisTemplate.delete(key);
    }
}

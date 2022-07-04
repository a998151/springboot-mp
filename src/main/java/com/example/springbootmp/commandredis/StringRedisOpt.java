package com.example.springbootmp.commandredis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author BCY
 */
@Component
public class StringRedisOpt {

    @Autowired
    private RedisTemplate<String , String> redisTemplate;

    public String getString(String key){
        return redisTemplate.opsForValue().get(key);
    }

    public void setString(String key , String value){
        redisTemplate.opsForValue().set(key , value);
    }
}

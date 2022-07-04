package com.example.springbootmp.redis;

import com.example.springbootmp.commandredis.StringRedisOpt;
import org.junit.jupiter.api.Test;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author BCY
 */
@SpringBootTest
public class RedisTest {

    @Autowired
    private StringRedisOpt stringRedisOpt;

    @Test
    void test(){
        stringRedisOpt.setString("Hello" , "world");
    }

    @Test
    void redissonTest(){
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://192.168.1.85:6379")
                .setPassword("123456")
                .setDatabase(0);
        RedissonClient redissonClient = Redisson.create(config);
        System.out.println("redissonClient = " + redissonClient);
    }
}

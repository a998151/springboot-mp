package com.example.springbootmp.cache;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

/**
 * @author BCY
 */
@Slf4j
@SpringBootTest
public class CacheTest {

    @Autowired
    private MyCache myCache;

    @Test
    public void test() throws Exception {
        Object hello = myCache.getValue("Hello");
        TimeUnit.SECONDS.sleep(11);

        hello = myCache.getValue("Hello");
        TimeUnit.SECONDS.sleep(11);

        hello = myCache.getValue("Hello");
        TimeUnit.SECONDS.sleep(11);

        log.info("......over");
    }


    @Test
    public void test1() throws Exception {
        Object hello = DemoCache.caches.get("Hello");
        log.info(hello.toString());
        TimeUnit.SECONDS.sleep(12);

        hello = DemoCache.caches.get("Hello");
        TimeUnit.SECONDS.sleep(12);

        log.info("......over");
    }
}

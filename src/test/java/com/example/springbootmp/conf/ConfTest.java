package com.example.springbootmp.conf;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author BCY
 */
@Slf4j
@SpringBootTest
public class ConfTest {

    @Autowired
    private AutoDevConfig autoDevConfig;

    @Test
    public void test(){
        boolean swagger = autoDevConfig.isSwagger();
        log.info("swagger = {}" , swagger);
    }
}

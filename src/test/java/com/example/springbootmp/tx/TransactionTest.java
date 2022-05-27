package com.example.springbootmp.tx;

import com.example.springbootmp.service.UserInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author BCY
 */
@SpringBootTest
public class TransactionTest {

    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void test(){
        userInfoService.insert4();
    }
}

package com.example.springbootmp.hutool;

import cn.hutool.http.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author BCY
 */
@SpringBootTest
public class HutoolTest {


    @Test
    public void test() {
        ContentType contentType = ContentType.valueOf("JSON");
        System.out.println(contentType);
    }
}

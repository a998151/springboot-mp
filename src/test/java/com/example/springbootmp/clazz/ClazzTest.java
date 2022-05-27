package com.example.springbootmp.clazz;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ClassUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * @author BCY
 */
@Slf4j
@SpringBootTest
public class ClazzTest {

    @Test
    public void test() throws ClassNotFoundException {
        List<String> list = new LinkedList<>();
        log.info(list.getClass().getName());
        Class<?> anInt = ClassUtils.forName(list.getClass().getName(), Thread.currentThread().getContextClassLoader());
        log.info(anInt.getSimpleName());
    }
}

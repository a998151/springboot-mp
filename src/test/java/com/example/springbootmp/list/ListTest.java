package com.example.springbootmp.list;

import cn.hutool.core.convert.Convert;
import cn.hutool.json.JSONUtil;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author BCY
 */
public class ListTest {


    @Test
    void test(){
        AtomicLong atomicLong = new AtomicLong(0);

        long l = atomicLong.getAndIncrement();
        System.out.println("l = " + l);

        long l1 = atomicLong.get();
        System.out.println("l1 = " + l1);


//        Map<String, Object> map = new HashMap<>();
//        map.put("name", "小明");
//        map.put("time", "2022-10-10 00:10:00");
//
//        User convert = Convert.convert(User.class, map);
//        System.out.println("convert = " + JSONUtil.toJsonPrettyStr(convert));


    }


    public List<List<Object>> hello(Integer a, StringBuilder sb) throws NoSuchMethodException {
        Method method = this.getClass().getMethod("hello", Integer.class, StringBuilder.class);
        System.out.println("method = " + method.toGenericString());
        return null;
    }


    @Data
    public static class User{

        private String name;

        private Date time;
    }
}

package com.example.springbootmp.bean;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author BCY
 */
@SpringBootTest
public class CBean  {


    @Autowired
    private ABean aBean;

    @Autowired
    private BBean bBean;

    @Test
    public void test(){
        System.out.println(aBean.sayHello());

        bBean.destroy();

        System.out.println(aBean.sayHello());
    }


    @Test
    public void test1(){
        //容器
        Map<String , Object> map = new HashMap<>();

        //注册 bean
        Object o = new Object();
        map.put("bean" , o);

        //使用对象
        o.toString();

        //注销容器中的对象
        map.remove("bean");


        //使用对象
        o.toString();
    }
}

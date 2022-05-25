package com.example.springbootmp.anno;

import org.springframework.stereotype.Component;

/**
 * @author BCY
 */
@MyAnno(value = false , type = "okk")
//@SignChannel(value = false , type = "okk")
public class MyBean {

    public String hello(){
        return "hello";
    }
}

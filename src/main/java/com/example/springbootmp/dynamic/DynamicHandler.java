package com.example.springbootmp.dynamic;

import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author BCY
 */
@Component
public class DynamicHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        LogicRef annotation = method.getAnnotation(LogicRef.class);
        String code = annotation != null ? annotation.code() : "null";
        return "Hi! Proxy code = " + code;
    }
}

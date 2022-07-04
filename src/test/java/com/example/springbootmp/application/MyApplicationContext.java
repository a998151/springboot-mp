package com.example.springbootmp.application;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author BCY
 */
public class MyApplicationContext extends AnnotationConfigApplicationContext {

    @Override
    protected void initPropertySources() {
        super.initPropertySources();
        getEnvironment().getSystemProperties().put("action","run");
        getEnvironment().setRequiredProperties("KEY");
    }
}

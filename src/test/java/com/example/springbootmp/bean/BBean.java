package com.example.springbootmp.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author BCY
 */
@Component
public class BBean implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    public void destroy(){
        DefaultListableBeanFactory beanFactory = getBeanFactory();
        beanFactory.destroySingleton("aBean");

        System.out.println("注销完成");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        BBean.applicationContext = applicationContext;
    }


    private DefaultListableBeanFactory getBeanFactory() {
        ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext) applicationContext;
        return (DefaultListableBeanFactory) configurableApplicationContext.getBeanFactory();
    }
}

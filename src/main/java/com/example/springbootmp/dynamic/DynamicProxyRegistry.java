package com.example.springbootmp.dynamic;

import cn.hutool.core.convert.Convert;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.*;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

import java.lang.reflect.Proxy;
import java.util.Set;

/**
 * @author BCY
 */
@Slf4j
@Component
public class DynamicProxyRegistry implements BeanDefinitionRegistryPostProcessor {

    private static DynamicHandler dynamicHandler = new DynamicHandler();

    private DynamicScanner dynamicScanner;

    public DynamicProxyRegistry() {
        this.dynamicScanner = new DynamicScanner();
        this.dynamicScanner.addIncludeFilter(new AnnotationTypeFilter(LogicRepository.class));
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {

    }

    @Override
    @SneakyThrows
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Set<BeanDefinition> beanDefinitionSet = dynamicScanner.findCandidateComponents("com.example.springbootmp");
        for (BeanDefinition beanDefinition : beanDefinitionSet) {
            String beanClassName = beanDefinition.getBeanClassName();
            Class clazz = Thread.currentThread().getContextClassLoader().loadClass(beanClassName);
            BeanDefinitionBuilder definitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(clazz, () ->
                    createDynamicProxyBean(clazz)
            );
            BeanDefinition proxyBeanDefinition = definitionBuilder.getBeanDefinition();
            ((DefaultListableBeanFactory) beanFactory).registerBeanDefinition(ClassUtils.getShortName(clazz), proxyBeanDefinition);
        }
    }


    public <T> T createDynamicProxyBean(Class<T> beanClass) {
        return (T) Proxy.newProxyInstance(beanClass.getClassLoader(), new Class[]{beanClass}, dynamicHandler);
    }
}

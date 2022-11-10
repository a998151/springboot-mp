package com.example.springbootmp.dynamic;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;

/**
 * @author BCY
 */
public class DynamicScanner extends ClassPathScanningCandidateComponentProvider {

    DynamicScanner(){
        super(false);
    }

    @Override
    protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
        return beanDefinition.getMetadata().isInterface();
    }
}

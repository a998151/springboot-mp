package com.example.springbootmp.anno;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.extra.spring.SpringUtil;
import cn.hutool.json.JSONUtil;
import com.example.springbootmp.service.UserInfoService;
import com.example.springbootmp.service.impl.UserInfoServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;

/**
 * @author BCY
 */
@Slf4j
@SpringBootTest
public class AnnoTest {


    @Test
    public void test(){
//        SignChannel annotation = AnnotationUtils.findAnnotation(MyBean.class, SignChannel.class);
//        MyAnno annotation = AnnotationUtils.findAnnotation(MyBean.class, MyAnno.class);
//        MyAnno annotation = AnnotatedElementUtils.findMergedAnnotation(MyBean.class, MyAnno.class);
        SignChannel annotation = AnnotatedElementUtils.findMergedAnnotation(MyBean.class, SignChannel.class);
        log.info(annotation.type());
        log.info(annotation.value() + "");

        UserInfoServiceImpl bean = SpringUtil.getBean(UserInfoServiceImpl.class);
        log.info(bean.toString());
    }
}

package com.example.springbootmp.anno;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author BCY
 */
@Target({ElementType.METHOD , ElementType.ANNOTATION_TYPE , ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface SignChannel {

    boolean value() default true;

    String type() default "COMMON";
}

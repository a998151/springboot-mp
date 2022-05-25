package com.example.springbootmp.anno;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author BCY
 */
@Target({ElementType.METHOD , ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@SignChannel
public @interface MyAnno {

    @AliasFor(
            annotation = SignChannel.class , attribute = "value"
    )
    boolean value() default true;

    @AliasFor(
            annotation = SignChannel.class , attribute = "type"
    )
    String type() default "COMMON";
}

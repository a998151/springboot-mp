package com.example.springbootmp.dynamic;

import java.lang.annotation.*;

/**
 * @author BCY
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface LogicRef {

    //代码
    String code();

}

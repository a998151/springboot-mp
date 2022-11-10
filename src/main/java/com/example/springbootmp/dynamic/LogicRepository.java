package com.example.springbootmp.dynamic;

import org.springframework.stereotype.Service;

import java.lang.annotation.*;

/**
 * @author BCY
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Service
public @interface LogicRepository {
}

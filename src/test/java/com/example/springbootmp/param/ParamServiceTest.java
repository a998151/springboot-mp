package com.example.springbootmp.param;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;

import java.lang.reflect.Method;

/**
 * @author BCY
 */
@SpringBootTest
public class ParamServiceTest {


    @Test
    public void test(){
        LocalVariableTableParameterNameDiscoverer nameDiscoverer = new LocalVariableTableParameterNameDiscoverer();
        Method[] methods = ParamService.class.getMethods();
        String[] parameterNames = nameDiscoverer.getParameterNames(methods[0]);
        System.out.println("parameterNames = " + parameterNames);
    }
}

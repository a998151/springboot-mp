package com.example.springbootmp.spel;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * @author BCY
 */
@Slf4j
@SpringBootTest
public class SpELTest {

    @Test
    void test(){
        Map<String , Object> data = new HashMap<>();
        data.put("Hello" , "World");

        StandardEvaluationContext context = new StandardEvaluationContext(data);
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("Hello");
        Object value = exp.getValue(context);
        log.info("value = {}" , value.toString());
    }
}

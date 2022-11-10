package com.example.springbootmp.groovy;

import cn.hutool.core.lang.Console;
import com.google.common.collect.Lists;
import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import groovy.lang.MissingPropertyException;
import groovy.lang.Script;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import javax.script.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author BCY
 */
@Slf4j
public class GroovyTest {


    @Test
    public void test() {
        try {
            GroovyShell shell = new GroovyShell();
            Script parse = shell.parse("map?.data");
            Map<String, Object> map = new HashMap<>();
            Map<String, Object> data = new HashMap<>();
            data.put("data" , "Hello");
            map.put("map" , data);
            parse.setBinding(new Binding(map));
            Object run = parse.run();
            System.out.println("run = " + run);

            parse.setBinding(new Binding());
            run = parse.run();
            System.out.println("run = " + run);

        }catch (MissingPropertyException exception){
            log.warn("{}" , exception.getMessage());
        }

    }


    @Test
    public void test1() {
        try {

            GroovyShell shell = new GroovyShell();
            Script parse = shell.parse("map?.data.isEmpty()");
            Map<String, Object> map = new HashMap<>();
            Map<String, Object> data = new HashMap<>();
            data.put("data" , "Hello");
            map.put("map" , data);
            parse.setBinding(new Binding(map));
            Object run = parse.run();
            System.out.println("run = " + run);

            parse.setBinding(new Binding());
            run = parse.run();
            System.out.println("run = " + run);

        }catch (MissingPropertyException exception){
            log.warn("{}" , exception.getMessage());
        }

    }


    @Test
    public void test2() throws ScriptException, NoSuchMethodException {
        ArrayList<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7);

        GroovyShell shell = new GroovyShell();
        Script script = shell.parse("list.collect{ it.code + '_OK' }");
//        Binding binding = new Binding();
//        binding.setVariable("list" , list);
        script.setProperty("list" , list);
        Object run = script.run();
        Console.log(run);

//        ScriptEngineManager factory = new ScriptEngineManager();
//        ScriptEngine engine = factory.getEngineByName("groovy");// 每次生成一个engine实例
//        engine.eval("def getList(list){return list.grep{ it > 3};}");// 如果script文本来自文件,请首先获取文件内容
//        engine.eval("def sayHello(name,age){return 'Hello,I am ' + name + ',age' + age;}");
//
//
//        Object getList = ((Invocable) engine).invokeFunction("getList", list);// 反射到方法
//        System.out.println(getList);

    }

}

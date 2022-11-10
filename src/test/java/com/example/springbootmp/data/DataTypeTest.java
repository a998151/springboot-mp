package com.example.springbootmp.data;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author BCY
 */
public class DataTypeTest {


    @Test
    public void test(){
        List<String> list = new ArrayList<>();
        String simpleName = String.class.getSimpleName();
        String canonicalName = String.class.getCanonicalName();
        String name = String.class.getName();
        System.out.println("simpleName = " + simpleName);
        System.out.println("canonicalName = " + list.getClass().getCanonicalName());
        System.out.println("name = " + name);
    }

    @Test
    public void test1(){
        Object anInt = null;
        try {
            anInt = Class.forName("int").newInstance();
        } catch (InstantiationException e){
            e.printStackTrace();
        } catch (IllegalAccessException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        System.out.println("anInt = " + anInt);
    }
}

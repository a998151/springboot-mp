package com.example.springbootmp.stream;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author BCY
 */
public class ParallelStreamTest {

    private static List<Integer> list = new ArrayList<>();

    @Test
    public void test(){
        //可能出现下标越界异常
        IntStream.range(0 , 1000).parallel().forEach(list::add);
        System.out.println("list = " + list.size());

        list.clear();

        IntStream.range(0 , 1000).forEach(list::add);
        System.out.println("list = " + list.size());

//        IntStream.range(0 , 10000).parallel().forEach(list::add);
//        System.out.println("list 大小 = " + list.size());
    }
}

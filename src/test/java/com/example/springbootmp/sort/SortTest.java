package com.example.springbootmp.sort;

import cn.hutool.json.JSONUtil;
import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author BCY
 */
public class SortTest {


    @Test
    void test(){
        ArrayList<SortModel> sortModels = Lists.newArrayList(new SortModel("B", 1), new SortModel("C", 1), new SortModel("A", 1));

        List<SortModel> collect = sortModels.stream().sorted(Comparator.comparing(SortModel::getName)).collect(Collectors.toList());

        System.out.println("collect = " + JSONUtil.toJsonPrettyStr(collect));
    }
}

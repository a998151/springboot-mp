package com.example.springbootmp.groovy

import cn.hutool.core.lang.TypeReference
import cn.hutool.core.util.StrUtil
import cn.hutool.json.JSONUtil

/**
 *
 * @author BCY
 */
class isBlank {

    static void main(String[] args) {
        def data = JSONUtil.toBean("{\"time\":\"季初\",\"list\":[{\"WARD_CODE\":\"051202\",\"USER_SIZE\":3},{\"WARD_CODE\":\"041102\",\"TITLE\":\"副主任护师\",\"USER_SIZE\":1},{\"WARD_CODE\":\"051102\",\"TITLE\":\"护士\",\"USER_SIZE\":1},{\"WARD_CODE\":\"042302\",\"USER_SIZE\":1},{\"WARD_CODE\":\"042102\",\"USER_SIZE\":8},{\"WARD_CODE\":\"041102\",\"USER_SIZE\":1}]}" ,
                new TypeReference<Map<String , Object>>() {
        } , true);

        def list = []
        data.list?.groupBy {
            it.WARD_CODE
        }.each { k,v ->
            def amount = 0
            v.each {
                def itemCode = toItemCode(it.TITLE, data.time)
                if (itemCode) {
                    amount += it.USER_SIZE;
                    list << toItemRecord(k, itemCode, it.USER_SIZE)
                }
            }
            list << toItemRecord(k, toItemCode('职称总', data.time), amount)
            list << toItemRecord(k, toItemCode('执业总', data.time), amount)
        }

        println list
    }

    Map toItemRecord(String deptCode, String itemCode, Integer itemValue) {
        return ['deptCode':deptCode,
                'itemCode':itemCode,
                'itemValue':itemValue];
    }

    String toItemCode(String title, String time) {
        if (time == '季初') return toQuarterBeginItemCode(title);
        if (time == '季末') return toQuarterEndItemCode(title);
        return null;
    }

    String toQuarterBeginItemCode(String title) {
        if (title == '护士') return 'b001';
        if (title == '护师') return 'b003';
        if (title == '主管护师') return 'b005';
        if (title == '副主任护师') return 'b007';
        if (title == '主任护师') return 'b009';
        if (title == '职称总') return 'b011';
        if (title == '执业总') return 'a002';
        return null;
    }

    String toQuarterEndItemCode(String title) {
        if (title == '护士') return 'b002';
        if (title == '护师') return 'b004';
        if (title == '主管护师') return 'b006';
        if (title == '副主任护师') return 'b008';
        if (title == '主任护师') return 'b010';
        if (title == '职称总') return 'b012';
        if (title == '执业总') return 'a003';
        return null;
    }
}

package com.example.springbootmp.stream;

import cn.hutool.json.JSONUtil;
import com.example.springbootmp.entity.UserInfo;
import com.example.springbootmp.service.impl.UserInfoServiceImpl;
import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author BCY
 */
@SpringBootTest
public class StreamTest {


    @Test
    public void test() {
        UserInfo u1 = UserInfo.builder().age(10).build();
        UserInfo u2 = UserInfo.builder().age(20).build();
        UserInfo u3 = UserInfo.builder().age(30).build();

        ArrayList<UserInfo> userInfos = Lists.newArrayList(u1, u2, u3);
        userInfos.forEach(u -> u.setAge(5));

//        List<UserInfo> collect = userInfos.stream().peek(u -> u.setAge(5)).collect(Collectors.toList());

//        System.out.println(JSONUtil.toJsonPrettyStr(collect));
    }


    @Autowired
    private UserInfoServiceImpl userInfoService;

    @Test
    public void test2() {
        System.out.println(AopUtils.isAopProxy(userInfoService));
        System.out.println(AopUtils.getTargetClass(userInfoService));
    }
}

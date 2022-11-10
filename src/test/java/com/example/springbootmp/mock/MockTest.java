package com.example.springbootmp.mock;

import cn.hutool.json.JSONUtil;
import com.github.jsonzou.jmockdata.JMockData;
import com.github.jsonzou.jmockdata.MockConfig;
import com.github.jsonzou.jmockdata.TypeReference;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * @author BCY
 */
public class MockTest {

    @Test
    public void test() {
        MockConfig mockConfig = new MockConfig()
                .subConfig("id")
                .longRange(100, 200)
//                .subConfig("name")
//                .stringRegex("^[\\u4E00-\\u9FA5]{2,4}$")
                .globalConfig();

        MockModel mock = JMockData.mock(new TypeReference<MockModel>() {
        }, mockConfig);

        System.out.println("mock = " + JSONUtil.toJsonPrettyStr(mock));
    }
}

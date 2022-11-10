package com.example.springbootmp.transfer;

import cn.hutool.core.lang.Console;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import com.google.common.collect.Lists;
import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import groovy.lang.Script;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author BCY
 */
public class TransferTest {

    @Test
    void test() throws InterruptedException {
        ThreadLocal<String> tl = new InheritableThreadLocal<>();
        tl.set("Hello");
        new Thread(() -> {
            System.out.println("tl.get() = " + tl.get());
            tl.set("Ok");
            System.out.println("tl.get() = " + tl.get());
        }).start();

        Thread.sleep(1000);

        new Thread(() -> {
            System.out.println("tl.get() = " + tl.get());
        }).start();
    }


    @Test
    void test1() {
        String body = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:com=\"http://component.mule.integration.hesb.cr.com/\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <com:execute>\n" +
                "         <!--Optional:-->\n" +
                "         <AppId>?</AppId>\n" +
                "         <!--Optional:-->\n" +
                "         <ServiceName>?</ServiceName>\n" +
                "         <!--Optional:-->\n" +
                "         <Request>?</Request>\n" +
                "      </com:execute>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";
        Map<String, Object> map = new HashMap<>();
        map.put("AppId", 1);
        map.put("ServiceName", "dbtest01");
        map.put("Request", "<![CDATA[<titleId>01</titleId>]]>");

        String s = buildBody(body, map);
        Console.log(s);
    }


    @Test
    void test2() {
        String body = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:web=\"http://WebXml.com.cn/\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <web:getCountryCityByIp>\n" +
                "         <!--Optional:-->\n" +
                "         <web:theIpAddress>?</web:theIpAddress>\n" +
                "      </web:getCountryCityByIp>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";
        Map<String, Object> map = new HashMap<>();
        map.put("theIpAddress", "61.140.27.81");

        String s = buildBody(body, map);
        Console.log(s);
    }


    @Test
    void test3() {
        String body = "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "   <soap:Body>\n" +
                "      <ns2:executeResponse xmlns:ns2=\"http://component.mule.integration.hesb.cr.com/\">\n" +
                "         <ns2:return>{\"titleName\":\"护士\"}</ns2:return>\n" +
                "<ns2:ok><string>Hello</string><string>Hi</string><string>小明</string></ns2:ok>" +
                "      </ns2:executeResponse>\n" +
                "   </soap:Body>\n" +
                "</soap:Envelope>";


        Map<String, Object> map = buildOutput(body);
        Console.log(map);
    }


    /**
     * 构建出参
     *
     * @param body
     * @return
     */
    private Map<String, Object> buildOutput(String body) {
        if (StrUtil.isBlank(body)) {
            return null;
        }
        Map<String, Object> map = XmlUtil.xmlToMap(body);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getKey().equalsIgnoreCase("soap:body")) {
                return removePrefix((Map<String, Object>) entry.getValue());
            }
        }
        return null;
    }


    /**
     * <></>
     * @param map
     * @return
     */
    private List convertList(Map<String, Object> map) {
        if (map.size() == 1) {
            String key = Lists.newArrayList(map.keySet()).get(0);
            Object sub = map.get(key);
            if (sub instanceof List) {
                return (List) sub;
            }
        }
        return null;
    }


    /**
     * 移除前缀
     *
     * @param map
     * @return
     */
    private Map<String, Object> removePrefix(Map<String, Object> map) {
        Map<String, Object> replace = new HashMap<>();
        Set<String> removes = new HashSet<>();
        map.forEach((k, v) -> {
            if (k.contains(":")) {
                Object val = map.get(k);
                removes.add(k);

                if (val instanceof Map) {
                    val = removePrefix((Map<String, Object>) val);
                }

                String[] split = k.split(":");
                replace.put(split[split.length - 1], val);
            }
        });

        removes.forEach(map::remove);
        map.putAll(replace);
        return map;
    }


    private String buildBody(String template, Map<String, Object> input) {
        if (MapUtil.isNotEmpty(input)) {
            for (Map.Entry<String, Object> entry : input.entrySet()) {
                String key = StrUtil.format("{}>?</", entry.getKey());
                if (template.contains(key)) {
                    String node = StrUtil.replace(key, "?", entry.getValue().toString());
                    template = StrUtil.replace(template, key, node);
                }
            }
        }
        return template;
    }

}

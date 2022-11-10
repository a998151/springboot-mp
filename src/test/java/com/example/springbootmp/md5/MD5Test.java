package com.example.springbootmp.md5;

import cn.hutool.core.date.StopWatch;
import cn.hutool.core.lang.Console;
import cn.hutool.cron.CronUtil;
import cn.hutool.crypto.digest.DigestUtil;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 * @author BCY
 */
public class MD5Test {

    private String content = "package com.example.springbootmp.md5;\\n\" +\n" +
            "                \"\\n\" +\n" +
            "                \"import cn.hutool.core.date.StopWatch;\\n\" +\n" +
            "                \"import cn.hutool.crypto.digest.DigestUtil;\\n\" +\n" +
            "                \"import org.junit.jupiter.api.Test;\\n\" +\n" +
            "                \"\\n\" +\n" +
            "                \"/**\\n\" +\n" +
            "                \" * @author BCY\\n\" +\n" +
            "                \" */\\n\" +\n" +
            "                \"public class MD5Test {\\n\" +\n" +
            "                \"\\n\" +\n" +
            "                \"\\n\" +\n" +
            "                \"    @Test\\n\" +\n" +
            "                \"    public void testTime() {\\n\" +\n" +
            "                \"        StopWatch stw = new StopWatch();\\n\" +\n" +
            "                \"        stw.start();\\n\" +\n" +
            "                \"\\n\" +\n" +
            "                \"        DigestUtil.md5Hex(\\\"\\\")\\n\" +\n" +
            "                \"    }\\n";


    @Test
    public void testTime() {
        StopWatch stw = new StopWatch();
        stw.start();

        String s = DigestUtil.md5Hex(content);

        stw.stop();

        Console.log("耗时 = {} ms ，加密内容 = {}" , stw.getLastTaskTimeMillis() , s);
    }



    @Test
    @SneakyThrows
    public void testSha1() {
        StopWatch stw = new StopWatch();
        stw.start();

        int code = content.hashCode();

        stw.stop();

        Console.log("耗时 = {} ms ，加密内容 = {}" , stw.getLastTaskTimeMillis() , code);


        CronUtil.schedule("0/5 * * * * ?" , (Runnable) () -> System.out.println("Hello" + new Date()));
        CronUtil.setMatchSecond(true);
        CronUtil.start();
    }
}

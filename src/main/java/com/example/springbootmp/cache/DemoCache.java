package com.example.springbootmp.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author BCY
 */
@Slf4j
public class DemoCache {

    private static ListeningExecutorService backgroundRefreshPools = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(20));

    public static LoadingCache<String, Object> caches = CacheBuilder.newBuilder()
            .maximumSize(100)
            .refreshAfterWrite(10, TimeUnit.SECONDS)
            .build(new CacheLoader<String, Object>() {
                @Override
                public Object load(String key) {
                    log.info("获取值");
                    return generateValueByKey(key);
                }

                @Override
                public ListenableFuture<Object> reload(String key, Object oldValue) {
                    return backgroundRefreshPools.submit(() -> {
                        log.info("异步刷新");
                        return generateValueByKey(key);
                    });
                }
            });


    private static Object generateValueByKey(String key) {
        if (key.equalsIgnoreCase("hello")) {
            return "world";
        } else if (key.equalsIgnoreCase("hi")) {
            return "I'm fine , thank u.";
        } else {
            return "default";
        }
    }
}

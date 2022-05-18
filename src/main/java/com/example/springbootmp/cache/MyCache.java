package com.example.springbootmp.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author BCY
 */
@Slf4j
@Service
public class MyCache extends BaseGuavaCache<String , Object>{

    @Override
    public void loadValueWhenStarted() {
        log.info("loadValueWhenStarted....");
    }

    @Override
    protected Object getValueWhenExpired(String key) throws Exception {
        return new Object();
    }
}

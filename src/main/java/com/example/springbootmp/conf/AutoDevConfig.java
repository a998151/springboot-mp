package com.example.springbootmp.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author BCY
 */
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "logic")
@Component
public class AutoDevConfig {

    @Value("${logic.swagger}")
    private boolean swagger;

    public boolean isSwagger() {
        return swagger;
    }
}

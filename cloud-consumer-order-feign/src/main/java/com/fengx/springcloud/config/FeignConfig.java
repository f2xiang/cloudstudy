package com.fengx.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by apple on 2020/8/8.
 * Feign的日志打印
 */
@Configuration
public class FeignConfig {
    @Bean
    public Logger.Level FeignLog() {
        return Logger.Level.FULL;
//        return Logger.Level.BASIC;
    }
}

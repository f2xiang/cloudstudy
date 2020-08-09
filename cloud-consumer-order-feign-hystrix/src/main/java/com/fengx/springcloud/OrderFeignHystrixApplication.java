package com.fengx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created by apple on 2020/8/8.
 * Feign + Hystrix
 */

@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class OrderFeignHystrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignHystrixApplication.class, args);
    }

}

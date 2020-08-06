package com.fengx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by apple on 2020/8/6.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentZkMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(PaymentZkMainApplication.class, args);
    }

}

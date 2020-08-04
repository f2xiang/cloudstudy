package com.fengx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by apple on 2020/8/4.
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaMainApplication.class, args);
    }

}

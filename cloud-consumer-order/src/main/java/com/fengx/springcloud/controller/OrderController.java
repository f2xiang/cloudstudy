package com.fengx.springcloud.controller;

import com.fengx.springcloud.model.CommonResult;
import com.fengx.springcloud.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by apple on 2020/8/2.
 */
@RestController
public class OrderController {

    public static final String SERVICE_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/order/{id}")
    private CommonResult<Payment> get(@PathVariable("id") int id) {
        // 通过RestTemplate调用provider的服务
        return restTemplate.getForObject(SERVICE_URL+"/payment/"+id, CommonResult.class);
    }
}

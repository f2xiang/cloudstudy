package com.fengx.springcloud.controller;

import com.fengx.springcloud.MyBalance.RoundBalance;
import com.fengx.springcloud.model.CommonResult;
import com.fengx.springcloud.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by apple on 2020/8/2.
 */
@RestController
public class OrderController {

    public static final String SERVICE_URL = "http://CLOUD-PAYMENT-SERVICE";
    public static final String SERVICE_ID = "CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    // ———————————————用于手写轮询算法
    //获取服务提供者
    @Autowired
    private DiscoveryClient discoveryClient;

    //自己写的算法
    @Autowired
    private RoundBalance roundBalance;
    //———————————————


    @GetMapping("/order/{id}")
    private CommonResult<Payment> get(@PathVariable("id") int id) {
        // 通过RestTemplate调用provider的服务
        return restTemplate.getForObject(SERVICE_URL+"/payment/"+id, CommonResult.class);
    }

    /**
     * 手写负载均衡load balance调用
     */
    @GetMapping("/balance/order/{id}")
    private CommonResult<Payment> getByBalance(@PathVariable("id") int id) {
        // 获取服务提供者，并通过轮询算法得到指定的一台service 的 uri
        List<ServiceInstance>  serviceInstances = discoveryClient.getInstances(SERVICE_ID);
        ServiceInstance service = roundBalance.getServiceInstance(serviceInstances);
        return restTemplate.getForObject(service.getUri() +"/payment/"+id, CommonResult.class);
    }
}

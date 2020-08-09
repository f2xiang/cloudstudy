package com.fengx.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by apple on 2020/8/8.
 */
@Component
// 全局fallback处理
@FeignClient(value = "CLOUD-PAYMENT-HYSTRIX-SERVICE", fallback = PaymentFallbackService.class)
public interface PaymentService {

    @GetMapping("/payment/{id}")
    String get(@PathVariable("id") String id);


    @GetMapping("/payment/timeout/{id}")
    String getByTimeout(@PathVariable("id") String id);


}
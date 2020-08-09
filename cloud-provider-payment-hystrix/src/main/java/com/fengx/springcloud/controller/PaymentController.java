package com.fengx.springcloud.controller;

import com.fengx.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by apple on 2020/8/8.
 */
@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/{id}")
    private String get(@PathVariable("id") String id) {
        return paymentService.getInfoWithOk(id);
    }

    @GetMapping("/payment/timeout/{id}")
    private String getByTimeout(@PathVariable("id") String id) {
        return paymentService.getInfoWithTimeout(id);
    }

    //服务熔断
    @GetMapping("/payment/circuit/{id}")
    private String getCircuit(@PathVariable("id") int id) {
        return paymentService.paymentCircuitBreaker(id);
    }


}

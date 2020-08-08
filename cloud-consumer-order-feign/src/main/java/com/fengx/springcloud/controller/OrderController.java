package com.fengx.springcloud.controller;

import com.fengx.springcloud.model.CommonResult;
import com.fengx.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by apple on 2020/8/8.
 */
@RestController
public class OrderController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/consumer/payment/{id}")
    private CommonResult getById(@PathVariable("id") int id){
        return paymentService.getById(id);
    }
}

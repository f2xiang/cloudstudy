package com.fengx.springcloud.controller;

import com.fengx.springcloud.model.CommonResult;
import com.fengx.springcloud.model.Payment;
import com.fengx.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * Created by apple on 2020/8/2.
 */
@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;


    @PostMapping("/payment")
    private CommonResult save(@RequestBody Payment payment) {

        int result = paymentService.save(payment);

        if (result > 0) {
            return new CommonResult(0,"插入成功");
        }else {
            return new CommonResult(-1,"插入失败");
        }

    }


    @GetMapping("/payment/{id}")
    private CommonResult getById(@PathVariable("id") int id) {
        try {
            Payment payment = paymentService.getPaymentById(id);
            return new CommonResult(0,"查询成功，serverport="+serverPort,payment);
        } catch (Exception e) {
            return new CommonResult(-1,"查询失败");
        }

    }



}

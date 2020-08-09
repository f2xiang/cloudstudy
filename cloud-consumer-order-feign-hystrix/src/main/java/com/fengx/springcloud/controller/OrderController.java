package com.fengx.springcloud.controller;

import com.fengx.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by apple on 2020/8/8.
 */
@RestController
//配置全局的fallback
@DefaultProperties(defaultFallback = "getGlobalFallback")
public class OrderController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/consumer/payment/{id}")
    private String getById(@PathVariable("id") String id){
        return paymentService.get(id);
    }


    //加入hystrix,备选方案,以3S为界限，3秒之内正常走，超时了走备胎 getInfoWithTimeoutHandler
    @HystrixCommand(fallbackMethod = "getInfoWithTimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })
//    @HystrixCommand //使用全局的fallback
    @GetMapping("/consumer/timeout/payment/{id}")
    private String getByTimeout(@PathVariable("id") String id){
//        int a = 1 / 0;
        return paymentService.getByTimeout(id);
    }


    // hystrix: getInfoWithTimeout方法的备胎
    public String getInfoWithTimeoutHandler(String id) {
        return "线程为："+Thread.currentThread().getName()+"===亲亲~系统繁忙，请稍后再试哦~，id="+id;
    }


    // 全局fallback
    public String getGlobalFallback() {
        return "线程为："+Thread.currentThread().getName()+"===亲亲~系统繁忙，请稍后再试哦~";
    }

}

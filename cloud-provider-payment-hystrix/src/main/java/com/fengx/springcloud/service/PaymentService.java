package com.fengx.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

/**
 * Created by apple on 2020/8/8.
 */
@Service
public class PaymentService {

    public String getInfoWithOk(String id) {
        return "线程为："+Thread.currentThread().getName()+"===成功获取信息，id="+id;
    }


    //加入hystrix,备选方案,以3S为界限，3秒之内正常走，超时了走备胎 getInfoWithTimeoutHandler
    @HystrixCommand(fallbackMethod = "getInfoWithTimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String getInfoWithTimeout(String id) {
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        //或者 一进来就报错，启动备选方案。
//        int a = 10 / 0;
        return "线程为："+Thread.currentThread().getName()+"===获取信息超时，id="+id;
    }


    // hystrix: getInfoWithTimeout方法的备胎
    public String getInfoWithTimeoutHandler(String id) {
        return "线程为："+Thread.currentThread().getName()+"===亲亲~系统繁忙，请稍后再试哦~，id="+id;
    }


    // ------- 服务熔断
    // 10次请求失败率高达60%，打开断路器。
    // 10s（窗口期）后恢复到half open， if success then close， else open
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
    })
    public String paymentCircuitBreaker(int id) {
        if (id < 0) {
            throw new RuntimeException("id不能为负数");
        }

        return "线程为："+Thread.currentThread().getName()+"===获取信息成功，id="+id;
    }


    public String paymentCircuitBreakerFallback(int id) {
        return "线程为："+Thread.currentThread().getName()+"===亲亲~系统繁忙，请稍后再试哦~，id="+id;
    }


}

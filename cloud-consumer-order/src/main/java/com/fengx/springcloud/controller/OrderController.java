package com.fengx.springcloud.controller;

import com.fengx.springcloud.model.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by apple on 2020/8/2.
 */
@RestController
public class OrderController {

    @GetMapping("/order")
    public Order get() {
        return new Order("aaa");
    }
}

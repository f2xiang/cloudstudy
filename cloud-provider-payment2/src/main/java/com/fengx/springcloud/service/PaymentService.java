package com.fengx.springcloud.service;

import com.fengx.springcloud.model.Payment;

/**
 * Created by apple on 2020/8/2.
 */
public interface PaymentService {

    int save(Payment payment);

    Payment getPaymentById(int id);
}

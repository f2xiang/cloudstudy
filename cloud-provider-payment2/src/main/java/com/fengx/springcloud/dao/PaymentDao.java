package com.fengx.springcloud.dao;

import com.fengx.springcloud.model.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by apple on 2020/8/2.
 */

@Mapper
public interface PaymentDao {

    int save(Payment payment);

    Payment getPaymentById(int id);

}

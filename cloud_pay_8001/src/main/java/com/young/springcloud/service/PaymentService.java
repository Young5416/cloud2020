package com.young.springcloud.service;

import com.young.springcloud.entities.Payment;

/**
 * @description:
 * @author: Young
 * @create: 2020-12-16 13:01
 * @Version: 1.0
 **/
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(Long id);
}

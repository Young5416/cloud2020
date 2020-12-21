package com.young.springcoud.service;

import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: Young
 * @create: 2020-12-21 11:26
 * @Version: 1.0
 **/

@Component
public class PaymentFallbackService implements PaymentHystrixService{

    @Override
    public String paymentInfo_OK(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_OK ,错误";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_TimeOut ,错误";
    }
}

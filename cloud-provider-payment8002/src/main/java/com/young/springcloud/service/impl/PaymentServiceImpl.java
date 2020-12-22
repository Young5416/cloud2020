package com.young.springcloud.service.impl;

import com.young.springcloud.dao.PaymentDao;
import com.young.springcloud.entities.Payment;
import com.young.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: Young
 * @create: 2020-12-16 13:03
 * @Version: 1.0
 **/
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}

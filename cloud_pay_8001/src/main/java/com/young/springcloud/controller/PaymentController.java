package com.young.springcloud.controller;

import com.young.springcloud.entities.CommonResult;
import com.young.springcloud.entities.Payment;
import com.young.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Young
 * @create: 2020-12-16 13:04
 * @Version: 1.0
 **/
@RestController("payment")
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/create")
    public CommonResult create(Payment payment) {
        int result = paymentService.create(payment);
        if (result > 0) {
            return new CommonResult(200, "插入数据成功", result);
        } else {
            return new CommonResult(444, "插入数据失败", null);
        }
    }

    @GetMapping("/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            return new CommonResult(200, "查询成功", payment);
        } else {
            return new CommonResult(444, "没有对应记录", null);
        }
    }

}

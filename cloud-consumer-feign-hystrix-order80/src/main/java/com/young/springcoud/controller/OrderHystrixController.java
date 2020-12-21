package com.young.springcoud.controller;

import com.young.springcoud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: Young
 * @create: 2020-12-21 10:32
 * @Version: 1.0
 **/

@RestController
@Slf4j
@RequestMapping("/consumer/payment/hystrix")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/ok/{id}")
    public String paymentInfoOK(@PathVariable("id") Integer id){
        return paymentHystrixService.paymentInfo_OK(id);
    }

    @GetMapping("/timeout/{id}")
    public String paymentInfoTimeOut(@PathVariable("id") Integer id){
        return paymentHystrixService.paymentInfo_TimeOut(id);
    }
}

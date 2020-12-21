package com.young.springcoud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
@DefaultProperties(defaultFallback = "paymentInfo_Global_FallbackMethod")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/ok/{id}")
    public String paymentInfoOK(@PathVariable("id") Integer id){
        return paymentHystrixService.paymentInfo_OK(id);
    }

    @GetMapping("/timeout/{id}")
    @HystrixCommand
    public String paymentInfoTimeOut(@PathVariable("id") Integer id){
        return paymentHystrixService.paymentInfo_TimeOut(id);
    }

    /**
    * @Description: 指定降级方法
    * @return java.lang.String
    * @author Young
    * @date 2020/12/21 11:19
    */
    public String paymentInfo_TimeOutHandler() {
        return "消费者80，对方支付系统繁忙请10秒钟后或者自己运行出错请检查";
    }

    /**
    * @Description: 默认降级方法
    * @return java.lang.String
    * @author Young
    * @date 2020/12/21 11:19
    */
    public String paymentInfo_Global_FallbackMethod() {
        return "Global异常信息，请检查";
    }
}

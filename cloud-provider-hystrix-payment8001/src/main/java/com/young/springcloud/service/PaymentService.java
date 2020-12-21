package com.young.springcloud.service;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: Young
 * @create: 2020-12-21 09:46
 * @Version: 1.0
 **/
@Service
public class PaymentService {

    /**
    * @Description: 正常访问
    * @param id
    * @return java.lang.String
    * @author Young
    * @date 2020/12/21 9:57
    */
    public String paymentInfo_OK(Integer id) {
        return "线程池:  " + Thread.currentThread().getName() + "paymentInfo_ok,id:  " + id + "\t" + "哈哈~";
    }

    /**
     * @Description: 超时方法 测试熔断
     * @param id
     * @return java.lang.String
     * @author Young
     * @date 2020/12/21 9:57
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfo_TimeOut(Integer id) {
//        int age = 10 / 0;
        int timeNumber = 5;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:  " + Thread.currentThread().getName() + "paymentInfo_ok,id:  " + id + "\t" + "哈哈~";
    }

    public String paymentInfo_TimeOutHandler(Integer id) {
        return "线程池:  " + Thread.currentThread().getName() + "系统繁忙或者运行错误,id:  " + id + "\t" + "错误~";
    }
}

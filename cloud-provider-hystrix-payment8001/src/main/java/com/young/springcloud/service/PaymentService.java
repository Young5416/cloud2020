package com.young.springcloud.service;


import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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

    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),//开启熔断器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),//请求总数阈值-请求次数超过峰值，熔断将会关闭
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),//快照时间窗-时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),//错误百分比阈值-失败率多少会跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("*****id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        return "id 不能为负数，请稍后再试 id:  "  + id;
    }

    public String paymentInfo_TimeOutHandler(Integer id) {
        return "线程池:  " + Thread.currentThread().getName() + "系统繁忙或者运行错误,id:  " + id + "\t" + "错误~";
    }
}

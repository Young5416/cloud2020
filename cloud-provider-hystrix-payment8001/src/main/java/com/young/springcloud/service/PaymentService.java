package com.young.springcloud.service;


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
    public String paymentInfo_TimeOut(Integer id) {
        int timeNumber = 3;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:  " + Thread.currentThread().getName() + "paymentInfo_ok,id:  " + id + "\t" + "哈哈~";
    }
}

package com.young.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: Young
 * @create: 2021-01-04 14:09
 * @Version: 1.0
 **/
@RestController
@Slf4j
public class FlowlimitController {

    @GetMapping("/testA")
    public String testA() {
        return "-------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "-------testB";
    }

    @GetMapping("/testC")
    public String testC() {
        log.info("testC 异常");
        int age = 10 / 0;
        return "-------testD";
    }

    @GetMapping("/testD")
    public String testD() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "-------testD";
    }

    @GetMapping("/testE")
    public String testE() {
        log.info("testE 异常");
        int age = 10 / 0;
        return "-------testD";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false)String p1,
                             @RequestParam(value = "p2",required = false)String p2) {
        return "-------testHotKey";
    }

    public String deal_testHotKey() {
        return "-------deal_testHotKey-----------------";
    }
}

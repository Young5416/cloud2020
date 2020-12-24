package com.young.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @description:
 * @author: Young
 * @create: 2020-12-24 14:58
 * @Version: 1.0
 **/

@SpringBootApplication
@EnableDiscoveryClient
public class NacosPayment9003 {
    public static void main(String[] args) {
        SpringApplication.run(NacosPayment9003.class, args);
    }
}

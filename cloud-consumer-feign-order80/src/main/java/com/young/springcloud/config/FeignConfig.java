package com.young.springcloud.config;

import feign.Logger;
import feign.Logger.Level;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: Young
 * @create: 2020-12-20 19:37
 **/

@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel() {
        return Level.FULL;
    }
}

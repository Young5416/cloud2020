package com.young.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: Young
 * @create: 2021-01-06 13:28
 * @Version: 1.0
 **/

@Configuration
@MapperScan({"com.young.springcloud.dao"})
public class MyBatisConfig {
}

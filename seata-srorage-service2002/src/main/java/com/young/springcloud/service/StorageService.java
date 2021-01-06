package com.young.springcloud.service;

import org.apache.ibatis.annotations.Param;

/**
 * @description:
 * @author: Young
 * @create: 2021-01-06 18:20
 * @Version: 1.0
 **/
public interface StorageService {
    void decrease( Long productId, Integer count);
}

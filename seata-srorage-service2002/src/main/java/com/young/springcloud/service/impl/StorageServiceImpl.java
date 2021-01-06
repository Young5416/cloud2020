package com.young.springcloud.service.impl;

import com.young.springcloud.dao.StorageDao;
import com.young.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description:
 * @author: Young
 * @create: 2021-01-06 18:21
 * @Version: 1.0
 **/
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("------->seata-storage-service扣减库存开始");
        storageDao.decrease(productId,count);
        log.info("------->seata-storage-service扣减库存结束");
    }
}

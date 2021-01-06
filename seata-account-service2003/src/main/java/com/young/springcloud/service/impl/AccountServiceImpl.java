package com.young.springcloud.service.impl;

import com.young.springcloud.dao.AccountDao;
import com.young.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: Young
 * @create: 2021-01-06 19:54
 * @Version: 1.0
 **/

@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    @Override
    public void decrease(Long userId, Integer money) {
        log.info("------------->account扣减余额开始");
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        accountDao.decrease(userId,money);
        log.info("------------->account扣减余额结束");
    }
}

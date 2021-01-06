package com.young.springcloud.service.impl;

import com.young.springcloud.dao.OrderDao;
import com.young.springcloud.domain.Order;
import com.young.springcloud.service.AccountService;
import com.young.springcloud.service.OrderService;
import com.young.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description:
 * @author: Young
 * @create: 2021-01-06 13:11
 * @Version: 1.0
 **/

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;

    /**
     * 创建订单->调用库存服务扣减库存->调用账户服务扣减账户余额->修改订单状态
     * 简单说:
     * 下订单->减库存->减余额->改状态
     * GlobalTransactional seata开启分布式事务,异常时回滚,name保证唯一即可
     * @param order 订单对象
     */
    @Override
    @GlobalTransactional(name = "my_test_tx_group",rollbackFor = Exception.class)
    /**
     这里添加开启分布式事务的注解,name指定当前全局事务的名称
     rollbackFor表示,发生什么异常需要回滚
     noRollbackFor:表示,发生什么异常不需要回滚
     */
    public void create(Order order) {
        // 1 新建订单
        log.info("----->开始新建订单");
        orderDao.create(order);

        log.info("----->开始调用服务库存，扣减开始");
        storageService.decrease(order.getProductId(), order.getCount().intValue());
        log.info("----->开始调用服务库存，扣减结束");

        log.info("----->开始调用服务库存，扣减开始");
        accountService.decrease(order.getUserId(), order.getMoney().intValue());
        log.info("----->开始调用服务库存，扣减结束");

        log.info("----->修改订单开始");
        orderDao.update(order.getUserId(), 0);
        log.info("----->修改订单结束");

        log.info("----->下单流程结束");
    }

}

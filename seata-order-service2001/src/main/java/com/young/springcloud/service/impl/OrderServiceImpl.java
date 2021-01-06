package com.young.springcloud.service.impl;

import com.young.springcloud.dao.OrderDao;
import com.young.springcloud.domain.Order;
import com.young.springcloud.service.OrderService;
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

    /**
     * 创建订单->调用库存服务扣减库存->调用账户服务扣减账户余额->修改订单状态
     * 简单说:
     * 下订单->减库存->减余额->改状态
     * GlobalTransactional seata开启分布式事务,异常时回滚,name保证唯一即可
     * @param order 订单对象
     */
    @Override
    public void create(Order order) {
        // 1 新建订单
        log.info("----->开始新建订单");
        orderDao.create(order);
    }

}

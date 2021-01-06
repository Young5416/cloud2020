package com.young.springcloud.controller;

import com.young.springcloud.domain.CommonResult;
import com.young.springcloud.domain.Order;
import com.young.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @description:
 * @author: Young
 * @create: 2021-01-06 13:12
 * @Version: 1.0
 **/

@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @PostMapping("/order/create")
    @ResponseBody
    public CommonResult create(@RequestBody Order order) {
        orderService.create(order);
        return new CommonResult(200, "订单创建成功");
    }
}

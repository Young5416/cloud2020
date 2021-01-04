package com.young.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.young.springcloud.entities.CommonResult;

/**
 * @description:
 * @author: Young
 * @create: 2021-01-04 17:18
 * @Version: 1.0
 **/
public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException exception) {
        return new CommonResult(4444, "按客户自定义，global handlerException-------1");
    }

    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult(4444, "按客户自定义，global handlerException-------2");
    }
}

package com.young.springcloud.controller;

import com.young.springcloud.domain.CommonResult;
import com.young.springcloud.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Young
 * @create: 2021-01-06 18:23
 * @Version: 1.0
 **/
@RestController
public class StorageController {

    @Autowired
    private StorageService storageService;

    @PostMapping("/storage/decrease")
    public CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count")Integer count){
        storageService.decrease(productId,count);
        return new CommonResult(200, "扣减库存成功");
    }
}

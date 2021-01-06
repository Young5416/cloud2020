package com.young.springcloud.controller;

import com.young.springcloud.domain.CommonResult;
import com.young.springcloud.service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: Young
 * @create: 2021-01-06 19:56
 * @Version: 1.0
 **/

@RestController
public class AccountController {

    @Resource
    private AccountService accountService;

    @PostMapping("/account/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") Integer money){
        accountService.decrease(userId,money);
        return new CommonResult(200, "扣减余额成功");
    }
}

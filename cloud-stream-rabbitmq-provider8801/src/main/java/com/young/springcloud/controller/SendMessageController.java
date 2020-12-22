package com.young.springcloud.controller;

import com.young.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: Young
 * @create: 2020-12-22 14:05
 * @Version: 1.0
 **/

@RestController
public class SendMessageController {

    @Resource
    private IMessageProvider iMessageProvider;

    @GetMapping("/sendMessage")
    public String sendMessage() {
        return iMessageProvider.send();
    }
}

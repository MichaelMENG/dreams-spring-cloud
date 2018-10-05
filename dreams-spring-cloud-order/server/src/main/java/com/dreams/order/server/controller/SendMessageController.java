package com.dreams.order.server.controller;

import com.dreams.order.server.message.StreamReceiver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendMessageController {

    @Autowired
    StreamReceiver streamReceiver;

    @GetMapping("/sendMessage")
    public void process() {
        streamReceiver.handle("欢迎来到 Spring Cloud 世界！");
    }
}

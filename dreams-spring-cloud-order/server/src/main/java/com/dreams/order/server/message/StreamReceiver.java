package com.dreams.order.server.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;

@EnableBinding(Processor.class)
@Slf4j
public class StreamReceiver {

    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public String handle(String value) {
        System.out.println("Received: " + value);
        return value.toUpperCase();
    }


}

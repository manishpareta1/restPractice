package com.rest.consumer.demo.controller;

import com.rest.consumer.demo.model.Message;
import com.rest.consumer.demo.util.ConfigUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestConsumerController {

    @Autowired
    ConfigUtil util;


    @GetMapping("/welcome/message")
    Message getMessage(){
        Message message = util.rest().getForObject(util.getProperty("endpoint")+util.getProperty("msg"), Message.class);
        return message;
    }

    @GetMapping("/welcome/createMessage")
    Message createMessage(){
        Message message = new Message("Message Requested by client");
       return util.rest().postForObject(util.getProperty("endpoint")+util.getProperty("createmessage"),message, Message.class);
    }


}

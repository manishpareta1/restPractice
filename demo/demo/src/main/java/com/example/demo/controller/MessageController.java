package com.example.demo.controller;

import com.example.demo.modle.Message;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController {

    @GetMapping("/message")
    Message send(){
        return new Message("Hello There!!");
    }

    @PostMapping("/createMessage")
    Message echo(@RequestBody Message message){
        return message;

    }

}

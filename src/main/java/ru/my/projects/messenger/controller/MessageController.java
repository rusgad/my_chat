package ru.my.projects.messenger.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.my.projects.messenger.dto.MessageDto;

import java.security.Principal;

@Controller
public class MessageController {

    @MessageMapping("/message")
    @SendTo("/topic/message")
    public MessageDto send(MessageDto message) {
//        System.out.println(principal.getName());
//        а когда заполняется principal?
        return message;
    }

    @GetMapping
    public String getSomething() {
        return "something";
    }
}

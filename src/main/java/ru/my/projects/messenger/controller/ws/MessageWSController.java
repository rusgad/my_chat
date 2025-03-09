package ru.my.projects.messenger.controller.ws;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import ru.my.projects.messenger.dto.MessageDto;

import java.security.Principal;

@Controller
public class MessageWSController {

    @SubscribeMapping("/message.{chat_id}")
    public MessageDto send(@DestinationVariable("chat_id") String chatId, MessageDto message, Principal principal) {
        return message;
    }
}

package ru.my.projects.messenger.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.my.projects.messenger.dto.DeleteMessageDto;
import ru.my.projects.messenger.dto.MessageDto;
import ru.my.projects.messenger.dto.SaveNewMessageDto;
import ru.my.projects.messenger.service.messaging.MessageService;

@RestController
@RequestMapping("/message")
@AllArgsConstructor
public class MessageController {

    private MessageService messageService;

    @PostMapping("/create-new-message")
    public ResponseEntity<?> createNewMessage(@RequestBody SaveNewMessageDto newMessageDto) {
        try {
            messageService.createMessage(newMessageDto);
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping("/delete-message")
    public ResponseEntity<?> deleteMessage(@RequestBody DeleteMessageDto deleteMessageDto) {
        try {
            messageService.deleteMessage(deleteMessageDto);
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().build();
    }

    @SubscribeMapping("/message")
//    @SendTo("/topic/message")
    public MessageDto send(MessageDto message) {
//        System.out.println(principal.getName());
//        а когда заполняется principal? todo позже добавить идентификацию пользователя
        return message;
    }
}

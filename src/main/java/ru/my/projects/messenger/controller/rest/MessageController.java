package ru.my.projects.messenger.controller.rest;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.my.projects.messenger.dto.SaveNewMessageDto;
import ru.my.projects.messenger.service.messaging.MessageService;

import java.security.Principal;

@RestController
@RequestMapping("/message")
@AllArgsConstructor
public class MessageController {

    private MessageService messageService;

    @PostMapping("/new")
    public ResponseEntity<?> createNewMessage(@RequestBody SaveNewMessageDto newMessageDto, Principal principal) {
        try {
            messageService.createMessage(newMessageDto, principal.getName());
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().build();
    }
}

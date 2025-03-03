package ru.my.projects.messenger.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.my.projects.messenger.dto.CreateChatDto;
import ru.my.projects.messenger.service.chat.ChatService;

@RestController
@RequestMapping("/chat")
@AllArgsConstructor
public class ChatController {

    private ChatService chatService;

    @PostMapping("/")
    public ResponseEntity<?> createChat(@RequestBody CreateChatDto createChatDto) {
        boolean created = chatService.createChat(createChatDto);
        return created ? ResponseEntity.ok().build() : ResponseEntity.internalServerError().build();
    }
}

package ru.my.projects.messenger.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.my.projects.messenger.dto.CreateChatDto;
import ru.my.projects.messenger.service.chat.ChatService;

import java.security.Principal;

@RestController
@RequestMapping("/chat")
@AllArgsConstructor
public class ChatController {

    private ChatService chatService;

    @PostMapping("/create-new-chat")
    public ResponseEntity<?> createChat(@RequestBody CreateChatDto createChatDto, Principal principal) {
        boolean created = chatService.createChat(principal.getName(), createChatDto);
        return created ? ResponseEntity.ok().build() : ResponseEntity.internalServerError().build();
    }

    @GetMapping
    public ResponseEntity<?> getAllChats(Principal principal) {
        return ResponseEntity.ok(chatService.getAllChatForCurrentUser(principal.getName()));
    }
}

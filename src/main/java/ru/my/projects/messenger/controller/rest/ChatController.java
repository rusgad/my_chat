package ru.my.projects.messenger.controller.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.my.projects.messenger.dto.CreateChatDto;
import ru.my.projects.messenger.service.chat.ChatService;

import java.security.Principal;

@RestController
@RequestMapping("/chats")
@AllArgsConstructor
@Tag(name = "Чаты")
public class ChatController {

    private ChatService chatService;

    @Operation(summary = "Создание нового чата")
    @PostMapping("/new")
    public ResponseEntity<?> createChat(@RequestBody CreateChatDto createChatDto, Principal principal) {
        boolean created = chatService.createChat(principal.getName(), createChatDto);
        return created ? ResponseEntity.ok().build() : ResponseEntity.internalServerError().build();
    }

    @Operation(summary = "Выдать все чаты доступные пользователю")
    @GetMapping
    public ResponseEntity<?> getAllChats(Principal principal) {
        return ResponseEntity.ok(chatService.getAllChatForCurrentUser(principal.getName()));
    }
}

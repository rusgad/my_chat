package ru.my.projects.messenger.controller.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.my.projects.messenger.dto.MessageDto;
import ru.my.projects.messenger.dto.SaveNewMessageDto;
import ru.my.projects.messenger.service.messaging.MessageService;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/message")
@AllArgsConstructor
@Tag(name = "Сообщения")
public class MessageController {

    private MessageService messageService;

    @Operation(summary = "Создание нового сообщения для чата")
    @PostMapping("/new")
    public ResponseEntity<?> createNewMessage(@RequestBody SaveNewMessageDto newMessageDto, Principal principal) {
        try {
            messageService.createMessage(newMessageDto, principal.getName());
            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Operation(summary = "Загрузить историю сообщений для чата")
    @GetMapping("/chat-history")
    public ResponseEntity<List<MessageDto>> getChatHistory(@RequestParam String chatName) {
        try {
            return ResponseEntity.ok(messageService.getMessages(chatName));
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }
}

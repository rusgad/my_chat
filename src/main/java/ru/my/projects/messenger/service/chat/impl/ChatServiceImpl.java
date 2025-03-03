package ru.my.projects.messenger.service.chat.impl;

import org.springframework.stereotype.Service;
import ru.my.projects.messenger.dto.ChatDto;
import ru.my.projects.messenger.dto.CreateChatDto;
import ru.my.projects.messenger.service.chat.ChatService;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {
    @Override
    public boolean createChat(String creatorUsername, CreateChatDto createChatDto) {
        return false;
    }

    @Override
    public boolean dropChat() {
        return false;
    }

    @Override
    public List<ChatDto> getAllChatForCurrentUser(String username) {
        return List.of(ChatDto.builder().name("chatOne").build(), ChatDto.builder().name("chatTwo").build(), ChatDto.builder().name("chatThree").build());
    }
}

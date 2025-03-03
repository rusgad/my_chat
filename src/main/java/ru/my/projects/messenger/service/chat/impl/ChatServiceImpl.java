package ru.my.projects.messenger.service.chat.impl;

import org.springframework.stereotype.Service;
import ru.my.projects.messenger.dto.CreateChatDto;
import ru.my.projects.messenger.service.chat.ChatService;

@Service
public class ChatServiceImpl implements ChatService {
    @Override
    public boolean createChat(CreateChatDto createChatDto) {
        return false;
    }

    @Override
    public boolean dropChat() {
        return false;
    }
}

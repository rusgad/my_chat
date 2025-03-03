package ru.my.projects.messenger.service.chat;

import ru.my.projects.messenger.dto.CreateChatDto;

public interface ChatService {
    boolean createChat(CreateChatDto createChatDto);
    boolean dropChat();
}

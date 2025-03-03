package ru.my.projects.messenger.service.chat;

import ru.my.projects.messenger.dto.ChatDto;
import ru.my.projects.messenger.dto.CreateChatDto;

import java.util.List;

public interface ChatService {
    boolean createChat(String creatorUsername, CreateChatDto createChatDto);
    boolean dropChat();
    List<ChatDto> getAllChatForCurrentUser(String username);
}

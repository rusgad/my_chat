package ru.my.projects.messenger.service.chat;

import ru.my.projects.messenger.dto.ChatDto;
import ru.my.projects.messenger.dto.CreateChatDto;
import ru.my.projects.messenger.model.User;

import java.util.List;

public interface ChatService {
    void createChat(String creatorUsername, CreateChatDto createChatDto);
    void dropChat(ChatDto chatDto);
    List<ChatDto> getAllChatForCurrentUser(User user);
}

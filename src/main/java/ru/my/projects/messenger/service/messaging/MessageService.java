package ru.my.projects.messenger.service.messaging;

import ru.my.projects.messenger.dto.MessageDto;
import ru.my.projects.messenger.dto.SaveNewMessageDto;

import java.util.List;

public interface MessageService {
    void createMessage(SaveNewMessageDto newMessage, String username);
    List<MessageDto> getMessages(String chatName);
//    void deleteMessage(DeleteMessageDto message);
}

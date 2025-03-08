package ru.my.projects.messenger.service.messaging;

import ru.my.projects.messenger.dto.SaveNewMessageDto;

public interface MessageService {
    void createMessage(SaveNewMessageDto newMessage, String username);
//    void deleteMessage(DeleteMessageDto message);
}

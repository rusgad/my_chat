package ru.my.projects.messenger.service.messaging;

import ru.my.projects.messenger.dto.DeleteMessageDto;
import ru.my.projects.messenger.dto.SaveNewMessageDto;

public interface MessageService {
    void createMessage(SaveNewMessageDto newMessage);
    void deleteMessage(DeleteMessageDto message);
}

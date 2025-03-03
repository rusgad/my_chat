package ru.my.projects.messenger.service.messaging.impl;

import lombok.AllArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import ru.my.projects.messenger.converter.MessageConverter;
import ru.my.projects.messenger.dto.DeleteMessageDto;
import ru.my.projects.messenger.dto.SaveNewMessageDto;
import ru.my.projects.messenger.service.messaging.MessageService;

@Service
@AllArgsConstructor
public class MessageServiceImpl implements MessageService {

    SimpMessagingTemplate template;

    @Override
    public void createMessage(SaveNewMessageDto newMessage) {
        // todo сохранить в базу
        template.convertAndSend("/topic/message", MessageConverter.convertToMessageDto(newMessage));
    }

//    @Override
//    public void deleteMessage(DeleteMessageDto message) {
//        // todo удалить из базы;
//    }
}

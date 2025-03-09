package ru.my.projects.messenger.converter;

import ru.my.projects.messenger.dto.MessageDto;
import ru.my.projects.messenger.dto.SaveNewMessageDto;
import ru.my.projects.messenger.model.Chat;
import ru.my.projects.messenger.model.Message;
import ru.my.projects.messenger.model.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class MessageConverter {
    public static MessageDto createMessageDtoFromNewMessage(SaveNewMessageDto newMessageDto, String username) {
        return MessageDto.builder()
                .from(username)
                .content(newMessageDto.getContent())
                .build();
    }

    public static List<MessageDto> convertToDtos(List<Message> messages) {
        return messages.stream().map(entity ->
                MessageDto.builder()
                        .from(entity.getUser().getUsername())
                        .content(entity.getContent())
                        .build()
        ).collect(Collectors.toList());
    }

    public static Message convertToMessage(SaveNewMessageDto newMessage, Chat chat, User user) {
        return Message.builder()
                .content(newMessage.getContent())
                .chat(chat)
                .user(user)
                .createdAt(LocalDateTime.now())
                .build();
    }
}

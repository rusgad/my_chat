package ru.my.projects.messenger.converter;

import ru.my.projects.messenger.dto.MessageDto;
import ru.my.projects.messenger.dto.SaveNewMessageDto;

public class MessageConverter {
    public static MessageDto convertToMessageDto(SaveNewMessageDto newMessageDto, String username) {
        return MessageDto.builder()
                .from(username)
                .content(newMessageDto.getContent())
                .build();
    }
}

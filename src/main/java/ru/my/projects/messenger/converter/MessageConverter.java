package ru.my.projects.messenger.converter;

import ru.my.projects.messenger.dto.MessageDto;
import ru.my.projects.messenger.dto.SaveNewMessageDto;

public class MessageConverter {
    public static MessageDto convertToMessageDto(SaveNewMessageDto newMessageDto) {
        return MessageDto.builder()
                .from(newMessageDto.getFrom())
                .content(newMessageDto.getContent())
                .build();
    }
}

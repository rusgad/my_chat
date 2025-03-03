package ru.my.projects.messenger.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class CreateChatDto {
    private String chatName;
    private LocalDateTime createdAt;
    private int[] participantIds;
}

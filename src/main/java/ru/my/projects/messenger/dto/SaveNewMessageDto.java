package ru.my.projects.messenger.dto;

import lombok.Getter;

@Getter
public class SaveNewMessageDto {
    private String content;
    private String chatName;
}

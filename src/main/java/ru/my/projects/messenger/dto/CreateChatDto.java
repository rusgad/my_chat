package ru.my.projects.messenger.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.Set;

@Builder
@Getter
public class CreateChatDto {
    private String chatName;
    private Set<String> participantUsernames;
}

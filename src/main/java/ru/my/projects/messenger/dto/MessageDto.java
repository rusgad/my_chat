package ru.my.projects.messenger.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageDto {

    private String from;
    private String content;
}

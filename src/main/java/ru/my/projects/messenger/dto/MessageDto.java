package ru.my.projects.messenger.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MessageDto {

    private String from;
    private String content;
    //todo добавить дату создания
}

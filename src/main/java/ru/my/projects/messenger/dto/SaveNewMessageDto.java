package ru.my.projects.messenger.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;

@Getter
@Tag(name = "Дто нового сообщения")
public class SaveNewMessageDto {

    @Schema(name = "Содержимое сообщения", requiredMode = Schema.RequiredMode.REQUIRED)
    private String content;

    @Schema(name = "Название чата для которого предназначено сообщение", requiredMode = Schema.RequiredMode.REQUIRED)
    private String chatName;
}

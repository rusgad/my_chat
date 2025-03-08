package ru.my.projects.messenger.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Tag(name = "Дто сообщения")
public class MessageDto {

    @Schema(name = "Отправитель", requiredMode = Schema.RequiredMode.REQUIRED)
    private String from;

    @Schema(name = "Содержимое сообщения", requiredMode = Schema.RequiredMode.REQUIRED)
    private String content;
    //todo добавить дату создания
}

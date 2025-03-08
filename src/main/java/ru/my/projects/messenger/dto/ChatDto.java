package ru.my.projects.messenger.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Tag(name = "Дто чата")
public class ChatDto { // todo покрыть все свагером

    @Schema(name = "Название чата", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;
}

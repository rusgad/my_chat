package ru.my.projects.messenger.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Builder;
import lombok.Getter;

import java.util.Set;

@Builder
@Getter
@Tag(name = "Дто для создания чата")
public class CreateChatDto {

    @Schema(name = "Название чата", requiredMode = Schema.RequiredMode.REQUIRED)
    private String chatName;

    @Schema(name = "Список участников чата", requiredMode = Schema.RequiredMode.REQUIRED)
    private Set<String> participantUsernames;
}

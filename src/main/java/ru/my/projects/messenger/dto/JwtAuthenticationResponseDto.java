package ru.my.projects.messenger.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(name = "Ответ с токеном доступа")
public class JwtAuthenticationResponseDto {

    @Schema(name = "Токен доступа")
    private String token;
}

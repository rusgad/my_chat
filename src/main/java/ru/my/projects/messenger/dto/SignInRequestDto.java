package ru.my.projects.messenger.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(name = "Запрос на аутентификацию")
public class SignInRequestDto {

    @Schema(name = "Имя пользователя", example = "Ruslan")
    @Size(min = 6, max = 30, message = "Имя пользователя должно состоять из 6 до 30 символов")
    @NotBlank(message = "Имя обязательно для ввода")
    private String username;

    @Schema(description = "Пароль", example = "my_1secret1_password")
    @Size(max = 255, message = "Длина пароля должна быть не более 255 символов")
    @NotBlank(message = "Пароль не может быть пустыми")
    private String password;
}

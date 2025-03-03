package ru.my.projects.messenger.service.auth;


import ru.my.projects.messenger.dto.JwtAuthenticationResponseDto;
import ru.my.projects.messenger.dto.SignInRequestDto;
import ru.my.projects.messenger.dto.SignUpRequestDto;

public interface AuthenticationService {
    JwtAuthenticationResponseDto signUp(SignUpRequestDto signUpRequest);
    JwtAuthenticationResponseDto signIn(SignInRequestDto signInRequest);
}

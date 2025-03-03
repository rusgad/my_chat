package ru.my.projects.messenger.service.auth.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.my.projects.messenger.dto.JwtAuthenticationResponseDto;
import ru.my.projects.messenger.dto.SignInRequestDto;
import ru.my.projects.messenger.dto.SignUpRequestDto;
import ru.my.projects.messenger.enums.Role;
import ru.my.projects.messenger.model.User;
import ru.my.projects.messenger.service.auth.AuthenticationService;
import ru.my.projects.messenger.service.auth.JwtTokenService;
import ru.my.projects.messenger.service.auth.UserService;


@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserService userService;
    private final JwtTokenService jwtTokenService;
    private final AuthenticationManager authenticationManager; // todo что делает authenticationManager
    private final PasswordEncoder passwordEncoder;

    @Override
    public JwtAuthenticationResponseDto signUp(SignUpRequestDto signUpRequest) {
        User user = User.builder()
                .username(signUpRequest.getUsername())
                .password(passwordEncoder.encode(signUpRequest.getPassword()))
                .email(signUpRequest.getEmail())
                .role(Role.USER)
                .isEnabled(true)
                .build();
        userService.create(user);

        String token = jwtTokenService.generateToken(user);
        return JwtAuthenticationResponseDto.builder()
                .token(token)
                .build();
    }

    @Override
    public JwtAuthenticationResponseDto signIn(SignInRequestDto signInRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                signInRequest.getUsername(),
                signInRequest.getPassword()
        ));

        var user = userService
                .userDetailsService()
                .loadUserByUsername(signInRequest.getUsername());

        var token = jwtTokenService.generateToken(user);
        return JwtAuthenticationResponseDto.builder()
                .token(token)
                .build();
    }
}

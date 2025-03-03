package ru.my.projects.messenger.service.auth;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtTokenService {
    String extractUserName(String token);
    String generateToken(UserDetails userDetails);
    boolean isTokenValid(String token, UserDetails userDetails);
}

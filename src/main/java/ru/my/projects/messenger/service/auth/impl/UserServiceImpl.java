package ru.my.projects.messenger.service.auth.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.my.projects.messenger.model.User;
import ru.my.projects.messenger.repository.UserRepository;
import ru.my.projects.messenger.service.auth.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public User create(User user) {
        if (repository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Пользователь с таким именем уже существует");
        }
        if (repository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Пользователь с таким email уже существует");
        }
        return repository.save(user);
    }

    public UserDetailsService userDetailsService() {
        return this::getByUsername;
    }

    private User getByUsername(String username) {
        return repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден"));

    }
}

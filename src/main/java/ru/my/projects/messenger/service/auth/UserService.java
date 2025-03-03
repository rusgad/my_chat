package ru.my.projects.messenger.service.auth;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.my.projects.messenger.model.User;

public interface UserService {
    User create(User user);
    UserDetailsService userDetailsService();
}

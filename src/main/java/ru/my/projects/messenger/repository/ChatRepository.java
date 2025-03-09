package ru.my.projects.messenger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.my.projects.messenger.model.Chat;
import ru.my.projects.messenger.model.User;

import java.util.List;
import java.util.Optional;

public interface ChatRepository extends JpaRepository<Chat, Long> {
    List<Chat> findChatsByParticipants(User user);
    Optional<Chat> findChatByName(String name);
}

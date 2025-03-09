package ru.my.projects.messenger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.my.projects.messenger.model.Message;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByChatName(String chatName);
    List<Message> findAllByChat_Name(String chatName);
}

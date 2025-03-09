package ru.my.projects.messenger.service.chat.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.my.projects.messenger.dto.ChatDto;
import ru.my.projects.messenger.dto.CreateChatDto;
import ru.my.projects.messenger.model.Chat;
import ru.my.projects.messenger.model.User;
import ru.my.projects.messenger.repository.ChatRepository;
import ru.my.projects.messenger.repository.UserRepository;
import ru.my.projects.messenger.service.chat.ChatService;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final ChatRepository chatRepository;
    private final UserRepository userRepository;

    @Override
    public void createChat(String creatorUsername, CreateChatDto createChatDto) {
        List<User> participantUsers = getParticipantUsers(creatorUsername, createChatDto);

        Chat newChat = Chat.builder()
                .name(createChatDto.getChatName())
                .createdAt(LocalDateTime.now())
                .participants(participantUsers)
                .build();
        chatRepository.save(newChat);
    }

    private List<User> getParticipantUsers(String creatorUsername, CreateChatDto createChatDto) {
        Set<String> participantUsernames = new HashSet<>(createChatDto.getParticipantUsernames());
        participantUsernames.add(creatorUsername);
        return userRepository.findAllByUsernameIn(participantUsernames);
    }

    @Override
    public void dropChat(ChatDto chatDto) {
        chatRepository.delete(Chat.builder().name(chatDto.getName()).build());
    }

    @Override
    public List<ChatDto> getAllChatForCurrentUser(User user) {
        List<Chat> chats = chatRepository.findChatsByParticipants(user);
        return chats.stream().map(entity ->
                ChatDto.builder().name(entity.getName()).build()).collect(Collectors.toList());
    }
}

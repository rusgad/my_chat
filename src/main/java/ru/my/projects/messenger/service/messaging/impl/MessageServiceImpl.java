package ru.my.projects.messenger.service.messaging.impl;

import lombok.AllArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import ru.my.projects.messenger.converter.MessageConverter;
import ru.my.projects.messenger.dto.MessageDto;
import ru.my.projects.messenger.dto.SaveNewMessageDto;
import ru.my.projects.messenger.model.Chat;
import ru.my.projects.messenger.model.Message;
import ru.my.projects.messenger.model.User;
import ru.my.projects.messenger.repository.ChatRepository;
import ru.my.projects.messenger.repository.MessageRepository;
import ru.my.projects.messenger.repository.UserRepository;
import ru.my.projects.messenger.service.messaging.MessageService;

import java.util.List;

@Service
@AllArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final SimpMessagingTemplate template;
    private final MessageRepository messageRepository;
    private final UserRepository userRepository;
    private final ChatRepository chatRepository;

    @Override
    public void createMessage(SaveNewMessageDto newMessage, String username) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
        Chat chat = chatRepository.findChatByName(newMessage.getChatName()).orElseThrow(() -> new RuntimeException("Chat not found"));
        // todo а почему нельзя через userDetails? это будет запрос в базу?
        // todo можно ли сделать ссылку как chatName?
        Message message = MessageConverter.convertToMessage(newMessage, chat, user);
        messageRepository.save(message);
        template.convertAndSend("/topic/message." + newMessage.getChatName(), MessageConverter.createMessageDtoFromNewMessage(newMessage, username));
    }

    @Override
    public List<MessageDto> getMessages(String chatName) {
        List<Message> messages = messageRepository.findAllByChat_Name(chatName);
        return MessageConverter.convertToDtos(messages);
    }
}

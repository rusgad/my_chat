package ru.my.projects.messenger.configs.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.security.config.annotation.web.socket.EnableWebSocketSecurity;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
//@EnableWebSocketSecurity
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic"); // - создаем очередь topic
        config.setApplicationDestinationPrefixes("/app"); // - просто префикс после которого мы ставим точку контроллера (messages)
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {

        registry.addEndpoint("/chat-websocket")
                .setAllowedOrigins("http://localhost:3000")
                .withSockJS(); // – это URL-адрес протокола HTTP для конечной точки,
        // к которой клиент WebSocket (или SockJS) должен подключиться для подтверждения установления связи по протоколу WebSocket.
    }
//
//    @Override
//    public void configureClientInboundChannel(ChannelRegistration registration) {
//        registration.interceptors(new ChannelInterceptor() {
//            @Override
//            public Message<?> preSend(Message<?> message, MessageChannel channel) {
//                StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);
//                String token = accessor.getFirstNativeHeader("Authorization");
//                System.out.println(token);
//                if (token != null && token.startsWith("Bearer ")) {
//                    // Ваша логика проверки токена
//                }
//                return message;
//            }
//        });
//    }
}

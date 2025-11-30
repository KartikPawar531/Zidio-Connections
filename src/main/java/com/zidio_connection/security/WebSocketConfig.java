package com.zidio_connection.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.*;
import com.zidio_connection.Service.ChatSupportService;


@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
	
	@Autowired
	private ChatSupportService chatSupportService;
	
	public WebSocketConfig(ChatSupportService chatSupportService ) {
		this.chatSupportService =  chatSupportService;
	}

	public void registerStampEndPoints(StompEndpointRegistry register) {
		chatSupportService.logcoonection("Registration STAMP Endpoint...");
		register.addEndpoint("WS-chat").setAllowedOriginPatterns("*").withSockJS();
	}
	
	public void configureMessageBroker(MessageBrokerRegistry register) {
		chatSupportService.logcoonection("Configuration  Message Broker...");
		register.enableSimpleBroker("/topic");
		register.setApplicationDestinationPrefixes("/app");
	}
}

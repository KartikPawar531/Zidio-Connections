package com.zidio_connection.Controller;

import java.time.LocalDateTime;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zidio_connection.Entity.ChatSupport;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/support")
@RequiredArgsConstructor
public class ChatSupportController {

	@MessageMapping("/sendMessage")
	@SendTo("/topic/messages")
	public ChatSupport sendMessage(@Payload ChatSupport support) {
		support.setTimeStamp(LocalDateTime.now());
		return support;
	}
}

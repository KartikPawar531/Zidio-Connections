package com.zidio_connection.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.messaging.SubProtocolWebSocketHandler;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatSupportService {
 
	public void logcoonection(String message) {
		System.out.println("Websocket log:"+message);
	}	
}

package com.zidio_connection.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name="support")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatSupport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String senderID;
	private String receiverID;
	private String message;
	private LocalDateTime timeStamp;	
}

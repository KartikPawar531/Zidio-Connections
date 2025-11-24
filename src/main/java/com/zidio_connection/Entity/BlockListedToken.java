package com.zidio_connection.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="loggedOut")
@Data
@AllArgsConstructor
//@NoArgsConstructor
@Builder
public class BlockListedToken {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDateTime loggedOutAt;
	
	@Column(name="token",nullable=false,unique=true,length=500)
	private String token;
	
	public BlockListedToken(String token,LocalDateTime loggedOutAt) {
		this.token=token;
		this.loggedOutAt=loggedOutAt;
	}
}

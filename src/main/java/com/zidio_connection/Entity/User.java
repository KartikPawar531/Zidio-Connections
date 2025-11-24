package com.zidio_connection.Entity;

import java.time.LocalDateTime;

import com.zidio_connection.Enum.Role;

import jakarta.persistence.*;
import lombok.*;;

@Entity
@Table(name="users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder

public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String userName;
	
	@Column(unique = true)
	private String userEmail;
	private String password;
	private Role role;
	private String resetToken;
	private LocalDateTime resetTokenExpire;
	private boolean active = true;
	
}

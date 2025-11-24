package com.zidio_connection.DTO;

import lombok.*;

// this DTO is used For Login

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginRequestDTO {

	public String userEmail;
	public String password;
}

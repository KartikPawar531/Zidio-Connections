package com.zidio_connection.DTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginRequestDTO {

	public String userEmail;
	public String password;
}

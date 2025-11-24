package com.zidio_connection.DTO;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResetPasswordRequestDTO {

	private String token;
	private String newPassword;	
}

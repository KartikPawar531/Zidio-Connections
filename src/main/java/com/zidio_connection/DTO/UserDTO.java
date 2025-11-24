package com.zidio_connection.DTO;
// This DTO is used for REgister
import com.zidio_connection.Enum.Role;

import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {

	public String userName;
	public String userEmail;
	public String password;
	public Role role;
}

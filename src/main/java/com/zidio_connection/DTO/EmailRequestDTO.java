package com.zidio_connection.DTO;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailRequestDTO {

	private String to;
	private String subject;
	private String body;
}

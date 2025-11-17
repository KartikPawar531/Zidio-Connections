package com.zidio_connection.DTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminActionDTO {

	private String adminId;
	private String targetUSerId;
	private String action;
}

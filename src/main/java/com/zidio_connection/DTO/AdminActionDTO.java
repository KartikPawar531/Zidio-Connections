package com.zidio_connection.DTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class AdminActionDTO {

	private String adminId;
	private String targetUSerID;
	private String action;
}

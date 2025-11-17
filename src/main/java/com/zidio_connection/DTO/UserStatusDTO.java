package com.zidio_connection.DTO;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserStatusDTO {

	private int totalJobseekers;
	private int totalRecruiters;
	private int blockedUsers;
}

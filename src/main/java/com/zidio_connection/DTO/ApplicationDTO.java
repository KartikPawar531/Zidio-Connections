package com.zidio_connection.DTO;

import com.zidio_connection.Enum.ApplicationStatus;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplicationDTO {

	private Long jobId;
	private String recruiterId;
	private ApplicationStatus status;
}

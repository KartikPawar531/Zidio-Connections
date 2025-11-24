package com.zidio_connection.DTO;

import com.zidio_connection.Enum.ApplicationStatus;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class ApplicationDTO {

	private Long jobId;
	private String recruiterId;
	
	@Enumerated(EnumType.STRING)
	private ApplicationStatus status;
}

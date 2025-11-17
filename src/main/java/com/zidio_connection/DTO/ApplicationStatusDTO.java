package com.zidio_connection.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ApplicationStatusDTO {

	private int totalJobApplications;
	private int shortlisted;
	private int rejected;
	private int pendingApplications;
	private int interviewProcess;
}

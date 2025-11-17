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
public class JobStatusDTO {

	private int totalJobs;
	private int internships;
	private int fullTimes;
	private int contractual;
	private int partTime;
	private int freelance;
}

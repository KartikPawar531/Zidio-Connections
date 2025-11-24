package com.zidio_connection.DTO;

import java.time.LocalDateTime;

import com.zidio_connection.Enum.JobType;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class JobPostDTO {

	private String jobTitle;
	private String jobDescription;
	private String companyName;
	private String jobLocation;
	private String remote;
	private JobType jobType;
	private LocalDateTime postedDate;  
	private LocalDateTime deadlineDate;
}

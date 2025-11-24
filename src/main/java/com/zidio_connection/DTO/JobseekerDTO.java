package com.zidio_connection.DTO;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class JobseekerDTO {

	private Long id;
	private Long userId;
	private String jobseekerFullName;
	private String jobseekerEmail;
	private String universityName;
	private String educationalStream;
	private String passoutYear;
	private String skills;
	private String resumeUrl;
	private String certificateJpg;
}

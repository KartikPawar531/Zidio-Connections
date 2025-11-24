package com.zidio_connection.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "jobseekers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Jobseeker {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

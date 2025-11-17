package com.zidio_connection.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "recruiters")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Recruiter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long userId;
	private String RecruiterName;
	private String companyEmail;
	private String recruiterNumber;
	private String companyName;
	private String companyWebsite;
	private String companyLocation;
}

package com.zidio_connection.Entity;

import java.time.LocalDateTime;

import com.zidio_connection.Enum.JobType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name="JobPosts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobPost {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String recruiterId;
	private String jobTitle;
	private String jobDescription;
	private String companyName;
	private String jobLocation;
	private String remote;
	private JobType jobType;
	private LocalDateTime postedDate;
	private LocalDateTime deadlineDate;
	private boolean active = true;
}

package com.zidio_connection.Entity;

import java.time.LocalDateTime;
import com.zidio_connection.Enum.JobType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="jobPosts")
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

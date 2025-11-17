package com.zidio_connection.Entity;

import java.time.LocalDateTime;

import com.zidio_connection.Enum.ApplicationStatus;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="applications")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Application {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String jobseekerId;
	private Long jobId;
	private String recruiterId;
	private LocalDateTime apllicationDate;
	private ApplicationStatus status;
}

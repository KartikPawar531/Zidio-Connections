package com.zidio_connection.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "courses")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String courseTitle;
	private String courseDescription;
	private String courseCatogory;
	private String adminId;
	private LocalDateTime createdAt;
	private boolean active;
}

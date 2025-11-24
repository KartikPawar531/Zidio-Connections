package com.zidio_connection.DTO;

import java.time.LocalDateTime;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class CourseDTO {
	
	private Long id;
	private String courseTitle;
	private String courseDescription;
	private String courseCatogory;
	private String adminId;
	private LocalDateTime createdAt;
	private boolean active;

}

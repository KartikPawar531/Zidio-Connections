package com.zidio_connection.DTO;

import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class CourseStatusDTO {

	private int totalCourses;
	private int activeCourses;
	private int isActiveCourses;
}

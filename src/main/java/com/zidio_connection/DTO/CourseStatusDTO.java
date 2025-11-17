package com.zidio_connection.DTO;

import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseStatusDTO {

	private int totalCourses;
	private int activeCourses;
	private int isActiveCourses;
	public int getTotalCourses() {
		return totalCourses;
	}
	public void setTotalCourses(int totalCourses) {
		this.totalCourses = totalCourses;
	}
	public int getActiveCourses() {
		return activeCourses;
	}
	public void setActiveCourses(int activeCourses) {
		this.activeCourses = activeCourses;
	}
	public int getIsActiveCourses() {
		return isActiveCourses;
	}
	public void setIsActiveCourses(int isActiveCourses) {
		this.isActiveCourses = isActiveCourses;
	}
}

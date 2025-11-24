package com.zidio_connection.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zidio_connection.DTO.CourseDTO;
import com.zidio_connection.Entity.Course;
import com.zidio_connection.Repository.CourseRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseService {

	@Autowired
	private CourseRepository courseRepo;

	public CourseDTO addCourse(CourseDTO dto) 
	{
		Course course = new Course();
		course.setCourseTitle(dto.getCourseTitle());
		course.setCourseDescription(dto.getCourseDescription());
		course.setCourseCatogory(dto.getCourseCatogory());
		course.setAdminId(dto.getAdminId());
		course.setCreatedAt(dto.getCreatedAt());
		course.setActive(true);

		courseRepo.save(course);
		dto.setId(course.getId());
		dto.setAdminId(course.getAdminId());
		dto.setActive(course.isActive());
		return dto;
	}

	public List<CourseDTO> getAllActiveCourses() 
	{
		return courseRepo.findByActiveTrue().stream().map(c -> {
			CourseDTO dto = new CourseDTO();
			
			dto.setId(c.getId());
			dto.setCourseTitle(c.getCourseTitle());
			dto.setCourseDescription(c.getCourseDescription());
			dto.setCourseCatogory(c.getCourseCatogory());
			dto.setAdminId(c.getAdminId());
			dto.setActive(c.isActive());
			
			return dto;
		}).collect(Collectors.toList());
	}
	
	public void deActiveCourses(Long id) 
	{
		Course course = courseRepo.findById(id).orElseThrow(()-> new RuntimeException("Course not found"));
		course.setActive(false);
		courseRepo.save(course);
	}	
}



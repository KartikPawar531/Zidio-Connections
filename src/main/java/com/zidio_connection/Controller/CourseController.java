package com.zidio_connection.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.zidio_connection.DTO.CourseDTO;
import com.zidio_connection.Service.CourseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {

	private final CourseService courseService;
	
	@PostMapping("/add/{adminId}")
	public ResponseEntity<CourseDTO>addCourse(@PathVariable Long adminId,@RequestBody CourseDTO dto){
		dto.setAdminId(adminId);
		return ResponseEntity.ok(courseService.addCourse(dto));
	}
	
	@GetMapping("/course")
	public ResponseEntity<List<CourseDTO>>getCourses(){
		return ResponseEntity.ok(courseService.getAllActiveCourses());
	}
	
	@PutMapping("/deactivate/{id}")
	public ResponseEntity<String>deactivateCourse(@PathVariable Long id){
		courseService.deActiveCourses(id);
		return ResponseEntity.ok("Courses Deactivate Successfully");
	}	
}

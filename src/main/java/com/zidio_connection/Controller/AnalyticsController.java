package com.zidio_connection.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zidio_connection.DTO.ApplicationStatusDTO;
import com.zidio_connection.DTO.CourseStatusDTO;
import com.zidio_connection.DTO.JobStatusDTO;
import com.zidio_connection.DTO.SubscriptionStatusDTO;
import com.zidio_connection.DTO.UserStatusDTO;
import com.zidio_connection.Service.AnalyticsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/dashboard")
@RequiredArgsConstructor
public class AnalyticsController {

//	@Autowired
	private final AnalyticsService analyticService;
	
	@GetMapping("/users")
	public ResponseEntity<UserStatusDTO>userStatus(){
		return ResponseEntity.ok(analyticService.fetchUserStatus());
	}
	
	@GetMapping("/jobs")
	public ResponseEntity<JobStatusDTO>jobStatus(){
		return ResponseEntity.ok(analyticService.fetchJobStatus());
	}
	
	@GetMapping("/applications")
	public ResponseEntity<ApplicationStatusDTO>applicationStatus(){
		return ResponseEntity.ok(analyticService.fetchApplicationStatus());
	}
	
	@GetMapping("/courses")
	public ResponseEntity<CourseStatusDTO>getCourseStatus(){
		return ResponseEntity.ok(analyticService.fetchCourseStatus());
	}
	
	@GetMapping("/subscriptions")
	public ResponseEntity<SubscriptionStatusDTO>getSubscriptionStatus(){
		return ResponseEntity.ok(analyticService.fetchSubsritionStatus());
	}
}

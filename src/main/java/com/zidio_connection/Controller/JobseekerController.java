package com.zidio_connection.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zidio_connection.DTO.JobseekerDTO;
import com.zidio_connection.Entity.Jobseeker;
import com.zidio_connection.Service.JobseekerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/jobseekers")
@RequiredArgsConstructor
public class JobseekerController {

	private final JobseekerService jobseekerService;
	 
	@PostMapping("/createProfile/{userId}")
	public ResponseEntity<Jobseeker>createJobseekerProfile(@RequestBody JobseekerDTO dto,@PathVariable("userId") Long userID){
		return ResponseEntity.ok(jobseekerService.createJobseekerProfile(userID, dto));
	} 
	
	@GetMapping("/getProfile/{userId}")
	public ResponseEntity<Jobseeker>getJobseekerProfile(@PathVariable("userId") Long userID){
		return ResponseEntity.ok(jobseekerService.getJobseekerProfile(userID));
	}
}

package com.zidio_connection.Controller;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private JobseekerService jobseekerService;
	 
	@PostMapping("/createProfile/{userId}")
	public ResponseEntity<Jobseeker>createJobseekerProfile(@RequestBody JobseekerDTO dto, Long userID){
		return ResponseEntity.ok(jobseekerService.createJobseekerProfile(userID, dto));
	} 
	
	@GetMapping("/getProfile/{userId}")
	public ResponseEntity<Jobseeker>getJobseekerProfile(@PathVariable Long userID){
		return ResponseEntity.ok(jobseekerService.getJobseekerProfile(userID));
	}
}

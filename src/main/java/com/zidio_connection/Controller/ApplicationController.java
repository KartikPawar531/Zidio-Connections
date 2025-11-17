package com.zidio_connection.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zidio_connection.DTO.ApplicationDTO;
import com.zidio_connection.Entity.Application;
import com.zidio_connection.Enum.ApplicationStatus;
import com.zidio_connection.Service.ApplicationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/applications")
@RequiredArgsConstructor
public class ApplicationController {

	@Autowired
	private ApplicationService appService;
	
	@PostMapping("/apply/{jobseekerId}")
	public ResponseEntity<Application>appply(@PathVariable String jobseekerId,@RequestBody ApplicationDTO dto){
		return ResponseEntity.ok(appService.apply(jobseekerId, dto));
	}
	
	@GetMapping("/jobseeker/{jobseekerId}")
	public ResponseEntity<List<Application>> getByJobseeker(@PathVariable String jobseekerId){
		return ResponseEntity.ok(appService.getByJobseekerID(jobseekerId));
	}
	
	@GetMapping("/recruiter/{recruiterId}")
	public ResponseEntity<List<Application>> getByRecruiter(@PathVariable String recruiterId){
		return ResponseEntity.ok(appService.getByRecruiterId(recruiterId));
	}
	
	@GetMapping("/job/{jobId}")
	public ResponseEntity<List<Application>>getByJob(@PathVariable Long jobId){
		return ResponseEntity.ok(appService.getByJobId(jobId));
	}
	
	@PutMapping("/status/{id}")
	public ResponseEntity<Application>UpdateStatus(@PathVariable Long id,@RequestParam ApplicationStatus status){
		return ResponseEntity.ok(appService.updateApplicationStatus(id, status));
	}	
}

package com.zidio_connection.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.zidio_connection.DTO.JobPostDTO;
import com.zidio_connection.Entity.JobPost;
import com.zidio_connection.Service.JobPostService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/jobPost")
@RequiredArgsConstructor
public class JobPostController {

	private final JobPostService jobPostService;
	
	@PostMapping("/post/{recruiterId}")
	public ResponseEntity<JobPost>PostJob(@PathVariable String recruiterId, @RequestBody JobPostDTO dto){
		return ResponseEntity.ok(jobPostService.createJob(recruiterId, dto));
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<JobPost>> getAllJobs(){
		return ResponseEntity.ok(jobPostService.getAllJob());
	}
	
	@GetMapping("/recruiter/{recruiterId}")
	public ResponseEntity<List<JobPost>> getJobByRecruiter(@PathVariable String recruiterId){
		return ResponseEntity.ok(jobPostService.getJobByRecruiter(recruiterId));
	}
	
	@GetMapping("/search/title/{jobTitle}")
	public ResponseEntity<List<JobPost>>getByJobTitle(@PathVariable String jobTitle){
		return ResponseEntity.ok(jobPostService.getJobByJobTitle(jobTitle));
	}
	
	@GetMapping("/search/location/{jobLocation}")
	public ResponseEntity<List<JobPost>>getByJobLocation(@PathVariable String jobLocation){
		return ResponseEntity.ok(jobPostService.searchJobByJobLocation(jobLocation));
	}
	
	@GetMapping("/search/company/{companyName}")
	public ResponseEntity<List<JobPost>>getByCompanyName(@PathVariable String companyName){
		return ResponseEntity.ok(jobPostService.searchJobByCompanyName(companyName));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<JobPost>getById(@PathVariable Long id){
		return ResponseEntity.ok(jobPostService.searchJobByJobId(id));
	}
}

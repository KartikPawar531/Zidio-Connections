package com.zidio_connection.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.zidio_connection.DTO.RecruiterDTO;
import com.zidio_connection.Entity.Recruiter;
import com.zidio_connection.Service.RecruiterService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/recruiters")
@RequiredArgsConstructor
public class RecruiterController {

	@Autowired
	private RecruiterService recruiterService;

	@PostMapping("/profile/{userId}")
	public ResponseEntity<Recruiter> createorUpdate(@PathVariable Long userId, @RequestBody RecruiterDTO dto) {
		return ResponseEntity.ok(recruiterService.createOrUpdateRecruiterProfile(userId, dto));
	}

	@GetMapping("/Profile/{userId}")
	public ResponseEntity<Recruiter> getRecruiterProfile(@PathVariable Long userId) {
		return ResponseEntity.ok(recruiterService.getRecruiterProfile(userId));
	}

	@PutMapping("/recruiterProfile/{userId}")
	public ResponseEntity<Recruiter>updateProfile(Long userId, RecruiterDTO dto){
		return ResponseEntity.ok(recruiterService.Update(userId, dto));
	}
}

package com.zidio_connection.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zidio_connection.DTO.RecruiterDTO;
import com.zidio_connection.Entity.Recruiter;
import com.zidio_connection.Repository.RecruiterRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecruiterService {

	@Autowired
	private RecruiterRepository recruiterRepo;
	
	public Recruiter createOrUpdateRecruiterProfile(Long userId, RecruiterDTO dto) {
		Recruiter recruiter = new Recruiter();
		recruiter.setUserId(userId);
		recruiter.setRecruiterName(dto.getRecruiterName());
		recruiter.setRecruiterNumber(dto.getRecruiterNumber());
		recruiter.setCompanyName(dto.getCompanyName());	
		recruiter.setCompanyEmail(dto.getCompanyEmail());	
		recruiter.setCompanyLocation(dto.getCompanyLocation());
		return recruiterRepo.save(recruiter);
	}
	
	public Recruiter getByUserId(Long userId) {
		return  recruiterRepo.findByuserId(userId).orElseThrow(()-> new RuntimeException("Recruiter Not Found"));
	}
	
	public Recruiter getRecruiterProfile(Long userId) {
		return recruiterRepo.findByuserId(userId).orElseThrow(()-> new RuntimeException("Recruiter Not Found"));
	}
	
	public Recruiter Update(Long userId,RecruiterDTO dto) {
		Recruiter recruiter = new Recruiter();
		recruiter.setCompanyName(dto.getCompanyName());
		recruiter.setCompanyLocation(dto.getCompanyLocation());
		recruiter.setRecruiterNumber(dto.getRecruiterNumber());
		recruiter.setCompanyWebsite(dto.getCompanyWebsite());
		return recruiterRepo.save(recruiter);
	}	
}

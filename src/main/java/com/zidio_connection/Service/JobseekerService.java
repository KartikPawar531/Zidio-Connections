package com.zidio_connection.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zidio_connection.DTO.JobseekerDTO;
import com.zidio_connection.Entity.Jobseeker;
import com.zidio_connection.Repository.JobseekerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JobseekerService {

	@Autowired
	private JobseekerRepository jobseekerRepo;

	public Jobseeker createJobseekerProfile(Long userID, JobseekerDTO dto) {
		Jobseeker jobseek = new Jobseeker();
		jobseek.setUserId(userID);
		jobseek.setJobseekerFullName(dto.getJobseekerFullName());
		jobseek.setJobseekerEmail(dto.getJobseekerEmail());
		jobseek.setUniversityName(dto.getUniversityName());
		jobseek.setEducationalStream(dto.getEducationalStream());
		jobseek.setPassoutYear(dto.getPassoutYear());
		jobseek.setSkills(dto.getSkills());
		jobseek.setResumeUrl(dto.getResumeUrl());
		jobseek.setCertificateJpg(dto.getCertificateJpg());
		return jobseekerRepo.save(jobseek);
	}

	public Jobseeker getJobseekerProfile(Long userId) {
		return jobseekerRepo.findByuserId(userId).orElseThrow(() -> new RuntimeException("Jobseeker Not Found"));
	}
}

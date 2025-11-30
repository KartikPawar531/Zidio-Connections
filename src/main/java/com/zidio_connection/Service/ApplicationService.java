package com.zidio_connection.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zidio_connection.DTO.ApplicationDTO;
import com.zidio_connection.Entity.Application;
import com.zidio_connection.Enum.ApplicationStatus;
import com.zidio_connection.Repository.ApplicationRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ApplicationService {

//	@Autowired
	private final ApplicationRepository appRepo;
	
	@Transactional
	public Application apply(String jobsekerId,ApplicationDTO dto) {
		Application app = new Application();
		app.setJobseekerId(jobsekerId);
		app.setRecruiterId(dto.getRecruiterId());
		app.setJobId(dto.getJobId());
		app.setApplicationDate(LocalDateTime.now());
		app.setStatus(dto.getStatus());
		return appRepo.save(app);
	}
	
	public List<Application>getByJobseekerID(String jobSeekerID){
		return appRepo.findByJobseekerId(jobSeekerID);
	}
	
	public List<Application>getByRecruiterId(String recruiterId){
		return appRepo.findByRecruiterId(recruiterId);
	}
	
	public List<Application>getByJobId(Long jobId){
		return appRepo.findByJobId(jobId);
	}
	
	public Application updateApplicationStatus(Long id,  ApplicationStatus status) {
//		Application app = new Application();
		Application app = appRepo.findById(id).orElseThrow(() -> new RuntimeException("Application not found"));
		app.setStatus(status);
		return appRepo.save(app);	
	}
}

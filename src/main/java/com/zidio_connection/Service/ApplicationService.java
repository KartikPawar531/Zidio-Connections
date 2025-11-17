package com.zidio_connection.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zidio_connection.DTO.ApplicationDTO;
import com.zidio_connection.Entity.Application;
import com.zidio_connection.Enum.ApplicationStatus;
import com.zidio_connection.Repository.ApplicationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ApplicationService {

	@Autowired
	private ApplicationRepository appRepo;
	
	public Application apply(String jobssekerId,ApplicationDTO dto) {
		Application app = new Application();
		app.setJobseekerId(jobssekerId);
		app.setRecruiterId(dto.getRecruiterId());
		app.setJobId(dto.getJobId());
		app.setApllicationDate(LocalDateTime.now());
		app.setStatus(dto.getStatus());
		return appRepo.save(app);
	}
	
	public List<Application>getByJobseekerID(String jobseekerID){
		return appRepo.findByJobseekerId(jobseekerID);
	}
	
	public List<Application>getByRecruiterId(String recuiterId){
		return appRepo.findByRecruiterId(recuiterId);
	}
	
	public List<Application>getByJobId(Long jobId){
		return appRepo.findByJobId(jobId);
	}
	
	public Application updateApplicationStatus(Long id,  ApplicationStatus status) {
		Application app = new Application();
		appRepo.findById(id).orElseThrow(() -> new RuntimeException("Application not found"));
		app.setStatus(status);
		return appRepo.save(app);	
	}
}

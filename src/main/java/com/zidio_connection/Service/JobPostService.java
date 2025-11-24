package com.zidio_connection.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zidio_connection.DTO.JobPostDTO;
import com.zidio_connection.Entity.JobPost;
import com.zidio_connection.Enum.JobType;
import com.zidio_connection.Repository.JobPostRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JobPostService {

	@Autowired
	private JobPostRepository jobPostRepo;

	public JobPost createJob(String recruiterId, JobPostDTO dto) {
		JobPost job = new JobPost();
		job.setRecruiterId(recruiterId);
		job.setJobTitle(dto.getJobTitle());
		job.setJobDescription(dto.getJobDescription());
		job.setCompanyName(dto.getCompanyName());
		job.setJobLocation(dto.getJobLocation());
		job.setRemote(dto.getRemote());
		job.setPostedDate(dto.getPostedDate());
		job.setDeadlineDate(dto.getDeadlineDate());
		return jobPostRepo.save(job);
	}

	public List<JobPost> getAllJob() {
		return jobPostRepo.findAll();
	}

	public List<JobPost> getJobByRecruiter(String recruiterId) {
		return jobPostRepo.findByRecruiterId(recruiterId);
	}

	public List<JobPost> getJobByJobType(JobType jobType) {
		return jobPostRepo.findByJobType(jobType);
	}

	public List<JobPost> getJobByJobTitle(String jobTitle) {
		return jobPostRepo.findByJobTitle(jobTitle);
	}

	public List<JobPost> searchJobByJobLocation(String jobLocation) {
		return jobPostRepo.findByJobLocation(jobLocation);
	}

	public List<JobPost> searchJobByCompanyName(String companyName) {
		return jobPostRepo.findByCompanyName(companyName);
	}

	public JobPost searchJobByJobId(Long id) {
		return jobPostRepo.findById(id).orElseThrow(() -> new RuntimeException("Job Not Found"));
	}
}
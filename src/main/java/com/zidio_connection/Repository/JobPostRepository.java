package com.zidio_connection.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.zidio_connection.Entity.JobPost;
import com.zidio_connection.Enum.JobType;

@Repository
public interface JobPostRepository extends JpaRepository<JobPost, Long> {

	List<JobPost> findByRecruiterId(String recruiterId);
	List<JobPost> findByJobType(JobType jobType);
	List<JobPost> findByJobTitle(String jobTitle);
	List<JobPost> findByJobLocation(String jobLocation);
	List<JobPost> findByCompanyName(String companyName);
}

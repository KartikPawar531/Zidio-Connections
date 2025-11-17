package com.zidio_connection.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zidio_connection.Entity.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {

	List<Application>findByJobseekerId(String jobseekerId);
	List<Application>findByRecruiterId(String recruiterId);
	List<Application>findByJobId(Long jobId);
}

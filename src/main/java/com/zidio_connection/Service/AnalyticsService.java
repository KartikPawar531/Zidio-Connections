package com.zidio_connection.Service;

import org.springframework.stereotype.Service;

import com.zidio_connection.DTO.ApplicationStatusDTO;
import com.zidio_connection.DTO.CourseStatusDTO;
import com.zidio_connection.DTO.JobStatusDTO;
import com.zidio_connection.DTO.SubscriptionStatusDTO;
import com.zidio_connection.DTO.UserStatusDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnalyticsService {

	public UserStatusDTO fetchUserStatus() {

		UserStatusDTO userStatus = new UserStatusDTO();
		userStatus.setTotalJobseekers(1000);
		userStatus.setTotalRecruiters(500);
		userStatus.setBlockedUsers(50);

		return userStatus;
	}

	public JobStatusDTO fetchJobStatus() {

		JobStatusDTO jobStatus = new JobStatusDTO();
		jobStatus.setTotalJobs(10000);
		jobStatus.setFullTimes(5000);
		jobStatus.setInternships(1000);
		jobStatus.setContractual(500);
		jobStatus.setPartTime(500);
		jobStatus.setFreelance(500);

		return jobStatus;
	}

	public ApplicationStatusDTO fetchApplicationStatus() {

		ApplicationStatusDTO applications = new ApplicationStatusDTO();
		applications.setTotalJobApplications(1000);
		applications.setShortlisted(750);
		applications.setRejected(100);
		applications.setPendingApplications(100);
		applications.setInterviewProcess(100);

		return applications;
	}

	public CourseStatusDTO fetchCourseStatus() {

		CourseStatusDTO dto = new CourseStatusDTO();
		dto.setTotalCourses(50);
		dto.setActiveCourses(30);
		dto.setIsActiveCourses(20);
		return dto;
	}
	
   public SubscriptionStatusDTO fetchSubsritionStatus() {
	   
	   SubscriptionStatusDTO sub = new SubscriptionStatusDTO();
	   sub.setTotalPayments(250);
		sub.setPaidUsers(200);
		sub.setActivePlans(180);
		sub.setTotalRevenue(10000);
		sub.setAverageRevenuePerUser(sub.getTotalRevenue()/sub.getPaidUsers());
		
		return sub;
	}  
}

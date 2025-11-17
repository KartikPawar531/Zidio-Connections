package com.zidio_connection.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zidio_connection.Entity.Jobseeker;

@Repository
public interface JobseekerRepository extends JpaRepository<Jobseeker, Long> {
	
	Optional<Jobseeker> findByuserId(Long userId);
}

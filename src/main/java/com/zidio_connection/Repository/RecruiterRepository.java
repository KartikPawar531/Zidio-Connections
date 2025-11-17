package com.zidio_connection.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zidio_connection.Entity.Recruiter;

@Repository
public interface RecruiterRepository extends JpaRepository<Recruiter, Long> {

	Optional<Recruiter> findByuserId(Long userId);
	Optional<Recruiter> findByCompanyEmail(String compEmail);
}

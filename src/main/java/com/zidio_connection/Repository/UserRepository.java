package com.zidio_connection.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zidio_connection.DTO.LoginRequestDTO;
import com.zidio_connection.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User>findByUserEmail(String userEmail);
	Optional<User>findByUserName(String userName);
}

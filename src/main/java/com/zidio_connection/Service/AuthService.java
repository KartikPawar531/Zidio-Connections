package com.zidio_connection.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;

import com.zidio_connection.DTO.UserDTO;
import com.zidio_connection.Entity.User;
import com.zidio_connection.Repository.UserRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Service
//@RequiredArgsConstructor
public class AuthService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationManager authManager;
	
	public User register(UserDTO dto) {
		User user = new User();
		user.setUserName(dto.userName);
		user.setUserEmail(dto.userEmail);
		user.setPassword(passwordEncoder.encode(dto.password));
		user.setRole(dto.role);
	  return userRepo.save(user);
	}

	public User login(String userName, String password) {
		User user = userRepo.findByUserName(userName).orElseThrow(()-> new RuntimeException("Invalid username"));
		if(!passwordEncoder.matches(password, user.getPassword())) {
			throw new RuntimeException("invalid creditial");
		}
		return user;
	}
	
	public void logout(HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null) {
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	}
	
//	public void logout(HttpServletRequest request, HttpServletResponse response) {
//	    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//	    if (authentication != null) {
//	        SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
//	        logoutHandler.logout(request, response, authentication);
//	    }
//	}
}
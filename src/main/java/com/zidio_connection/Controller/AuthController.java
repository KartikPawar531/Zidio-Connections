package com.zidio_connection.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zidio_connection.DTO.UserDTO;
import com.zidio_connection.Entity.User;
import com.zidio_connection.Security.JWTUtil;
import com.zidio_connection.Service.AuthService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
	
	private final AuthenticationManager authenticationManager;
    private final JWTUtil jwtUtil;

	@Autowired
	private AuthService authService;
	
	@PostMapping("/register")
	public ResponseEntity<User>register(@RequestBody UserDTO dto){
		return ResponseEntity.ok(authService.register(dto)); 
	}
	
	 @PostMapping("/login")
	    public String login(@RequestParam String username, @RequestParam String password) {
	        try {
	            Authentication authentication = authenticationManager.authenticate(
	                    new UsernamePasswordAuthenticationToken(username, password)
	            );
	            if (authentication.isAuthenticated()) {
	                return "Login successful!";
	            } else {
	                return "Login failed!";
	            }
	        } catch (AuthenticationException e) {
	            return "Login failed: " + e.getMessage();
	        }
	    }
	
	@PostMapping("/logout")
	public ResponseEntity<String> logout(HttpServletRequest request, HttpServletResponse response) {
	    authService.logout(request, response);
	    return ResponseEntity.ok("Logout successful");
	}
}

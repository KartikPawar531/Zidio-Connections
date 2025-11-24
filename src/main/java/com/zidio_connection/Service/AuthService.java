package com.zidio_connection.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonToken;
import com.zidio_connection.DTO.AuthResponseDTO;
import com.zidio_connection.DTO.EmailRequestDTO;
import com.zidio_connection.DTO.ForgotPasswordRequestDTO;
import com.zidio_connection.DTO.LoginRequestDTO;
import com.zidio_connection.DTO.ResetPasswordRequestDTO;
import com.zidio_connection.DTO.UserDTO;
import com.zidio_connection.Entity.User;
import com.zidio_connection.Entity.BlockListedToken;
import com.zidio_connection.Repository.BlockListedTokenRepository;
import com.zidio_connection.Repository.UserRepository;
import com.zidio_connection.Security.JWTUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	private EmailService emailService;

	@Autowired
	private JWTUtil jwtToken;

	@Autowired
	private BlockListedTokenRepository blockListedRepo;

	public User register(UserDTO dto) {
		User user = new User();
		user.setUserName(dto.userName);
		user.setUserEmail(dto.userEmail);
		user.setPassword(passwordEncoder.encode(dto.password));
		user.setRole(dto.role);
		return userRepo.save(user);
	}

	public User login(String userName, String password) {
		User user = userRepo.findByUserName(userName).orElseThrow(() -> new RuntimeException("Invalid username"));
		if (!passwordEncoder.matches(password, user.getPassword())) {
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

	public AuthResponseDTO login(LoginRequestDTO dto) {
		Authentication authentication = authManager
				.authenticate(new UsernamePasswordAuthenticationToken(dto.getUserEmail(), dto.getPassword()));

//		UserDetails user = (UserDetails)authentication.getPrincipal();
//		String token = jwtToken.generateToken(user.getUsername(), user.getPassword());
//		return new AuthResponseDTO(token,"Token got creted");
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String token = jwtToken.generateToken(authentication);
		return new AuthResponseDTO(token, "Token created successfully");
	}

	public String forgetPassword(ForgotPasswordRequestDTO request) {
		Optional<User> userOpt = userRepo.findByUserEmail(request.getUserEmail());
		if (userOpt.isPresent())
			throw new RuntimeException("User not found");
		User user = userOpt.get();
		String token = UUID.randomUUID().toString();
		user.setResetToken(token);
		user.setResetTokenExpire(LocalDateTime.now().plusMinutes(10));
		userRepo.save(user);

		String resetPasswordLink = "https://resetpasswordLinkSet=Password?token=" + token;
		EmailRequestDTO dto = new EmailRequestDTO();
		dto.setTo(user.getUserEmail());
		dto.setSubject("Password Reset Request");
		dto.setBody("click the link below to reset your password:\n" + resetPasswordLink);

		emailService.sendEmail(dto);
		return "Reset Password link has been sent to your Register Email" + user.getUserEmail();
	}

	public String resetPassword(ResetPasswordRequestDTO dto) {
		User user = userRepo.findByResetToken(dto.getToken())
				.orElseThrow(() -> new RuntimeException("Invalid or Expire Token"));
		if (user.getResetTokenExpire() == null || user.getResetTokenExpire().isBefore(LocalDateTime.now())) {
			throw new RuntimeException("Reset Token Expired");
		}
		user.setPassword(passwordEncoder.encode(dto.getNewPassword()));
		user.setResetToken(null);
		user.setResetTokenExpire(null);
		userRepo.save(user);

		return "Password Reset Successfully";
	}

	public String logout(String token) {
		if (token == null || token.isEmpty()) {
			throw new RuntimeException("Invalid Token");
		}

		if (blockListedRepo.existsByToken(token)) {
			return "Token already logged Out";
		}
		BlockListedToken blocklistedToken = new BlockListedToken(token, LocalDateTime.now());
		blockListedRepo.save(blocklistedToken);
		return "Logged Out successFully";
	}
}
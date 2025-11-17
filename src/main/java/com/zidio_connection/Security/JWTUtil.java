package com.zidio_connection.Security;

import java.util.*;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtil {

	private final String jwtSecret = "secretKey";
	private final long jwtExpiration = 86400000;

	public String generateToken(Authentication authentication) {

		String userName = authentication.getName();
		Date now = new Date();
		Date expiry = new Date(now.getTime() + jwtExpiration);

		return Jwts.builder().setSubject(userName).setIssuedAt(now).setExpiration(expiry)
				.signWith(SignatureAlgorithm.HS256, jwtSecret).compact();
	}

	public String getUserNameFromToken(String token) {
		return Jwts.parserBuilder().setSigningKey(jwtSecret.getBytes()).build().parseClaimsJws(token).getBody()
				.getSubject();
	}

	public boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
			return true;
		} catch (JwtException | IllegalArgumentException e) {
			return false;
		}
	}
}

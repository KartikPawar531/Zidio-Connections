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
	private final long jwtExpiration = 86400000L;

//	Generate Token
	public String generateToken(Authentication authentication) {
		String userName = authentication.getName();
		Date now = new Date();
		Date expiry = new Date(now.getTime() + jwtExpiration);

		return Jwts.builder().setSubject(userName).setIssuedAt(now).setExpiration(expiry)
				.signWith(SignatureAlgorithm.ES512, jwtSecret).compact();
	}

	public String getUserNameFromToken(String token) {
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
	}

//	Validate Token
	public boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
			return true;
		} catch (JwtException | IllegalArgumentException e) {
			return false;
		}
	}
	
//	 Check token expiration
	public boolean isTokenExpired(String token) {
        return getExpirationDateFromToken(token).before(new Date());
    }
	
//   Get expiration date from token
	 private Date getExpirationDateFromToken(String token) {
	        return Jwts.parser()
	                .setSigningKey(jwtSecret)
	                .parseClaimsJws(token)
	                .getBody()
	                .getExpiration();
	    }
}

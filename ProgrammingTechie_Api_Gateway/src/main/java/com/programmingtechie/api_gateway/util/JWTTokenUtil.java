package com.programmingtechie.api_gateway.util;

import java.security.Key;
import java.util.Base64.Decoder;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;


@Component
public class JWTTokenUtil {
	
	@Value("${jwt.secret}")
	String secret;

	public void validateToken(final String token) {
		Claims claims = extractClaims(token);
		
		if(claims.getExpiration().before(new Date())) {
			throw new RuntimeException("Token has expired at "+ claims.getExpiration());
		}
		
	}

	private Claims extractClaims(String token) {
		return Jwts.parserBuilder()
				   .setSigningKey(signKey())
				   .build()
				   .parseClaimsJws(token)
				   .getBody();
	}

	private Key signKey() {
		byte[] keyBytes = Decoders.BASE64.decode(secret);
		return Keys.hmacShaKeyFor(keyBytes);
	}

}

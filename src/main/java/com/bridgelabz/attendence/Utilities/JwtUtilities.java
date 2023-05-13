package com.bridgelabz.attendence.Utilities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bridgelabz.attendence.dto.LoginDTO;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtilities implements Serializable {

	@Autowired
	LoginDTO logindto;
	String secretekey = "Rukmini";

	public String generateToken(LoginDTO logindto) {
		Map<String, Object> claims = new HashMap<>();
		claims.put("username", logindto.getUsername());
		claims.put("password", logindto.getPassword());
		return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS256, secretekey).compact();
	}

	public String getusernameFromToken(String token) {
		Map<String, Object> claims = Jwts.parser().setSigningKey(secretekey).parseClaimsJws(token).getBody();
		System.out.println(claims.get("username"));
		return claims.get("username").toString();
	}
	

}

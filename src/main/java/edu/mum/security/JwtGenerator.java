package edu.mum.security;

import edu.mum.model.JwtUser;
import edu.mum.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

@Component
public class JwtGenerator {


    //public String generate(JwtUser jwtUser) {
	public String generate(User jwtUser) {

        Claims claims = Jwts.claims()
                //.setSubject(jwtUser.getUserName());
        		.setSubject(jwtUser.getEmail());
        claims.put("userId", String.valueOf(jwtUser.getId()));
        //claims.put("role", jwtUser.getRole());


        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, "youtube")
                .compact();
    }
}

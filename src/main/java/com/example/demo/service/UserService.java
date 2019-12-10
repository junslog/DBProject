package com.example.demo.service;

import java.io.UnsupportedEncodingException;

import javax.crypto.SecretKey;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.UserMyBatisRepository;
import com.example.demo.dto.UserDto;
import com.example.demo.exception.UnauthorizedException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;



@Service
public class UserService {
	@Autowired
    private UserMyBatisRepository repository;

    @Value("#{T(io.jsonwebtoken.security.Keys).hmacShaKeyFor('${aroomda.token-secret}'.getBytes())}")
    private SecretKey jwtSecret;

    public UserDto getUser(String id) {
        return repository.findUser(id);
    }

    @Transactional
    public UserDto createUserWithAccount(UserDto form) {
    	UserDto user = new UserDto();
        
        repository.createUser(user);
        //repository.createAccount(user.getId(), form.getLoginId(), form.getPassword());

        return getUser(user.getId());
    }

    public UserDto getAccountUser(String loginId, String password) {
        //return repository.getAccountUser(loginId, hashPassword(password));
    	return repository.getAccountUser(loginId, password);
    }

    public UserDto getUserByToken(String token) {
        String[] strip = token.split("Bearer ");
        if(strip.length < 2)
            throw new UnauthorizedException();

        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(jwtSecret)
                    .parseClaimsJws(strip[1])
                    .getBody();

            String userId = claims.get("user_id", String.class);
            return getUser(userId);
        }
        catch (JwtException e) {
            throw new UnauthorizedException();
        }
    }

    public String createLoginToken(String userId) {
        return Jwts.builder()
                .claim("user_id", userId)
                .signWith(jwtSecret)
                .compact();
    }

    /*private byte[] hashPassword(String password) {
        try {
            return new SHA3.Digest256().digest(password.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return null;
    }*/
	
	
	
}

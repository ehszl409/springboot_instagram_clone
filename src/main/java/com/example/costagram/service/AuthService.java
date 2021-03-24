package com.example.costagram.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.costagram.domain.user.User;
import com.example.costagram.domain.user.UserRepo;
import com.example.costagram.web.dto.auth.UserJoinReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AuthService {
	
	private final UserRepo userRepo;
	private final BCryptPasswordEncoder encorded;
	
	@Transactional
	public void 회원가입(User user) {
		String encPass = encorded.encode(user.getPassword());
		
		user.setPassword(encPass);
		user.setRole("USER");
		userRepo.save(user);
	}
}

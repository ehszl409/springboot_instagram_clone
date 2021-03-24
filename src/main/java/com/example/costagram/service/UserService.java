package com.example.costagram.service;

import org.springframework.stereotype.Service;

import com.example.costagram.domain.user.User;
import com.example.costagram.domain.user.UserRepo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
	
	private final UserRepo userRepo;
	
	public void 회원프로필(int userId) throws Exception {
		User userEntity = userRepo.findById(userId).orElseThrow(()->{
			return new IllegalAccessException();
		});
	}

}

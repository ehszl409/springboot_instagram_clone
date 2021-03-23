package com.example.costagram.web.auth.dto;

import com.example.costagram.domain.user.User;

import lombok.Data;

// 4건만 받기위해 DTO를 만들었다.
// 목적 : OAuth관리하기 쉽게할려고 또는 요즘 트랜드가 회원가입시 필요한 정보만 요구해서 UX를 높인다.
// 이 후 추가적인 정보는 회원정보 수정을 통해서 사용자가 원하면 입력하도록 유도한다.
@Data
public class UserJoinReqDto {
	private String username;
	private String password;
	private String email;
	private String name;
	
	public User toEntity() {
		User user = User.builder()
				.username(username)
				.password(password)
				.email(email)
				.name(name)
				.build();
		return user;
			
	}
}

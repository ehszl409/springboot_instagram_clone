package com.example.costagram.config.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.costagram.domain.user.User;
import com.example.costagram.domain.user.UserRepo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PrincipalDetailsService implements UserDetailsService {
	
	private final UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("loadUserByUsername에 접근..");
		
		System.out.println("username : " + username);
		User userEntity = userRepo.findByUsername(username);
		System.out.println("userEntity : " + userEntity);
		if(userEntity == null) {
			throw new RuntimeException();
 		} else {
 			// 시큐리티컨택스트홀더 => 어탠티케이션 객체에 담김
 			return new PrincipalDetails(userEntity);
 		}
		
	}
}

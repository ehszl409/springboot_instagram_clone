package com.example.costagram.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.costagram.domain.follow.Follow;
import com.example.costagram.domain.follow.FollowRepo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FollowService {

	private final FollowRepo followRepo;
	
	@Transactional
	public int 팔로우(int fromUserId, int toUserId) {
		// native쿼리를 사용해서 fromUserId와 toUserId를 찾는다.
		return followRepo.mFollwing(fromUserId, toUserId);
	}
	
	@Transactional
	public int 언팔로우(int fromUserId, int toUserId) {
		// native쿼리를 사용해서 fromUserId와 toUserId를 찾는다.
		return followRepo.mUnFollwing(fromUserId, toUserId);
	}
	
	
}

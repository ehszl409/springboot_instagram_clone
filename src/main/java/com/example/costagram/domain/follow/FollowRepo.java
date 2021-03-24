package com.example.costagram.domain.follow;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface FollowRepo extends JpaRepository<Follow, Integer>{

	// insert, delete, update @Modifying을 붙여야 작동을 한다.
	
	@Modifying
	@Query(value = "INSERT INTO follow(fromUserId, toUserId, createDate) VALUES(:fromUserId, :toUserId, now())"
			, nativeQuery = true)
	int mFollwing(int fromUserId, int toUserId); // prepareStatement updateQuery() => -1,0,1
	
	@Modifying
	@Query(value = "DELETE FROM follow WHERE fromUserId = :fromUserId AND toUserId = :toUserId"
			, nativeQuery = true)
	int mUnFollwing(int fromUserId, int toUserId); // prepareStatement updateQuery() => -1,0,1
}

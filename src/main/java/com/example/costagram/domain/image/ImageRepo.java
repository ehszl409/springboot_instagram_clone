package com.example.costagram.domain.image;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ImageRepo extends JpaRepository<Image, Integer>{
	
	
	
	@Query(value = "SELECT * FROM image WHERE userId IN (SELECT toUserId FROM follow WHERE fromUserId = :principalId) order by id DESC",
			nativeQuery = true)
	List<Image> mFeed (int principalId);

}

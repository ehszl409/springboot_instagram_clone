package com.example.costagram.domain.follow;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import com.example.costagram.domain.comment.Comment;
import com.example.costagram.domain.image.Image;
import com.example.costagram.domain.likes.Likes;
import com.example.costagram.domain.tag.Tag;
import com.example.costagram.domain.user.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Follow {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 

	@JoinColumn(name = "fromUserId")
	@ManyToOne(fetch = FetchType.EAGER)
	private User fromUser; // 누가(팔로우하는 사람)
	
	@JoinColumn(name = "toUserId")
	@ManyToOne(fetch = FetchType.EAGER)
	private User toUser; // 누구를(팔로우 당하는 쪽)
	
	@CreationTimestamp
	private Timestamp createDate;
}

package com.example.costagram.domain.image;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import com.example.costagram.domain.likes.Likes;
import com.example.costagram.domain.tag.Tag;
import com.example.costagram.domain.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Image {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
	private String caption; // 코멘트 적는 곳.
	private String postImageUrl;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "usreId")
	private User user;
	
	@OneToMany(mappedBy = "image", fetch = FetchType.LAZY)
	private List<Tag> tags;
	
	@OneToMany(mappedBy = "image")
	private List<Likes> likes;
	
	@CreationTimestamp
	private Timestamp createDate;
	

}

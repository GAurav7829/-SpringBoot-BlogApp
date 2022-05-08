package com.blog.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "posts")
@Getter
@Setter
@NoArgsConstructor
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer postId;
	@Column(nullable = false, length = 100)
	private String title;
	@Column(length = 1000, nullable = false)
	private String content;
	private String imageName;
	@CreationTimestamp
	private Date createdDate;
	@UpdateTimestamp
	private Date updatedDate;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	@ManyToOne
	private User user;
	
	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
	private List<Comment> comments = new ArrayList<Comment>();

	public Post(String title, String content, String imageName) {
		super();
		this.title = title;
		this.content = content;
		this.imageName = imageName;
	}
	
	
	
	
}

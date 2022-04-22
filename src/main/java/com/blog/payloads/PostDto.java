package com.blog.payloads;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PostDto {
	private Integer postId;
	@NotEmpty
	@Size(min = 4, max = 100)
	private String title;
	@Size(max = 10000)
	private String content;
	private String imageName;
	
	private Date createdDate;
	private Date updatedDate;
	
	private CategoryDto category;
	
	private UserDto user;
	
	
}

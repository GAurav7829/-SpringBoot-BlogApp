package com.blog.payloads;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
	private Integer id;
	@NotEmpty
	@Size(min = 3, max = 30, message = "Category Title must be in Between 3 to 30 characters")
	private String categoryTitle;
	private String categoryDescription;
}

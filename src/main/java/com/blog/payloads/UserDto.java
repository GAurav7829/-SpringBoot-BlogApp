package com.blog.payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	private Integer id;
	@NotEmpty
	@Size(min = 4, message = "Name must be minimum 4 characters")
	private String name;
	@Email(message = "Email not valid")
	private String email;
	@NotEmpty
	@Size(min = 3, max = 10, message = "Password must be minimum of 3 characters and max of 10 characters")
	private String password;
	@NotEmpty
	private String about;
}

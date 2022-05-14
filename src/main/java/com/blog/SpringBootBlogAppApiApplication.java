package com.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.blog.entities.User;
import com.blog.repositories.UserRepository;

@SpringBootApplication
public class SpringBootBlogAppApiApplication implements CommandLineRunner {

//	@Autowired
//	private PasswordEncoder passwordEncoder;
	
//	@Autowired
//	private UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootBlogAppApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		System.out.println(this.passwordEncoder.encode("123"));
//		User user = new User();
//		user.setEmail("grv1@gmail.com");
//		user.setPassword("123");
//		user.setName("grv");
//		userRepository.save(user);
		
		
	}

}

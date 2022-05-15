package com.blog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.blog.config.AppConstants;
import com.blog.entities.Role;
import com.blog.repositories.RoleRepository;

@SpringBootApplication
public class SpringBootBlogAppApiApplication implements CommandLineRunner {
	@Autowired
	private RoleRepository roleRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootBlogAppApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {		
		try {
		Role role1 = new Role();
		role1.setId(AppConstants.ROLE_USER);
		role1.setName("ROLE_USER");
		
		Role role2 = new Role();
		role2.setId(AppConstants.ROLE_ADMIN);
		role2.setName("ROLE_ADMIN");
		
		List<Role> roles = List.of(role1, role2);
		this.roleRepository.saveAll(roles);
		
		}catch(Exception ex) {
			System.out.println("Exception in creating Roles: "+ex.getMessage());
		}
	}

}

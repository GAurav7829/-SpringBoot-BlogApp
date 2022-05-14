package com.blog.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByEmail(String email);
}

/*
 * Spring will create class object for this interface at runtime
 * these are called proxy classes
 * when we autowire, the object of proxy class will create
 * 
 * ClassName: jdk.proxy2.$Proxy99
 * PackageName: jdk.proxy2
 * 
 * check in test class for this - SpringBootBlogAppApiApplicationTests
 * 
 */

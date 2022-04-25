package com.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.blog.entities.Category;
import com.blog.entities.Post;
import com.blog.entities.User;

public interface PostRepository extends JpaRepository<Post, Integer> {
	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);
//	InvalidDataAccessApiUsageException occur when search second time, problem in hibernate version
//	List<Post> findByTitleContaining(String title);
//	Alternative
	@Query("Select p from Post p where p.title like %:keyword%")
	List<Post> searchByTitle(@Param("keyword") String title);
}

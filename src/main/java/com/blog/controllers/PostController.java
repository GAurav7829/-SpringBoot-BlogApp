package com.blog.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blog.payloads.ApiResponse;
import com.blog.payloads.PostDto;
import com.blog.payloads.PostResponse;
import com.blog.services.PostService;

@RestController
@RequestMapping("/api")
public class PostController {
	@Autowired
	private PostService postService;
	
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto, 
			@PathVariable Integer userId, @PathVariable Integer categoryId){
		PostDto createdPost = this.postService.createPost(postDto, userId, categoryId);
		return new ResponseEntity<PostDto>(createdPost, HttpStatus.CREATED);
	}
	
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getPostsByUser(@PathVariable Integer userId){
		List<PostDto> postDtos = this.postService.getPostsByUser(userId);
		return new ResponseEntity<List<PostDto>>(postDtos, HttpStatus.OK);
	}
	
	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable Integer categoryId){
		List<PostDto> postDtos = this.postService.getPostsByCategory(categoryId);
		return new ResponseEntity<List<PostDto>>(postDtos, HttpStatus.OK);
	}
	
	@GetMapping("/posts")
	public ResponseEntity<PostResponse> getAllPosts(
			@RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize,
			@RequestParam(value = "sortBy", defaultValue = "postId", required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = "DESC", required = false) String sortDir
			){
		PostResponse postResponse = this.postService.getAllPost(pageNumber, pageSize, sortBy, sortDir);
		return new ResponseEntity<PostResponse>(postResponse, HttpStatus.OK);
	}
	
	@GetMapping("/posts/{postId}")
	public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId){
		PostDto post = this.postService.getPostById(postId);
		return new ResponseEntity<PostDto>(post, HttpStatus.OK);
	}
	
	@DeleteMapping("/posts/{postId}")
	public ResponseEntity<?> deletePost(@PathVariable Integer postId){
		this.postService.deletePost(postId);
		return new ResponseEntity<>(new ApiResponse("Post Deleted Successfully", true), HttpStatus.OK);
	}
	
	@PutMapping("/posts/{postId}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto,@PathVariable Integer postId){
		PostDto post = this.postService.updatePost(postDto, postId);
		return new ResponseEntity<PostDto>(post, HttpStatus.OK);
	}
	
	@GetMapping("/posts/search/{keyword}")
	public ResponseEntity<List<PostDto>> searchPostByTitle(@PathVariable String keyword){
		List<PostDto> searchedPosts = this.postService.searchPost(keyword);
		return new ResponseEntity<List<PostDto>>(searchedPosts, HttpStatus.OK);
	}
	
}

package com.blog.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.entities.Comment;
import com.blog.entities.Post;
import com.blog.payloads.CommentDto;
import com.blog.repositories.CommentRepository;
import com.blog.repositories.PostRepository;
import com.blog.services.CommentService;
import com.blog.utils.CommonMethodsUtils;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private CommentRepository commentRepository;
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
		Post post = this.postRepository.findById(postId).orElseThrow(CommonMethodsUtils.resourceNotFound("post", "postId", postId));
		Comment comment = this.modelMapper.map(commentDto, Comment.class);
		comment.setPost(post);
		Comment savedComment = this.commentRepository.save(comment);
		return this.modelMapper.map(savedComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {
		Comment comment = this.commentRepository.findById(commentId).orElseThrow(CommonMethodsUtils.resourceNotFound("comment", "commentId", commentId));
		this.commentRepository.delete(comment);
	}

}

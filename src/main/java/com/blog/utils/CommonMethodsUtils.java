package com.blog.utils;

import java.util.function.Supplier;

import com.blog.exceptions.ResourceNotFoundException;

public class CommonMethodsUtils {
	
	public static final Supplier<? extends ResourceNotFoundException> resourceNotFound(String resourceName, String fieldName, Integer userId) {
		return ()->new ResourceNotFoundException(resourceName, fieldName, userId);
	}
	
}

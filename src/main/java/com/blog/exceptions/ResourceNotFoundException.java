package com.blog.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1368464690441708582L;
	
	String resourceName;
	String fieldName;
	String fieldValue;
	public ResourceNotFoundException(String resourceName, String fieldName, String field) {
		super(String.format("%s not found with %s : %s", resourceName, fieldName, field));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = field;
	}
	
	
}

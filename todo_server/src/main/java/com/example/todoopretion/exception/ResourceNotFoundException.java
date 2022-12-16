package com.example.todoopretion.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResourceNotFoundException  extends RuntimeException{
	String resourceName;
	String filedName;
	Integer fledValue;
	public ResourceNotFoundException(String resourceName, String filedName, Integer fledValue) {
		super(String.format("%s not found with %s :%s", resourceName,filedName,fledValue));
		this.resourceName = resourceName;
		this.filedName = filedName;
		this.fledValue = fledValue;
	}
	
	
	

}

package com.springboot.exception;

import org.springframework.beans.factory.parsing.Problem;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionhandler {
	
	@ExceptionHandler({UserNotFoundException.class,Exception.class})
	//Prblem Detail Introduced in Spring Boot 2.3.0
	public ProblemDetail handleUserExceptoin(Exception exception) {
		return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, exception.getMessage());
	}
	

}

package com.telusko.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.telusko.demo.Karthick;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CustomException.class)
	@Karthick
	public ProblemDetail handleCustomException(CustomException exception) {
		//return new ExceptionMsgDTO("Failed", exception.getMessage(), HttpStatus.BAD_GATEWAY);
		return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_GATEWAY, exception.getMessage());
	}
	
	
}

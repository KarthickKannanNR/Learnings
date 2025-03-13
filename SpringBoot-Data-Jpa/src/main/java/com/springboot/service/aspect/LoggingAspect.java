package com.springboot.service.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

	@Before("execution(* com.springboot.service.UserService.findUserById(int))")
	public void findUserByIdBeforeAspect() {
		System.out.println("Find user by Id called");
	}
	
	@After("execution(* com.springboot.service.UserService.findUserById(int))")
	public void findUserByIdAfterAspect() {
		System.out.println("Find user by Id Ended");
	}
	
	@AfterThrowing("execution(* com.springboot.service.UserService.findUserById(..))")
	public void userNotFoundAspect() {
		System.out.println("Message from logging aspect - User Not Found");
	}
	
	@AfterReturning("execution(* com.springboot.service.UserService.findUserById(..))")
	public void userFound() {
		System.out.println("User found and returned successfully");
	}
	
	@Around("pointCut()")
	public void aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("Get all user method called");
		
		Object obj = joinPoint.proceed();
		
		System.out.println("Get all user method completed");
	}
	
	@Pointcut("execution(* com.springboot.service.*.*(..))")
	public void pointCut() {}
}

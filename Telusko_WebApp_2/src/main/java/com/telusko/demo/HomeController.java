package com.telusko.demo;

import java.awt.print.Book;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.exception.CustomException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	private DummyConfig dummyConfig;
	
	@Autowired
	Environment envi;
	
	
	
//	public HomeController (DummyConfig dummyConfig) {
//		this.dummyConfig = dummyConfig;
//	}
	
	public void setDependency(DummyConfig dummyConfig) {
		this.dummyConfig = dummyConfig;
	}
	
	@RequestMapping("home")
	public ModelAndView home(User user,ModelAndView mv) {
		mv.setViewName("home");
		mv.addObject("user",user);
		return mv;
	}
	
	@PostMapping(path = "addBook")
	@ResponseBody
	public ResponseEntity<?> print(@RequestBody Books books) {
		return ResponseEntity.ok("Book name "+ books.getBookName() + "author "+books.getAuthors().get(1).getAuthorName());
		//return ResponseEntity.ok(books);
	}
	
	//content negotiation
	@GetMapping(path = "bookList",produces = {"application/json","application/xml",},consumes = {})
	@ResponseBody
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public List<Books> getBooks(){
		
		return Arrays.asList(new Books(1,"java",Arrays.asList(new Authors("kk"),new Authors("ak"))));
	}
	
	@GetMapping("exceptionCheck")
	public void globalExceptionHandlerCheck() throws CustomException {
		throw new CustomException("Global Exception chk");
	}
	

	

	
}

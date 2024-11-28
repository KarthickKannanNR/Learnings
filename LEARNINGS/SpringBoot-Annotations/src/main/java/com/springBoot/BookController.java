package com.springBoot;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/bookController")
public class BookController {
	
	@RequestMapping("/getBook")
	@ResponseBody
	public String getBook() {
		return "Book Found";
	}

	@GetMapping(value = {"/getBooks","/getBookList"},
			produces = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE},
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public Books getBooks() {
		Books books = new Books("java", 1, "karthick");
		return books;
	}
	
	
	@PostMapping(value = "/getBookObject")
	//@ResponseStatus(value = HttpStatus.IM_USED)
	public ResponseEntity<Books> postMethodName(@RequestBody Books book) {
		System.out.println(book.getAuthor());
		System.out.println(book.getBookId());
		System.out.println(book.getBookName());
		return new ResponseEntity<>(book,HttpStatus.IM_USED);
	}
	
	@DeleteMapping("/deleteMapping/{id}")
	public ResponseEntity<String> deleteMapping(@PathVariable int id){
		return ResponseEntity.ok("Delete Mapping");
	}
	
	//@RequestParam
	
	@PostMapping("/requestParam")
	public String requestParam(@RequestParam(name = "firstName") String firstName, @RequestParam (name = "lastName") String lastName) {
		return "firstName = "+firstName+" LastName = "+lastName;
	}
	
	
}



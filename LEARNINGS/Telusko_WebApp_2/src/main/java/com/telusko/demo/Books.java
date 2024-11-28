package com.telusko.demo;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class Books {

	public Books(int bookId, String bookName, List<Authors> authors) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.authors = authors;
	}
	@NotBlank
	int bookId;
	@NotBlank
	String bookName;
	@NotNull
	List<Authors> authors;
	public List<Authors> getAuthors() {
		return authors;
	}
	public void setAuthors(List<Authors> authors) {
		this.authors = authors;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	
}

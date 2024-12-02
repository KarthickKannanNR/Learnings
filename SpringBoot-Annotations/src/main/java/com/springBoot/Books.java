package com.springBoot;


public class Books {

	private String bookName;
	private int bookId;
	private String author;
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public Books(String name,int bookId,String author) {
		this.bookName = name;
		this.bookId = bookId;
		this.author = author;
	}
	 
}

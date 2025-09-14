package com.test.interview.lamda.example;

import java.util.ArrayList;
import java.util.List;

public class BookDAO {

	
	public List<Book> getBooks(){
		
		List<Book> books = new ArrayList<Book>();
		
		books.add(new Book(101,"Spring",400));
		books.add(new Book(102,"java",300));
		books.add(new Book(103,"Microservices",500));
		
		return books;
		
		
		
	}
}

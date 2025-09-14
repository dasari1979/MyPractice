package com.test.interview.lamda.example;

import java.util.Collections;
import java.util.List;

public class BookService {

	public List<Book> getBooksinSort() {

		// (o1, o2) -> o2.getName().compareTo(o1.getName();

		List<Book> books = new BookDAO().getBooks();
		Collections.sort(books, (o1, o2) -> o2.getName().compareTo(o1.getName()));
		return books;
	}

	public static void main(String s[]) {

		System.out.println(new BookService().getBooksinSort());
	}
}

/*
 * class MyComparator implements Comparator<Book>{
 * 
 * @Override public int compare(Book o1, Book o2) { return
 * o2.getName().compareTo(o1.getName()); }
 * 
 * 
 * }
 */
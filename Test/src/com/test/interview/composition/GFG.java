package com.test.interview.composition;

import java.util.ArrayList;
import java.util.List;

public class GFG {

	public static void main(String[] args) {
		Libray library = new Libray();

        // Getting the list of books from the library
        List<Book> bks = library.getTotalBooksInLibrary();

        // Iterating over the books and printing their details
        for (Book bk : bks) {
            System.out.println("Title: " + bk.title + " and Author: " + bk.author);
        }

	}

}
class Book{
	
	public String title;
	public String author;
	
	Book(String title,String author){
		this.title = title;
		this.author = author;
	}
}
class Libray{
	
	private final List<Book> books;	
	Libray(){
		this.books = new ArrayList<>();
		this.books.add(new Book("Effective Java", "Joshua Bloch"));
        this.books.add(new Book("Thinking in Java", "Bruce Eckel"));
        this.books.add(new Book("Java: The Complete Reference", "Herbert Schildt"));
	 }
	// Method to return the list of books in the library
    public List<Book> getTotalBooksInLibrary() {
        return books;
    }
}
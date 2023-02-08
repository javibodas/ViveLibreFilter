package com.vivelibre.books.Comparators;

import java.util.Comparator;

import com.vivelibre.books.Entities.Book;

public class ComparatorBookAuthorBioLength implements Comparator<Book> {
	 @Override
	 public int compare(Book b1, Book b2) {
	    // TODO Auto-generated method stub
	    return  b1.getAuthor().getBio().length() - b2.getAuthor().getBio().length();
	  }
}
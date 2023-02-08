package com.vivelibre.books.Comparators;

import java.util.Comparator;

import com.vivelibre.books.Entities.Book;

public class ComparatorBookDate implements Comparator<Book> {
	@Override
	 public int compare(Book b1, Book b2) {
	    // TODO Auto-generated method stub
	    return  b2.getPublicationTimestamp() - b1.getPublicationTimestamp();
	  }
}

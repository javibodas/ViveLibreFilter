package com.vivelibre.books.Collections;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.vivelibre.books.Comparators.ComparatorBookAuthorBioLength;
import com.vivelibre.books.Comparators.ComparatorBookDate;
import com.vivelibre.books.Entities.Book;
import com.vivelibre.books.Entities.BookDate;

public class Books {
	
	private List<Book> list;
	
	
	public Books(List<Book> list)
	{
		this.list = list;
	}
	
	
	public List<Book> getBooks()
	{
		return list;
	}
	
	
	public void printBooksWithNoPublicationDate()
	{
		list
		.stream()
		.filter(book -> !book.hasPublicationDate())
		.forEach(book -> System.out.println(book.getTitle()));
	}
	
	
	public Optional<BookDate> filterBy(String filter)
	{
		return list
				.stream()
				.sorted(new ComparatorBookDate())
				.filter(book -> book.getTitle().contains(filter) && book.getAuthor().getBio().contains(filter) && book.getSummary().contains(filter))
				.map(book -> BookDate.createFromBook(book))
				.findFirst();
	}
	
	public Books sortByPublicationDateAndBioLength()
	{
		return new Books(
			list
				.stream()
				.sorted(new ComparatorBookDate())
				.sorted(new ComparatorBookAuthorBioLength())
				.collect(Collectors.toList())
		);
	}
	
	public void printBooks()
	{
		list
			.forEach(book -> System.out.println(book.toString()));
	}
}

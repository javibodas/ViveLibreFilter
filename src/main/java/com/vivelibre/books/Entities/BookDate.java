package com.vivelibre.books.Entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BookDate extends Book {

	private Date date;
	
	public BookDate(String id, String title, int pages, String summary, int publicationTimestamp, Author author) {
		super(id, title, pages, summary, publicationTimestamp, author);
		this.date = new Date(publicationTimestamp / 1000);
	}
	
	public String getDate() {
		DateFormat dateFormat = new SimpleDateFormat("mm-dd-yyyy");  
		return dateFormat.format(date);
	}
	
	public static BookDate createFromBook(Book book)
	{
		return new BookDate(book.getId(),
				book.getTitle(),
				book.getPages(),
				book.getSummary(),
				book.getPublicationTimestamp(),
				book.getAuthor()
		);
	}
	
	public String toString()
	{
		return "Book: " + title + 
				"\nResumen: " + summary +
				"\nAuthor: " + author.getName() +
				"\nDate: " + this.getDate();
	}
}

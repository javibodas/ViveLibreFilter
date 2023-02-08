package com.vivelibre.books.Entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Book implements Comparable<Book> {
	
	protected String id;
	
	protected String title;
	
	protected int pages;

	protected String summary;
	
	protected int publicationTimestamp;
	
	protected Author author;

	@JsonCreator
	public Book(
			@JsonProperty("id") String id, 
			@JsonProperty("title") String title, 
			@JsonProperty("pages") int pages, 
			@JsonProperty("summary") String summary, 
			@JsonProperty("publicationTimestamp") int publicationTimestamp, 
			@JsonProperty("author") Author author
	) {
		this.id = id;
		this.title = title;
		this.pages = pages;
		this.summary = summary;
		this.publicationTimestamp = publicationTimestamp;
		this.author = author;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public int getPublicationTimestamp() 
	{
		return publicationTimestamp;
	}

	public void setPublicationTimestamp(int publicationTimestamp) {
		this.publicationTimestamp = publicationTimestamp;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
	
	public boolean hasPublicationDate()
	{
		return this.publicationTimestamp > 0;
	}
	
	public String toString()
	{
		return "Book: " + title + "\nResumen: " + summary +
				"\nAuthor: " + author.getName();
	}
	
	
	@Override
	public int compareTo(Book o) {	    
	    return (int) (o.getPublicationTimestamp() - this.publicationTimestamp);
	}
}

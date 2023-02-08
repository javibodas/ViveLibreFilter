package com.vivelibre.books;

import java.io.IOException;
import java.util.Optional;
import org.json.simple.parser.ParseException;
import com.vivelibre.books.Collections.Books;
import com.vivelibre.books.Entities.BookDate;
import com.vivelibre.books.utils.FileJsonReader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try {
    		Books books = FileJsonReader.importBooksFromJsonFile("resources\\", "books.json");
    		books.printBooksWithNoPublicationDate();
    		
    		Optional<BookDate> b = books.filterBy("Potter");
    		if (b.isPresent()) {
    			System.out.println(b.get().toString());
    		}
    		
    		Books sortedBooks = books.sortByPublicationDateAndBioLength();
    		sortedBooks.printBooks();
    		
    	} catch (IOException exception) {
    		System.out.println("There was an error reading the file: " + exception.getMessage());
    		
    	} catch (ParseException exception) {
    		System.out.println("There was an error parsing the file: " + exception.getMessage());
    	}
    }
}

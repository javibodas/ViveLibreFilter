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
    	String filter = "Potter";
    	
    	try {
    		Books books = FileJsonReader.importBooksFromJsonFile("resources\\", "books.json");
    		books.printNotHavingPublicationDate();
    		System.out.println("\n\n\n");
    		
    		Optional<BookDate> b = books.filterBy(filter);
    		if (b.isPresent()) {
    			System.out.println(b.get().toString() + "\n\n\n");
    		}
    		
    		Books sortedBooks = books.sortByPublicationDateAndBioLength();
    		sortedBooks.print();
    		
    	} catch (IOException exception) {
    		System.out.println("There was an error reading the file: " + exception.getMessage());
    		
    	} catch (ParseException exception) {
    		System.out.println("There was an error parsing the file: " + exception.getMessage());
    	}
    }
}

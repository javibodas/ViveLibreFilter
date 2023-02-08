package com.vivelibre.books.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vivelibre.books.Collections.Books;
import com.vivelibre.books.Entities.Book;

public class FileJsonReader {
	
	private static JSONParser parser = new JSONParser();
	
	public static Books importBooksFromJsonFile(String path, String fileName) throws ParseException, IOException
	{
		JSONArray booksJson = readJsonArrayFromFile(path, fileName);
		ObjectMapper objectMapper = new ObjectMapper();
		List<Book> listBook = objectMapper.readValue(booksJson.toJSONString(), new TypeReference<List<Book>>(){});
		
		return new Books(listBook);
	}

	private static JSONArray readJsonArrayFromFile(String path, String fileName) throws ParseException, IOException
	{
		return (JSONArray) parser.parse(readFile(path, fileName));
	}
	
	
	private static FileReader readFile(String path, String fileName) throws IOException
	{
		return (new FileReader(path + fileName));
	}

}

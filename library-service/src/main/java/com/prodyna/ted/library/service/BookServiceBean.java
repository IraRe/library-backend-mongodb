/**
 * 
 */
package com.prodyna.ted.library.service;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.prodyna.ted.library.entity.Book;
import com.prodyna.ted.library.entity.Category;

/**
 * @author Iryna Feuerstein (PRODYNA AG)
 *
 */
@Stateless
public class BookServiceBean implements BookService {
	
	public static final String BOOKS_COLLECTION = "books";
	
	@Inject
	private MongoDatabase libraryDB;
	
	@Override
	public void addBook(Book book) {
		// TODO here comes your code
	}

	@Override
	public void removeBook(String isbn) {
		// TODO here comes your code
	}

	@Override
	public Book findBookByISBN(String isbn) {
		Book book = null;
		
		// TODO here comes your code
		
		return book;
	}

	@Override
	public List<Book> findBooksByTitle(String title) {
		
		// TODO here comes your code
		
		return null;
	}

	@Override
	public List<Book> findBooksByAuthor(String author) {
		
		// TODO here comes your code
		
		return null;
	}

	@Override
	public List<Book> findBooksByCategory(Category category) {
		
		// TODO here comes your code
		
		return null;
	}

	@Override
	public void removeAll() {
		// TODO here comes your code
	}

	@Override
	public List<Book> findAll() {
		// TODO here comes your code
		return null;
	}

}

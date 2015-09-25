package com.prodyna.ted.library.service;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.bson.Document;
import org.neo4j.graphdb.GraphDatabaseService;

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
	
	@Inject
	private GraphDatabaseService databaseService;

	@Override
	public void addBook(Book book) {
		// TODO your code comes here
	}

	@Override
	public void removeBook(String isbn) {
		// TODO your code comes here
	}

	@Override
	public Book findBookByISBN(String isbn) {
		Book book = null;
		
		// TODO your code comes here
		
		return book;
	}

	@Override
	public List<Book> findBooksByTitle(String title) {
		
		// TODO your code comes here
		
		return null;
	}

	@Override
	public List<Book> findBooksByAuthor(String author) {
		
		// TODO your code comes here
		
		return null;
	}

	@Override
	public List<Book> findBooksByCategory(Category category) {
		
		// TODO your code comes here
		
		return null;
	}

	@Override
	public void removeAll() {
		// TODO your code comes here
	}

	@Override
	public List<Book> findAll() {
		// TODO your code comes here
		return null;
	}

}

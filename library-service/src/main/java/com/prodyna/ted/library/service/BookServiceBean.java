package com.prodyna.ted.library.service;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.bson.Document;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.prodyna.ted.library.entity.Book;
import com.prodyna.ted.library.entity.Category;
import com.prodyna.ted.library.entity.LibraryUser;

/**
 * @author Iryna Feuerstein (PRODYNA AG)
 *
 */
@Stateless
public class BookServiceBean implements BookService {
	
	private static final String BOOKS = "books";
	
	@Inject
	private Jongo jongo;
	
	private MongoCollection getCollection() {
		return jongo.getCollection(BOOKS);
	}
	
	private List<Book> getAsList(MongoCursor<Book> mongoCursor) {
		List<Book> result = new ArrayList<Book>();
		
		for(Book book : mongoCursor) {
			result.add(book);
		}
		
		return result;
	}

	
	@Override
	public void addBook(Book book) {
		getCollection().insert(book);
	}

	@Override
	public void removeBook(String isbn) {
		getCollection().remove("{isbn : '" + isbn + "'}");
	}

	@Override
	public Book findBookByISBN(String isbn) {
		return getCollection().findOne("{isbn : '" + isbn + "'}").as(Book.class);
	}

	@Override
	public List<Book> findBooksByTitle(String title) {
		return getAsList(getCollection().find("{title : '" + title + "'}").as(Book.class));
	}

	@Override
	public List<Book> findBooksByAuthor(String author) {
		return getAsList(getCollection().find("{authors : '" + author + "'}").as(Book.class));
	}

	@Override
	public List<Book> findBooksByCategory(Category category) {
		return getAsList(getCollection().find("{categories : #}", category).as(Book.class));
	}

	@Override
	public void removeAll() {
		getCollection().remove();
	}

	@Override
	public List<Book> findAll() {
		return getAsList(getCollection().find().as(Book.class));
	}

}

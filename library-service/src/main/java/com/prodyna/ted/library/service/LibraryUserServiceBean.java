package com.prodyna.ted.library.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.bson.Document;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.prodyna.ted.library.entity.Book;
import com.prodyna.ted.library.entity.Category;
import com.prodyna.ted.library.entity.LibraryUser;

/**
 * @author Iryna Feuerstein (PRODYNA AG)
 *
 */
@Stateless
public class LibraryUserServiceBean implements LibraryUserService {
	
	private static final String USER = "user";
	
	@Inject
	private Jongo jongo;
	
	private MongoCollection getCollection() {
		return jongo.getCollection(USER);
	}
	
	private List<LibraryUser> getAsList(MongoCursor<LibraryUser> mongoCursor) {
		List<LibraryUser> result = new ArrayList<LibraryUser>();
		
		for(LibraryUser user : mongoCursor) {
			result.add(user);
		}
		
		return result;
	}


	@Override
	public void addUser(LibraryUser user) {	
		getCollection().insert(user);
	}

	@Override
	public void removeUser(UUID uuid) {
		getCollection().remove("{libraryUserID : #}", uuid);
	}

	@Override
	public LibraryUser findUserByUUID(UUID uuid) {
		return getCollection().findOne("{libraryUserID : #}", uuid).as(LibraryUser.class);
	}

	@Override
	public List<LibraryUser> findUsersByUsername(String username) {	
		return getAsList(getCollection().find("{username : '" + username + "'}").as(LibraryUser.class));	
	}

	@Override
	public List<LibraryUser> findUsersByFirstName(String firstname) {
		return getAsList(getCollection().find("{firstName : '" + firstname + "'}").as(LibraryUser.class));
	}

	@Override
	public List<LibraryUser> findUsersByLastName(String lastname) {
		return getAsList(getCollection().find("{lastName : '" + lastname + "'}").as(LibraryUser.class));
	}

	@Override
	public List<LibraryUser> findUsersByDateOfBirth(Date dateOfBirth) {
		return getAsList(getCollection().find("{dateOfBirth : #}", dateOfBirth).as(LibraryUser.class));
	}

	@Override
	public LibraryUser findUserByBookLent(Book book) {
		return getCollection().findOne("{lentBooks : #}", book).as(LibraryUser.class);
	}

	@Override
	public List<LibraryUser> findUsersByBooksLentInCategory(Category category) {
		return getAsList(getCollection().find("{lentBooks.categories : #}", category).as(LibraryUser.class));
	}

	@Override
	public void lendBook(Book book, LibraryUser user) {
		user.getLentBooks().add(book);	
		getCollection().update("{libraryUserID : #}", user.getLibraryUserID()).with(user);
	}

	@Override
	public List<Book> findBooksLentByUser(LibraryUser user) {
		return findUserByUUID(user.getLibraryUserID()).getLentBooks();
	}
	
	@Override
	public void removeAll() {
		getCollection().remove();
	}

	@Override
	public List<LibraryUser> findAll() {
		return getAsList(getCollection().find().as(LibraryUser.class));
	}

}

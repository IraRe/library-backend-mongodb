/**
 * 
 */
package com.prodyna.ted.library.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.prodyna.ted.library.entity.Book;
import com.prodyna.ted.library.entity.Category;
import com.prodyna.ted.library.entity.LibraryUser;

/**
 * @author Iryna Feuerstein (PRODYNA AG)
 *
 */
@Stateless
public class LibraryUserServiceBean implements LibraryUserService {
	
	public static final String LIBRARY_USERS_COLLECTION = "users";
	
	@Inject
	private MongoDatabase libraryDB;

	@Override
	public void addUser(LibraryUser user) {
		MongoCollection<Document> users = libraryDB.getCollection(LIBRARY_USERS_COLLECTION);
		
	}

	@Override
	public void removeUser(UUID uuid) {
		// TODO Auto-generated method stub

	}

	@Override
	public LibraryUser findUserByUUID(UUID uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LibraryUser> findUsersByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LibraryUser> findUsersByFirstName(String firstname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LibraryUser> findUsersByLastName(String lastname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LibraryUser> findUsersByDateOfBirth(Date dateOfBirth) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LibraryUser findUserByBookLent(Book book) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LibraryUser> findUsersByBooksLentInCategory(Category category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void lendBook(Book book, LibraryUser user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Book> findBooksLentByUser(LibraryUser user) {
		// TODO Auto-generated method stub
		return null;
	}

}

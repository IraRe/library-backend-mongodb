package com.prodyna.ted.library.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.prodyna.ted.library.entity.Book;
import com.prodyna.ted.library.entity.Category;
import com.prodyna.ted.library.entity.LibraryUser;

/**
 * @author Iryna Feuerstein (PRODYNA AG)
 *
 */
public interface LibraryUserService {
	
	public void addUser(LibraryUser user);
	
	public void removeUser(UUID uuid);
	
	public void lendBook(Book book, LibraryUser user);
	
	public LibraryUser findUserByUUID(UUID uuid);
	
	public List<LibraryUser> findUsersByUsername(String username);
	
	public List<LibraryUser> findUsersByFirstName(String firstname);
	
	public List<LibraryUser> findUsersByLastName(String lastname);
	
	public List<LibraryUser> findUsersByDateOfBirth(Date dateOfBirth);
	
	public LibraryUser findUserByBookLent(Book book);
	
	public List<LibraryUser> findUsersByBooksLentInCategory(Category category);
	
	public List<Book> findBooksLentByUser(LibraryUser user);

}

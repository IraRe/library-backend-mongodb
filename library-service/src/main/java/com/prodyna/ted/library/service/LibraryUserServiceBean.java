package com.prodyna.ted.library.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;

import com.prodyna.ted.library.entity.Book;
import com.prodyna.ted.library.entity.Category;
import com.prodyna.ted.library.entity.LibraryUser;

/**
 * @author Iryna Feuerstein (PRODYNA AG)
 *
 */
@Stateless
public class LibraryUserServiceBean implements LibraryUserService {
	
    @Inject
    private GraphDatabaseService databaseService;

	@Override
	public void addUser(final LibraryUser user) {

	    Transaction transaction = databaseService.beginTx();
	    
	    Node userNode = databaseService.createNode();
	    userNode.addLabel(new Label() {
            @Override
            public String name() {
                return user.getFirstName() + " " + user.getLastName();
            }
        });
	    
	    userNode.setProperty("libraryUserID", user.getLibraryUserID());
        userNode.setProperty("username", user.getUsername());
        userNode.setProperty("firstName", user.getFirstName());
        userNode.setProperty("lastName", user.getLastName());
        userNode.setProperty("dateOfBirth", user.getDateOfBirth());
        userNode.setProperty("telephoneNumber", user.getTelephoneNumber());
        
        transaction.success();
	}

	@Override
	public void removeUser(UUID uuid) {
		// TODO your code comes here

	}

	@Override
	public LibraryUser findUserByUUID(UUID uuid) {
		// TODO your code comes here
		return null;
	}

	@Override
	public List<LibraryUser> findUsersByUsername(String username) {
		// TODO your code comes here
		return null;
	}

	@Override
	public List<LibraryUser> findUsersByFirstName(String firstname) {
		// TODO your code comes here
		return null;
	}

	@Override
	public List<LibraryUser> findUsersByLastName(String lastname) {
		// TODO your code comes here
		return null;
	}

	@Override
	public List<LibraryUser> findUsersByDateOfBirth(Date dateOfBirth) {
		// TODO your code comes here
		return null;
	}

	@Override
	public LibraryUser findUserByBookLent(Book book) {
		// TODO your code comes here
		return null;
	}

	@Override
	public List<LibraryUser> findUsersByBooksLentInCategory(Category category) {
		// TODO your code comes here
		return null;
	}

	@Override
	public void lendBook(Book book, LibraryUser user) {
		// TODO your code comes here
		
	}

	@Override
	public List<Book> findBooksLentByUser(LibraryUser user) {
		// TODO your code comes here
		return null;
	}
	
	@Override
	public void removeAll() {
		// TODO your code comes here
	}

	@Override
	public List<LibraryUser> findAll() {
		// TODO your code comes here
		return null;
	}

}

package com.prodyna.ted.library.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;

import com.prodyna.ted.library.entity.Book;
import com.prodyna.ted.library.entity.Category;
import com.prodyna.ted.library.relationship.LibraryRelationshipType;

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

        try (Transaction tx = databaseService.beginTx()) {
            bookToNode(book);
            tx.success();
        }

    }

    @Override
    public Node bookToNode(Book book) {
        // Book
        Node bookNode = databaseService.createNode();
        bookNode.addLabel(new Label() {
            @Override
            public String name() {
                return book.getTitle();
            }
        });
        bookNode.setProperty("isbn", book.getIsbn());
        bookNode.setProperty("sub", book.getSubtitle());

        // Authoren
        for (final String name : book.getAuthors()) {
            Node authorNode = databaseService.createNode();
            bookNode.addLabel(new Label() {
                @Override
                public String name() {
                    return name;
                }
            });
            bookNode.createRelationshipTo(authorNode, LibraryRelationshipType.WRITTEN_BY);
        }

        // Cats
        for (final Category cat : book.getCategories()) {
            Node catNode = databaseService.createNode();
            bookNode.addLabel(new Label() {
                @Override
                public String name() {
                    return cat.getName();
                }
            });
            bookNode.createRelationshipTo(catNode, LibraryRelationshipType.IS_IN);
        }

        return bookNode;
    }

    @Override
    public void removeBook(String isbn) {

        Transaction transaction = databaseService.beginTx();
        // databaseService.findNode(label, key, value)
    }

    @Override
    public Book findBookByISBN(String isbn) {
        Book book = null;

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
        return null;
    }

}

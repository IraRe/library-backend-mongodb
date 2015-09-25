package com.prodyna.ted.library.service;

import java.util.List;

import org.neo4j.graphdb.Node;

import com.prodyna.ted.library.entity.Book;
import com.prodyna.ted.library.entity.Category;

/**
 * @author Iryna Feuerstein (PRODYNA AG)
 *
 */
public interface BookService {

    public void addBook(Book book);

    public void removeBook(String isbn);

    public Book findBookByISBN(String isbn);

    public List<Book> findBooksByTitle(String title);

    public List<Book> findBooksByAuthor(String author);

    public List<Book> findBooksByCategory(Category category);

    public void removeAll();

    public List<Book> findAll();

    Node bookToNode(Book book);

}

package com.prodyna.ted.library.service;

import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.jboss.shrinkwrap.resolver.api.maven.PomEquippedResolveStage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.prodyna.ted.library.entity.Book;
import com.prodyna.ted.library.entity.Category;

@RunWith(Arquillian.class)
public class BookServiceTest {

    @Deployment
    public static Archive<?> createDeployment() {
        PomEquippedResolveStage pom = Maven.resolver().loadPomFromFile("pom.xml");
        WebArchive war = ShrinkWrap.create(WebArchive.class, "library.war");
        war.addPackages(true, "com.prodyna.ted.library");
        war.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
        war.addAsLibraries(pom.importCompileAndRuntimeDependencies().resolve().withTransitivity().asFile());
        return war;
    }

    @Inject
    private BookService bookService;

    @Test
    @InSequence(0)
    public final void testAddBook1() {
        Book book = new Book("Emil und die Detektive", "978-3791530123");
        book.getAuthors().add("Erich Kästner");
        bookService.addBook(book);
    }

    @Test
    @InSequence(1)
    public final void testRemoveAll1() {
        bookService.removeAll();
        List<Book> allBooks = bookService.findAll();
        Assert.assertNotNull(allBooks);
        Assert.assertTrue(allBooks.isEmpty());
    }

    @Test
    @InSequence(2)
    public final void testAddBook2() {
        Book book = new Book("Alice's Adventures in Wonderland", "978-1447279990");
        book.getAuthors().add("Lewis Carroll");
        book.getCategories().add(new Category("children"));
        book.getCategories().add(new Category("classics"));
        bookService.addBook(book);
    }

    @Test
    @InSequence(3)
    public final void testAddBook3() {
        Book book = new Book("Der Verdacht", "978-3257214369");
        book.getAuthors().add("Friedrich Dürrenmatt");
        book.getCategories().add(new Category("detective"));
        book.getCategories().add(new Category("classics"));
        bookService.addBook(book);
    }

    @Test
    @InSequence(4)
    public final void testAddBook4() {
        Book book = new Book("Animal Farm", "978-3257214xxx");
        book.getCategories().add(new Category("classics"));
        bookService.addBook(book);
    }

    @Test
    @InSequence(5)
    public final void testAddBook5() {
        Book book = new Book("Clean Code", "978-0-13-235088-4");
        book.setSubtitle("A Handbook of Agile Software Craftsmanship");
        bookService.addBook(book);
    }

    @Test
    @InSequence(6)
    public final void testFindAll() {
        List<Book> books = bookService.findAll();
        Assert.assertNotNull(books);
        Assert.assertFalse(books.isEmpty());
        Assert.assertEquals(5, books.size());
    }

    @Test
    @InSequence(7)
    public final void testFindBookByISBN() {
        Book book = bookService.findBookByISBN("978-0-13-235088-4");
        Assert.assertNotNull(book);
        Assert.assertEquals("Clean Code", book.getTitle());
    }

    @Test
    @InSequence(8)
    public final void testFindBooksByTitle() {
        List<Book> books = bookService.findBooksByTitle("Animal Farm");
        Assert.assertNotNull(books);
        Assert.assertFalse(books.isEmpty());
        Assert.assertEquals(1, books.size());
        Assert.assertEquals("978-3257214xxx", books.get(0).getIsbn());
    }

    @Test
    @InSequence(9)
    public final void testFindBooksByAuthor() {
        List<Book> books = bookService.findBooksByAuthor("Erich Kästner");
        Assert.assertNotNull(books);
        Assert.assertFalse(books.isEmpty());
        Assert.assertEquals(1, books.size());
        Assert.assertEquals("Emil und die Detektive", books.get(0).getTitle());
    }

    @Test
    @InSequence(10)
    public final void testFindBooksByCategory() {
        List<Book> classicBooks = bookService.findBooksByCategory(new Category("classics"));
        Assert.assertNotNull(classicBooks);
        Assert.assertFalse(classicBooks.isEmpty());
        Assert.assertEquals(3, classicBooks.size());
    }

    @Test
    @InSequence(11)
    public final void testRemoveBook() {
        bookService.removeBook("978-0-13-235088-4");
        Book book = bookService.findBookByISBN("978-0-13-235088-4");
        Assert.assertNull(book);
    }

    @Test
    @InSequence(12)
    public final void testRemoveAll2() {
        bookService.removeAll();
        List<Book> allBooks = bookService.findAll();
        Assert.assertNotNull(allBooks);
        Assert.assertTrue(allBooks.isEmpty());
    }

}

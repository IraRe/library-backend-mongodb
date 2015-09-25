package com.prodyna.ted.library.service;

import java.util.List;
import java.util.UUID;

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
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.prodyna.ted.library.entity.Book;
import com.prodyna.ted.library.entity.Category;
import com.prodyna.ted.library.entity.LibraryUser;

/**
 * @author Iryna Feuerstein (PRODYNA AG)
 *
 */
@Ignore
@RunWith(Arquillian.class)
public class LibraryUserServiceTest {

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
    private LibraryUserService libraryUserService;

    @Inject
    private BookService bookService;

    @Test
    @InSequence(0)
    public final void testRemoveAll1() {
        libraryUserService.removeAll();
        List<LibraryUser> userList = libraryUserService.findAll();
        Assert.assertNotNull(userList);
        Assert.assertTrue(userList.isEmpty());
    }

    @Test
    @InSequence(1)
    public final void testAddUser1() {
        LibraryUser iryna = new LibraryUser("Iryna", "Feuerstein");
        iryna.setDateOfBirth(new DateTime(1985, 11, 3, 6, 15).toDate());
        iryna.setUsername("irare");

        Book book1 = new Book("Clean Code", "978-0-13-235088-4");
        book1.setSubtitle("A Handbook of Agile Software Craftsmanship");
        iryna.getLentBooks().add(book1);

        Book book2 = new Book("Der Verdacht", "978-3257214369");
        book2.getAuthors().add("Friedrich Dürrenmatt");
        book2.getCategories().add(new Category("detective"));
        book2.getCategories().add(new Category("classics"));

        iryna.getLentBooks().add(book2);

        libraryUserService.addUser(iryna);
    }

    @Test
    @InSequence(2)
    public final void testAddUser2() {
        LibraryUser iryna = new LibraryUser("Wilma", "Feuerstein");
        iryna.setDateOfBirth(new DateTime(1988, 4, 1, 2, 45).toDate());
        iryna.setUsername("wilma");
        libraryUserService.addUser(iryna);
    }

    @Test
    @InSequence(3)
    public final void testAddUser3() {
        LibraryUser stefan = new LibraryUser("Stefan", "Schubert");
        stefan.setTelephoneNumber("0049-(0)211-xxxxx");
        stefan.setUsername("steve007");
        libraryUserService.addUser(stefan);
    }

    @Test
    @InSequence(4)
    public final void testAddUser4() {
        LibraryUser erzen = new LibraryUser("Erzen", "Hyko");
        erzen.setDateOfBirth(new DateTime(1988, 4, 1, 2, 45).toDate());
        erzen.setUsername("ErzenBoy");

        Book book = new Book("Alice's Adventures in Wonderland", "978-1447279990");
        book.getAuthors().add("Lewis Carroll");
        book.getCategories().add(new Category("children"));
        book.getCategories().add(new Category("classics"));

        erzen.getLentBooks().add(book);

        libraryUserService.addUser(erzen);
    }

    @Test
    @InSequence(5)
    public final void testAddUser5() {
        LibraryUser markus = new LibraryUser("Markus", "Fröhlich");
        markus.setTelephoneNumber("0049-xxx-yyyyy");
        markus.setUsername("teddybär");
        libraryUserService.addUser(markus);
    }

    @Test
    @InSequence(6)
    public final void testFindAll() {
        List<LibraryUser> allUsers = libraryUserService.findAll();
        Assert.assertNotNull(allUsers);
        Assert.assertFalse(allUsers.isEmpty());
        Assert.assertEquals(5, allUsers.size());
    }

    @Test
    @InSequence(7)
    public final void testFindUsersByUsername() {
        List<LibraryUser> users = libraryUserService.findUsersByUsername("steve007");
        Assert.assertNotNull(users);
        Assert.assertEquals(1, users.size());
        LibraryUser stefan = users.get(0);
        Assert.assertNotNull(stefan);
        Assert.assertEquals("Stefan", stefan.getFirstName());
        Assert.assertEquals("Schubert", stefan.getLastName());
        Assert.assertEquals("0049-(0)211-xxxxx", stefan.getTelephoneNumber());
    }

    @Test
    @InSequence(8)
    public final void testFindUserByUUID() {
        List<LibraryUser> users = libraryUserService.findUsersByUsername("ErzenBoy");
        LibraryUser libraryUser = users.get(0);
        UUID libraryUserID = libraryUser.getLibraryUserID();
        LibraryUser erzen = libraryUserService.findUserByUUID(libraryUserID);
        Assert.assertEquals(libraryUser, erzen);
    }

    @Test
    @InSequence(9)
    public final void testFindUsersByFirstName() {
        List<LibraryUser> users = libraryUserService.findUsersByFirstName("Markus");
        Assert.assertNotNull(users);
        Assert.assertEquals(1, users.size());
        LibraryUser markus = users.get(0);
        Assert.assertNotNull(markus);
        Assert.assertEquals("Fröhlich", markus.getLastName());
        Assert.assertEquals("0049-xxx-yyyyy", markus.getTelephoneNumber());
    }

    @Test
    @InSequence(10)
    public final void testFindUsersByLastName() {
        List<LibraryUser> users = libraryUserService.findUsersByLastName("Feuerstein");
        Assert.assertNotNull(users);
        Assert.assertFalse(users.isEmpty());
        Assert.assertEquals(2, users.size());
    }

    @Test
    @InSequence(11)
    public final void testFindUsersByDateOfBirth() {
        List<LibraryUser> users = libraryUserService.findUsersByDateOfBirth(new DateTime(1988, 4, 1, 2, 45).toDate());
        Assert.assertNotNull(users);
        Assert.assertFalse(users.isEmpty());
        Assert.assertEquals(2, users.size());
    }

    @Test
    @InSequence(12)
    public final void testFindUserByBookLent() {
        Book book = new Book("Clean Code", "978-0-13-235088-4");
        book.setSubtitle("A Handbook of Agile Software Craftsmanship");
        LibraryUser user = libraryUserService.findUserByBookLent(book);
        Assert.assertNotNull(user);
        Assert.assertEquals("Iryna", user.getFirstName());
    }

    @Test
    @InSequence(13)
    public final void testFindUsersByBooksLentInCategory() {
        List<LibraryUser> users = libraryUserService.findUsersByBooksLentInCategory(new Category("classics"));
        Assert.assertNotNull(users);
        Assert.assertFalse(users.isEmpty());
        Assert.assertEquals(2, users.size());
    }

    @Test
    @InSequence(14)
    public final void testLendBook() {
        Book book = new Book("Emil und die Detektive", "978-3791530123");
        book.getAuthors().add("Erich Kästner");
        bookService.addBook(book);
        LibraryUser stefan = libraryUserService.findUsersByLastName("Schubert").get(0);
        libraryUserService.lendBook(book, stefan);
        System.out.println(stefan);
    }

    @Test
    @InSequence(15)
    public final void testFindBooksLentByUser() {
        LibraryUser stefan = libraryUserService.findUsersByLastName("Schubert").get(0);
        System.out.println(stefan);
        List<Book> booksLentByStefan = libraryUserService.findBooksLentByUser(stefan);
        Assert.assertNotNull(booksLentByStefan);
        Assert.assertFalse(booksLentByStefan.isEmpty());
    }

    @Test
    @InSequence(16)
    public final void testRemoveUser() {
        List<LibraryUser> users = libraryUserService.findUsersByUsername("ErzenBoy");
        UUID libraryUserID = users.get(0).getLibraryUserID();
        libraryUserService.removeUser(libraryUserID);
        LibraryUser user = libraryUserService.findUserByUUID(libraryUserID);
        Assert.assertNull(user);
    }

    @Test
    @InSequence(17)
    public final void testRemoveAll2() {
        libraryUserService.removeAll();
        List<LibraryUser> userList = libraryUserService.findAll();
        Assert.assertNotNull(userList);
        Assert.assertTrue(userList.isEmpty());
    }

}

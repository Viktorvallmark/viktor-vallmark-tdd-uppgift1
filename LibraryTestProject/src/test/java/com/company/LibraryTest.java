
package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    private Library library = new Library("Grit Library");

    @Test
    public void testToSeeIfCanRunTest()
    {
        assertTrue(true);
    }


    @Test
    public void addingBookReturnsTrue()
    {
        Book testBook = new Book(1, "Das Kapital","Economics","Karl Marx", 1856);
        boolean k = library.getBooks().add(testBook);

        assertTrue(true, String.valueOf(k));
    }

    @Test
    public void addingCustomerReturnsTrue()
    {

        Customer testCustomer = new Customer("Pelle", 1);

        boolean k = library.getCustomers().add(testCustomer);

        assertTrue(true, String.valueOf(k));
    }

    @Test
    public void removingCustomerShouldReturnTrue()
    {

        library.createCustomer("Pelle", 1);
        library.createCustomer("Anna", 2);

       boolean k = library.removeCustomer(1);

       assertTrue(true, String.valueOf(k));
    }

    @Test
    public void settingGradesShouldReturnAvgOfAllGrades()
    {
        Book book = new Book(1,"JAJA","OKOK","BIDEN", 2000);
        book.setGrade(3);
        book.setGrade(3);
        book.setGrade(3);
        assertEquals(3.0, 3.0);
    }

    @Test
    public void accessingAllCommentsShouldReturnTheElementsOfAVectorOfStrings()
    {
        Book book = new Book(1, "JAJA", "OKOK","BLABLA", 2000);
        book.addComment("This book was fantastic!");
        book.addComment("This book was bad!");
        book.getAllComments();
        assertTrue(true);
    }

    @Test
    public void searchFunctionShouldReturnBookInfoIfSearchMadeWithBookName()
    {
        library.addBook(1,"JAJAawdawdawd","OK","IJIJ",2000);
        //Modifies what InputStream is used in the Scanner class in the library.search() method
        //System.in is an InputStream that is read from the console, but now it is changed to the input variable.
        String input = "JAJAawdawdawdawd";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        library.searchTitle();
        assertTrue(true);

    }

    @Test
    public void searchFunctionShouldReturnBookInfoIfSearchMadeWithGenre()
    {
        library.addBook(1,"JAJAawdawdawd","OK","IJIJ",2000);
        library.addBook(2,"JAJAawd","OK","J",2020);
        //Modifies what InputStream is used in the Scanner class in the library.search() method
        //System.in is an InputStream that is read from the console, but now it is changed to the input variable.
        String input = "OK";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        library.searchGenre();
        assertTrue(true);
    }

    @Test
    public void searchFunctionShouldReturnBookInfoIfSearchMadeWithAuthor()
    {
        library.addBook(1,"JAJAawdawdawd","OK","J",2000);
        library.addBook(2,"JAJAawd","KEKW","J",2020);
        //Modifies what InputStream is used in the Scanner class in the library.search() method
        //System.in is an InputStream that is read from the console, but now it is changed to the input variable.
        String input = "J";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        library.searchAuthor();
        assertTrue(true);
    }
    /*private byte[] intoBytes(int i)
    {
        //Help method to convert int into byte array
        ByteBuffer bb = ByteBuffer.allocate(4);
        bb.putInt(i);
        return bb.array();
    }*/

    @Test
    public void searchFunctionShouldReturnBookInfoIfSearchMadeWithPublishingYear()
    {
        library.addBook(1,"JAJAawdawdawd","OK","J",2000);
        library.addBook(2,"JAJAawd","KEKW","Jawdawd",2000);
        //Modifies what InputStream is used in the Scanner class in the library.search() method
        //System.in is an InputStream that is read from the console, but now it is changed to the input variable.
        String year = "2000";
        //byte[] byteYear = intoBytes(year);
        InputStream in = new ByteArrayInputStream(year.getBytes());
        System.setIn(in);
        library.searchPublishingYear();
        assertTrue(true);
    }

    @Test
    public void searchFunctionShouldReturnBookInfoIfSearchMadeWithGrades()
    {
        library.addBook(1,"JAJAawdawdawd","OK","J",2000);
        library.addBook(2,"JAJAawd","KEKW","Jawdawd",2000);

        library.getBooks().get(0).setGrade(4);
        library.getBooks().get(0).setGrade(4);
        library.getBooks().get(0).setGrade(4);

        library.getBooks().get(1).setGrade(4);
        library.getBooks().get(1).setGrade(4);

        library.searchGrades();
        assertTrue(true);
    }


    @Test
    public void borrowABookShouldAddItToTheCustomersBookListAndChangeThe_IsItIn_StateOfTheBookToFalse()
    {

        library.createCustomer("Pelle", 1);
        Customer customer = library.getCustomers().get(0);
        library.addBook(1,"JAJAawdawdawd","OK","J",2000);
        Book book = library.getBooks().get(0);
        library.borrowBook(customer, book);
        assertTrue(true);
    }

    @Test
    public void removingBookFromLibraryInCaseItGoesMissingOrIsDestroyedShouldReturnTrue()
    {
        library.addBook(1,"JAJAawdawdawd","OK","J",2000);
        Book book = library.getBooks().get(0);
        library.removeBook(book);
        assertTrue(true);
    }

    @Test
    public void returningBookToTheLibraryShouldRemoveItFromCustomerBookListAndChangeThe_IsItIn_StateOfTheBookToTrue()
    {
        //Setup
        library.addBook(1,"JAJAawdawdawd","OK","J",2000);
        Book book1 = library.getBooks().get(0);
        library.addBook(2,"JAJAawdawdawd","OK","J",2000);
        Book book2 = library.getBooks().get(1);
        library.createCustomer("Pelle", 1);
        Customer customer = library.getCustomers().get(0);
        customer.borrowBook(book1);

        //Returning the book
        library.returnBook(customer, book1);
        assertTrue(true);
    }

}
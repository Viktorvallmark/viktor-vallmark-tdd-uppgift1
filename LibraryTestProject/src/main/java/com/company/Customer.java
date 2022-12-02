package com.company;

import java.util.HashSet;
import java.util.Vector;

public class Customer {

    private Vector<Book> bookList = new Vector<>();
    private final String name;
    private final int ID;



    public Customer( String name, int ID)
    {
        this.name = name;
        this.ID = ID;
    }

    public Vector<Book> getBookList() {
        return bookList;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public Vector<Book> borrowBook(Book book)
    {
        bookList.add(book);
        return bookList;
    }

    public void returnBook(Book book)
    {
        if(bookList.contains(book))
        {
            bookList.remove(book);
            System.out.println( book.getTitle() + " has been returned to the library!");
        }else
        {
            System.out.println("You can't return something you haven't borrowed yet!");
        }
    }
}

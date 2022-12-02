package com.company;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Library {

    private Vector<Customer> customers = new Vector<>();
    private Vector<Book> books = new Vector<>();
    private final String name;
    private HashSet<Integer> idBookSet = new HashSet<>();
    private HashSet<Integer> idCustSet = new HashSet<>();
    private long profitsFromLending = 0;

    public Library(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public Vector<Customer> getCustomers()
    {
        return customers;
    }

    public Vector<Book> getBooks()
    {
        if(books.isEmpty())
        {
            System.out.println("There are no books in the library!");
        }
        return books;
    }

    public HashSet<Integer> getIdCustSet()
    {
        return idCustSet;
    }
    public HashSet<Integer> getIdBookSetSet()
    {
        return idBookSet;
    }

    public long getProfitsFromLending(){ return profitsFromLending;}
    public void setProfitsFromLending(long profit){ this.profitsFromLending += profit;}

    private int getCustomerIndex(int ID){
        int custIndex = -1;
        for(Customer customer : customers){
            if(customer.getID() == ID){
                custIndex = customers.indexOf(customer);
            }
        }
        return custIndex;
    }

    public void addBook(int ID, String title, String genre, String author, int publishingYear)
    {
        books.add(new Book(ID, title, genre, author, publishingYear));
        idBookSet.add(ID);
        System.out.println("Book with ID " + ID +" , title "+ title+" , genre "+genre+" , written by "+author+" written in "+ publishingYear+" added to the library!" );
    }

    public void removeBook(Book book)
    {
        //removeBook-function in case the book is lost, destroyed or not be able to be physically found.
        if(books.contains(book))
        {
            books.remove(book);
            System.out.println("Book with ID "+book.getID()+" and title "+book.getTitle()+" removed.");
        }
    }

    public void createCustomer(String name, int ID)
    {
        try {
            customers.add(new Customer(name, ID));
            idCustSet.add(ID);
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally {
            System.out.println("Customer "+ name +" with ID: "+ID+" added to the library!");
        }
    }

    public boolean removeCustomer(int ID)
    {
        for(Customer customer : customers)
        {
            if(customer.getID() == ID)
            {
                customers.remove(getCustomerIndex(ID));
                System.out.println("Customer with ID "+ID+" has been deleted!");
                idCustSet.remove(ID);
                return true;
            }else
            {
                System.out.println("Customer with ID "+ID+" wasn't found!");
                return false;
            }
        }
    return false;
    }

    public void searchTitle()
    {
        //This is search function using part of title as search parameter. Uses first 4 characters to make the search.
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the title you want to search for: ");
        String inputSub = scan.next().substring(0,3);
        try{
            for (Book book : books)
            {
                if(book.getTitle().substring(0,3).equals(inputSub))
                {
                    System.out.println("Book with title: " + book.getTitle()+" found! It is written by "+book.getAuthor()+". It was" +
                            " published in "+ book.getPublishingYear()+". The genre is "+book.getGenre()+" and " +
                            "user have rated it " +book.getGrade()+ "based on "+book.numberOfUserGrades()+" number of ratings!");
                }else
                {
                    System.out.println("A book with title "+book.getTitle()+" wasn't found!");
                }
            }
            }catch(Exception ne)
            {
                ne.printStackTrace();
            }
        scan.close();
    }

    public void searchGenre()
    {
        //This is search function using genre as search parameter. It gives titles, authors, publishing year and user rating
        // of books with the genre given by user.
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the genre you want to search for: ");
        String inputSub = scan.next();
        try{
            for (Book book : books)
            {
                if(book.getGenre().equals(inputSub))
                {
                    System.out.println("Book with genre: " + book.getGenre()+" found! The title is "+book.getTitle()+" and " +
                            "is written by "+book.getAuthor()+". It was published in year "+book.getPublishingYear()+" and " +
                            "user have rated it " +book.getGrade()+ "based on "+book.numberOfUserGrades()+" number of ratings!");
                }else
                {
                    System.out.println("Books with genre "+book.getGenre()+" weren't found!");
                }
            }
        }catch(Exception ne)
        {
            ne.printStackTrace();
        }
        scan.close();
    }

    public void searchAuthor()
    {
        //This is search function using the author as search parameter. It gives titles, authors, publishing year and user rating
        // of books with the author given by user.
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the publishing year you want to search for: ");
        String inputSub = scan.next();
        try{
            for (Book book : books)
            {
                if(book.getAuthor().equals(inputSub))
                {
                    System.out.println("Book from author: " + book.getAuthor()+" found! The title is "+book.getTitle()+" and " +
                            "the genre is "+book.getGenre()+". It was published in year "+book.getPublishingYear()+" and " +
                            "users have rated it " +book.getGrade()+ " based on "+book.numberOfUserGrades()+" number of ratings!");
                }else
                {
                    System.out.println("Books from author "+book.getAuthor()+" weren't found!");
                }
            }
        }catch(Exception ne)
        {
            ne.printStackTrace();
        }
        scan.close();
    }

    public void searchPublishingYear()
    {
        //This is search function using the publishing year as search parameter.It gives titles, authors, genre and user rating
        // of books with the publishing year given by user.
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the publishing year you want to search for: ");
        String inputSub = scan.next();
        try{
            for (Book book : books)
            {
                if(Integer.toString(book.getPublishingYear()).equals(inputSub))
                {
                    System.out.println("Book published in the year: " + book.getPublishingYear()+" found! The title is "+book.getTitle()+" and " +
                            "the genre is "+book.getGenre()+". It was written by "+book.getAuthor()+" and " +
                            "users have rated it " +book.getGrade()+ " based on "+book.numberOfUserGrades()+" number of ratings!");
                }else
                {
                    System.out.println("Books from author "+book.getAuthor()+" weren't found!");
                }
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        scan.close();
    }

    public void searchGrades()
    {
        //This is search function using the grades as search parameter.It gives the title, author, genre and publishing year
        // of the book with the highest rating from the most total number of ratings.

        float startValue = books.get(0).getGrade();
        int numOfReviews = books.get(0).numberOfUserGrades();

        Iterator<Book> iterator = books.iterator();

        while(iterator.hasNext())
        {
            Book nextBook = (Book) iterator.next();
            if((nextBook.getGrade() > startValue) && (nextBook.numberOfUserGrades() > numOfReviews))
            {

                startValue = nextBook.getGrade();
                numOfReviews = nextBook.numberOfUserGrades();
            }
        }
        try
        {
            for(Book book : books)
            {
                if(book.getGrade()==startValue && book.numberOfUserGrades() ==numOfReviews)
                {
                    System.out.println("Book found with "+book.getGrade()+" STARS from "+book.numberOfUserGrades()+" total reviews." +
                            " The title is "+book.getTitle()+ ", written by "+book.getAuthor()+" in the year "+book.getPublishingYear()+"." +
                            " It is a book in the "+book.getGenre()+" genre.");
                }
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    //borrowBook with a payment
    private int calculatePayment(int price, int numberOfBooks)
    { //helper function to calculate the price
        return price * numberOfBooks;
    }

    public void borrowBook(Customer customer, @NotNull Book book)
    {
        //Check if book is in
        if(book.getItIn())
        {
            long preBorrowProfit = getProfitsFromLending();
            customer.borrowBook(book);
            book.setItIn(false);
            int pay = calculatePayment(10, 1);
            setProfitsFromLending(pay);
            long postBorrowProfit = getProfitsFromLending();
            if(postBorrowProfit > preBorrowProfit)
            {
                System.out.println("Payment received! You have borrowed the book "+ book.getTitle()+", by "+book.getAuthor()+".");
            }

        }else
        {
            System.out.println("The book you wanted to borrow isn't in!");
        }
    }
    //TODO returnBook
    public void returnBook(Customer customer, Book book)
    {
        customer.returnBook(book);
        book.setItIn(true);
    }

}

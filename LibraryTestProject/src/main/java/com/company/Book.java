package com.company;

import java.util.HashSet;
import java.util.Vector;

public class Book {

    private final long ID;
    private final String title;
    private Vector<String> comment = new Vector<>();
    private float grade;
    private int publishingYear;
    private final String author;
    private final String genre;
    private Vector<Integer> gradeVector = new Vector<>();
    private boolean isItIn = true;

    public Book(long ID, String title, String genre, String author, int publishingYear) {
        this.ID = ID;
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.publishingYear = publishingYear;
    }

    public boolean isItIn() {
        return isItIn;
    }

    public void setItIn(boolean itIn) {
        isItIn = itIn;
    }

    public float getGrade()
    {
        return grade;
    }
    private void setGrade(float grade)
    {
        this.grade = grade;
    }

    public long getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() { return author; }

    public String getGenre() { return genre; }

    public int getPublishingYear() { return publishingYear; }

    public void addComment(String text)
    {
        comment.add(text);
    }

    public void getAllComments()
    {
        for(String text : comment)
        {
            System.out.println(text);
        }
    }
    public void setGrade(int grade)
    {
        gradeVector.add(grade);
        int k = 0;
        //Calculate average grade
        try {
            for(int grades : gradeVector)
            {
                k =+ grades;
            }
        }finally 
        {
            float avgGrades = ((float)k)/ gradeVector.size();
            setGrade(avgGrades);
        }
    }
    public int numberOfUserGrades()
    {
        return gradeVector.size();
    }
}

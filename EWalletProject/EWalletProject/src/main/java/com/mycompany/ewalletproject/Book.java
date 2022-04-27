package com.mycompany.ewalletproject;
import java.sql.*;

public class Book {
    private String isbn;
    private String title;
    private Date pubdate;
    private Publisher publishers;
    private double cost;
    private double retail;
    private double discount;
    private String category;


    public Book(String isbn, String title, Date pubdate, Publisher publishers, 
    double cost, double retail, double discount, String category){
        this.isbn = isbn;
        this.title = title;
        this.pubdate = pubdate;
        this.publishers = publishers;
        this.cost = cost;
        this.retail = retail;
        this.discount = discount;
        this.category = category;
    }

    public String getisbn(){
        return this.isbn;
    }
    public String getTitle(){
        return this.title;
    }
    public Date getPubdate(){
        return this.pubdate;
    }
    public Publisher getPublisher(){
        return this.publishers;
    }
    public double getCost(){
        return this.cost;
    }
    public double getRetail(){
        return this.retail;
    }
    public double getDiscount(){
        return this.discount;
    }
    public String getCategory(){
        return this.category;
    }
    public String toString(){
        return "ISBN: "+this.isbn + ", Title: " + this.title + ", Pubdate: " + this.pubdate + ", " + this.publishers.toString() +
        ", Cost: $" + this.cost + ", Retail: $" + this.retail + ", Discount: $" + this.discount + ", Category: " + this.category;
    }
}

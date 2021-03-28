package com.book.storage.model;

import javax.persistence.*;

@Entity
@Table(name="books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String name;
    String author;
    String barcode;
    int quantity;
    int price;

    public Book() {
    }
    public Book(String name, String author, String barcode, int quantity, int price) {
        this.name = name;
        this.author = author;
        this.barcode = barcode;
        this.quantity = quantity;
        this.price = price;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }



//    name, author,
//    barcode, quantity, price per unit.

}

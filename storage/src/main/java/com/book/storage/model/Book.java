package com.book.storage.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name="books")
public class Book {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @NotEmpty(message = "The book must have a name.")
    String name;

    @NotEmpty(message = "The book must have an author.")
    String author;

    @NotEmpty(message = "The book must have a barcode.")
    String barcode;

    @NotNull(message = "The book must have quantity.")
    @Min(value=1, message = "The quantity must be more than 0.")
    int quantity;

    @NotNull(message = "The book must have a price.")
    @Min(value=0, message = "The price must be more than 0.")
    int price;

    @Max(value = 1900, message = "The release year must be no more than 1900")
    int releaseYear;

    @Max(value = 10,message = "The science index must be between 1-10")
    @Min(value = 0, message = "The science index must be between 1-10")
    int scienceIndex;

    double totalPrice;

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

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getScienceIndex() {
        return scienceIndex;
    }

    public void setScienceIndex(int scienceIndex) {
        this.scienceIndex = scienceIndex;
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

    public double getTotalPrice(){
        double n = 1;
        if(releaseYear!=0){
            n = (2021-releaseYear)/10;
        }else if(scienceIndex!=0){
            n = scienceIndex;
        }

        return  quantity*price*n;
    }
    public void setTotalPrice(){
        double n = 1;
        if(releaseYear!=0){
            n = (2021-releaseYear)/10;
        }else if(scienceIndex!=0){
            n = scienceIndex;
        }

        this.totalPrice =  quantity*price*n;
    }
}

package fa.orm.pratice.entities;


import org.hibernate.validator.constraints.ISBN;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Book {

    @Id
    @Column(name = "isbn", length = 250, nullable = false)
    @ISBN
    private String isbn;

//    @Min(value = 1950, message = "IllegalArgumentException")
//    @Max(value = 2021, message = "IllegalArgumentException")
    @Range(min = 1950, max = 2021)
    @Column(length = 10, nullable = false)
    private int year;

    @NotBlank
    @Column(nullable = false)
    private String title;

    @NotNull
    @Column(nullable = false, precision = 19, scale = 0)
    private double price;

    @NotNull(message = "author null pointer exception!!")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "name", referencedColumnName = "name"),
            @JoinColumn(name = "address", referencedColumnName = "address")
    })
    private Author author;

    @NotNull(message = "publisher null pointer exception!!")
    @ManyToOne
    @JoinColumn(name = "publisher_name", referencedColumnName = "publisher_name")
    private Publisher publisher;

    public Book() {

    }

    public Book(String isbn, int year, String title, double price, Author author, Publisher publisher) {
        this.isbn = isbn;
        this.year = year;
        this.title = title;
        this.price = price;
        this.author = author;
        this.publisher = publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}

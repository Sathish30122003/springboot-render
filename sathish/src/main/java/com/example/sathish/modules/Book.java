package com.example.sathish.modules;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.stereotype.Component;

@Component
@Document(collection = "book")
public class Book {
    @Id
    private String Isbn;  // Changed to String

    @Field
    private String Author;
    
    @Field
    private String Title;
    
    @Field
    private String Description;
    @Field
    private String drivelink;

    public Book() {}

    public Book(String isbn, String author, String title, String description,String drivelink) {
        this.Isbn = isbn;
        this.Author = author;
        this.Title = title;
        this.Description = description;
        this.drivelink=drivelink;
    }

    // Getters and setters
    public String getIsbn() {
        return Isbn;
    }

    public void setIsbn(String isbn) {
        this.Isbn = isbn;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        this.Author = author;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    @Override
    public String toString() {
        return String.format("Book[isbn='%s', author='%s', title='%s', description='%s',drivelink='%s']", Isbn, Author, Title, Description,drivelink);
    }

    public String getDrivelink() {
        return drivelink;
    }

    public void setDrivelink(String drivelink) {
        this.drivelink = drivelink;
    }
}

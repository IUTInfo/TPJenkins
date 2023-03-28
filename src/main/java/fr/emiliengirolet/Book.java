package fr.emiliengirolet;

import java.util.Date;

public class Book {
    private String title;
    private String author;
    private Date publishing;

    public Book(String title, String author, Date publishing) {
        setTitle(title);
        setAuthor(author);
        setPublishing(publishing);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null)
            throw new IllegalArgumentException("Title cannot be null.");

        if (title.trim().isEmpty())
            throw new IllegalArgumentException("Title cannot be empty.");

        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author == null)
            throw new IllegalArgumentException("Author cannot be null.");

        if (author.trim().isEmpty())
            throw new IllegalArgumentException("Author cannot be empty.");

        this.author = author;
    }

    public Date getPublishing() {
        return publishing;
    }

    public void setPublishing(Date publishing) {
        if (publishing == null)
            throw new IllegalArgumentException("Publishing date cannot be null.");

        this.publishing = publishing;
    }
}

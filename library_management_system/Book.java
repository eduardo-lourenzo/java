package library_management_system;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringJoiner;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        isAvailable = true;
    }

    public String showDetails() {
        return "Título: " + title + ", Autor: " + author + ", ISBN: " + isbn;
    }

    public StringBuilder bookToCSV() {
        StringBuilder bufferOfCSV = new StringBuilder();

        bufferOfCSV.append(title).append(";");
        bufferOfCSV.append(author).append(";");
        bufferOfCSV.append(isbn).append(";");
        bufferOfCSV.append(isAvailable).append(";");

        return bufferOfCSV;
    }

    public void csvToBook(String inputBook) {
        String[] buffer = inputBook.split(";");

        title = buffer[0];
        author = buffer[1];
        isbn = buffer[2];
        isAvailable = Boolean.parseBoolean(buffer[3]);
    }

    public void borrow() {
        isAvailable = false;
    }

    public void devolve() {
        isAvailable = true;
    }

    public boolean getAvailability() {
        return isAvailable;
    }

    @Override
    public boolean equals(Object anotherBook) {
        if (anotherBook == null || this.getClass() != anotherBook.getClass()) return false;
        Book newBook = (Book) anotherBook;
        return Objects.equals(this.isbn, newBook.isbn);
    }
}

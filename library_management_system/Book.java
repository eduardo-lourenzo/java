package library_management_system;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;
    }

    public String showDetails() {
        return "Título: " + title + ", Autor: " + author + ", ISBN: " + isbn;
    }

    public void borrow() {
        isAvailable = false;
    }

    public void devolve() {
        isAvailable = true;
    }
}

package library_management_system;

import java.util.ArrayList;

public class User {
    private String name;
    private int id;
    private ArrayList<Book> borrowedBooks = new ArrayList<Book>();

    public User(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String showDetails() {
        return  "Nome: " + name + ", ID: " + id;
    }

    public void addBook(Book book) {
        // Req = A user can borrow a maximum of 3 books at the same time.
        borrowedBooks.add(book);
    }

    public void removeBook(Book book) {
        // Override method equals( )
        int index = borrowedBooks.indexOf(book);
        if(index > -1) {
            borrowedBooks.remove(index);
        }
    }
}

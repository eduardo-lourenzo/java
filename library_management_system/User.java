package library_management_system;

import java.util.ArrayList;
import java.util.Objects;

public class User {
    private String name;
    private int id;
    private ArrayList<Book> borrowedBooks;

    public User(String name, int id) {
        this.name = name;
        this.id = id;
        this.borrowedBooks = new ArrayList<Book>();
    }

    public String showDetails() {
        return "Nome: " + name + ", ID: " + id;
    }

    public void addBook(Book book) {
        // Req = A user can borrow a maximum of 3 books at the same time.
        borrowedBooks.add(book);
    }

    public void removeBook(Book book) {
        int index = borrowedBooks.indexOf(book);
        if (index > -1) {
            borrowedBooks.remove(index);
        }
    }

    @Override
    public boolean equals(Object anotherUser) {
        if (anotherUser == null || getClass() != anotherUser.getClass()) return false;
        User newUser = (User) anotherUser;
        return id == newUser.id;
    }
}

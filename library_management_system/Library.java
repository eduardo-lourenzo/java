package library_management_system;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> listOfBooks;
    private ArrayList<User> listOfUsers;

    public Library() {
        this.listOfBooks = new ArrayList<Book>();
        this.listOfUsers = new ArrayList<User>();
    }

    public void registerBook(Book book) {
        this.listOfBooks.add(book);
    }

    public void registerUser(User user) {
        this.listOfUsers.add(user);
    }
}

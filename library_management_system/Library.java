package library_management_system;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> listOfBooks;
    private ArrayList<User> listOfUsers;

    public Library() {
        listOfBooks = new ArrayList<Book>();
        listOfUsers = new ArrayList<User>();
    }

    public void registerBook(Book book) {
        listOfBooks.add(book);
    }

    public void registerUser(User user) {
        listOfUsers.add(user);
    }
}

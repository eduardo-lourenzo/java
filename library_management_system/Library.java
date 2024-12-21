package library_management_system;

import java.util.ArrayList;

public class Library {
    ArrayList<Book> listOfBooks;
    ArrayList<User> listOfUsers;

    public Library() {
        this.listOfBooks = new ArrayList<Book>();
        this.listOfUsers = new ArrayList<User>();
    }

    public void setBook(Book book) {
        this.listOfBooks.add(book);
    }

    public void setUser(User user) {
        this.listOfUsers.add(user);
    }
}

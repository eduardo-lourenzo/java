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

    public StringBuilder borrowedBooksToCSV(){
        StringBuilder bufferOfCSV = new StringBuilder();
        for(Book book:borrowedBooks) {
            bufferOfCSV.append(book.bookToCSV()).append(";");
        }
        return bufferOfCSV;
    }

    public boolean addBook(Book book) {
        if (borrowedBooks.size() < 3) {
            borrowedBooks.add(book);
            return true;
        }
        System.out.println("Não é possível adicionar mais livros, " +
                "o usuário já possiu a quantidade máxima permitida.");
        return false;
    }

    public boolean removeBook(Book book) {
        int indexOfBook = borrowedBooks.indexOf(book);
        if (indexOfBook > -1) {
            borrowedBooks.remove(indexOfBook);
            System.out.println("Livro foi removido!");
            return true;
        }
        System.out.println("Livro não está na lista do usuário!");
        return false;
    }

    @Override
    public boolean equals(Object anotherUser) {
        if (anotherUser == null || getClass() != anotherUser.getClass()) return false;
        User newUser = (User) anotherUser;
        return id == newUser.id;
    }
}

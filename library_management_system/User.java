package library_management_system;

import java.util.ArrayList;

public class User {
    private final String name;
    private final int id;
    private final ArrayList<Book> borrowedBooks;

    public User(String name, int id) {
        this.name = name;
        this.id = id;
        this.borrowedBooks = new ArrayList<>();
    }

    public String showDetails() {
        return "Nome: " + name + ", ID: " + id;
    }

    public StringBuilder borrowedBooksToCSV() {
        StringBuilder bufferOfCSV = new StringBuilder();

        for (Book book : borrowedBooks) {
            bufferOfCSV.append(book.bookToCSV());
        }

        return bufferOfCSV;
    }

    public StringBuilder userToCSV() {
        StringBuilder bufferOfCSV = new StringBuilder();

        bufferOfCSV.append(name).append(";").append(id).append(";");
        bufferOfCSV.append(borrowedBooksToCSV());

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

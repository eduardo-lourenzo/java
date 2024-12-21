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

    public void realizeBorrow(String isbn, int idUser) {
        int indexOfBook = listOfBooks.indexOf(new Book("", "", isbn));

        if (indexOfBook > -1) {
            Book chosenBook = listOfBooks.get(indexOfBook);
            if (chosenBook.getAvailability()) {

                int indexOfUser = listOfUsers.indexOf(new User("", idUser));
                if (indexOfUser > -1) {
                    if (listOfUsers.get(indexOfUser).addBook(chosenBook)) {
                        System.out.println("Livro alugado com sucesso!");
                        chosenBook.borrow();
                    }
                } else {
                    System.out.println("Usuário não encontrado!");
                }
            } else {
                System.out.println("O livro já está alugado!");
            }
        } else {
            System.out.println("O livro não foi encontrado!");
        }
    }

    public void showAvailableBooks() {
        System.out.println("Livros disponíveis:");
        listOfBooks.stream().filter(Book::getAvailability).forEach(book -> System.out.println(book.showDetails()));
    }
}

package library_management_system;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Library {
    private ArrayList<Book> listOfBooks;
    private ArrayList<User> listOfUsers;

    public Library() {
        listOfBooks = new ArrayList<Book>();
        listOfUsers = new ArrayList<User>();

        loadBooks();
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
                        System.out.println("Empréstimo realizado com sucesso!");
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

    public void realizeDevolution(String isbn, int idUser) {
        int indexOfUser = listOfUsers.indexOf(new User("", idUser));

        if (indexOfUser > -1) {
            User chosenUser = listOfUsers.get(indexOfUser);
            Book chosenBook = new Book("", "", isbn);
            int indexOfBook = listOfBooks.indexOf(chosenBook);
            if (indexOfBook > -1) {
                if (chosenUser.removeBook(chosenBook)) {
                    System.out.println("livro devolvido com sucesso!");
                    listOfBooks.get(indexOfBook).devolve();
                }
            } else {
                System.out.println("Livro não cadastado!");
            }
        } else {
            System.out.println("Usuário não encontrado!");
        }
    }

    public void showAvailableBooks() {
        System.out.println("Livros disponíveis:");
        listOfBooks.stream().filter(Book::getAvailability).forEach(book -> System.out.println(book.showDetails()));
    }

    public void saveUsers() {
        try {
            File usersFile = new File(".\\library_management_system\\users.csv");
            FileWriter fileReader = new FileWriter(usersFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileReader);

            for (User user : listOfUsers) {
                bufferedWriter.write(user.userToCSV() + "\n");
            }

            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println("Não foi possível salvar os usuários!");
        }
    }

    public void saveBooks() {
        try {
            File booksFile = new File(".\\library_management_system\\books.csv");
            FileWriter fileReader = new FileWriter(booksFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileReader);

            for (Book book : listOfBooks) {
                bufferedWriter.write(book.bookToCSV() + "\n");
            }

            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println("Não foi possível salvar os livros!");
        }
    }

    public void loadBooks() {
        try {
            File booksFile = new File(".\\library_management_system\\books.csv");
            FileReader fileReader = new FileReader(booksFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String inputBook;
            Book newBook;

            while ((inputBook = bufferedReader.readLine()) != null) {

                newBook = new Book("", "", "");
                newBook.csvToBook(inputBook);
                listOfBooks.add(newBook);
            }

            bufferedReader.close();
        } catch (Exception e) {
            System.out.println("Não foi possível carregar os livros!");
        }
    }
}

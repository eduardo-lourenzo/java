package library_management_system;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int option;
        int idUser;
        String title;
        String author;
        String isbn;
        String name;
        User userTemporary;
        Book bookTemporary;
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Sistema de Gerenciamento de Biblioteca!");

        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Cadastrar livro.");
            System.out.println("2. Cadastrar usuário.");
            System.out.println("3. Realizar empréstimo.");
            System.out.println("4. Realizar devolução.");
            System.out.println("5. Exibir livros disponíveis");
            System.out.println("6. Sair");

            option = scanner.nextInt();

            switch (option) {
                case 1: {
                    System.out.println("Quais as as informações do livro?");
                    System.out.print("Digite o título do livro: ");
                    title = scanner.nextLine();
                    System.out.print("Digite o autor do livro: ");
                    author = scanner.nextLine();
                    System.out.print("Digite o ISBN do livro: ");
                    isbn = scanner.nextLine();

                    bookTemporary = new Book(title, author, isbn);
                    library.registerBook(bookTemporary);

                    break;
                }
                case 2: {
                    System.out.println("Quais as informações do usuário?");
                    System.out.print("Digite o nome do usuário: ");
                    name = scanner.nextLine();
                    System.out.print("Digite o ID do usuário: ");
                    idUser = scanner.nextInt();

                    userTemporary = new User(name, idUser);
                    library.registerUser(userTemporary);

                    break;
                }
                case 3: {
                    System.out.println("Quais as informações do Emprestimo?");
                    System.out.print("Digite o ISBN do livro: ");
                    isbn = scanner.nextLine();
                    System.out.print("Digite o ID do usuário: ");
                    idUser = scanner.nextInt();

                    library.realizeBorrow(isbn, idUser);

                    break;
                }
                case 4: {
                    System.out.println("Quais as informações do Emprestimo?");
                    System.out.print("Digite o ISBN do livro: ");
                    isbn = scanner.nextLine();
                    System.out.print("Digite o ID do usuário: ");
                    idUser = scanner.nextInt();

                    library.realizeDevolution(isbn, idUser);

                    break;
                }
                case 5: {
                    library.showAvailableBooks();

                    break;
                }
            }
        } while (option != 6);

        scanner.close();
        System.out.println("Encerrando o Sistema de Gerenciamento de Biblioteca!");
    }
}

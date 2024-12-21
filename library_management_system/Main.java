package library_management_system;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int option;
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

        }while(option != 6);


        scanner.close();
    }
}

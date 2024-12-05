package java_basico;

import java.util.Scanner;

public class Fatorial {
    public static void main(String[] args) {
        int number;
        long factorial = 1L;
        Scanner inputReader = new Scanner(System.in);

        System.out.print("Digite um número: ");
        number = inputReader.nextInt();
        inputReader.close();

        while (number > 1) {
            factorial *= number;
            number--;
        }

        System.out.println(factorial);
    }
}

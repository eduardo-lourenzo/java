package java_basico;

import java.util.Scanner;

public class SomaDeNumeros {
    public static void main(String[] args) {
        int number;
        int summation = 0;
        Scanner inputReader = new Scanner(System.in);

        System.out.print("Digite um número: ");
        number = inputReader.nextInt();
        inputReader.close();

        // ((number + 1) * number)/2 
        for (int index = 1; index <= number; index++) {
            summation += index;
        }

        System.out.println(summation);
    }
}

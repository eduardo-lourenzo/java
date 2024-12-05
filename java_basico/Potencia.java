package java_basico;

import java.util.Scanner;

public class Potencia {
    public static void main(String[] args) {
        int base;
        int exponent;
        long result = 1L;
        Scanner inputReader = new Scanner(System.in);

        System.out.print("Digite a base: ");
        base = inputReader.nextInt();

        System.out.print("Digite o expoente: ");
        exponent = inputReader.nextInt();

        inputReader.close();

        for (int index = 0; index < exponent; index++) {
            result *= base;
        }

        System.out.println(result);
    }
}

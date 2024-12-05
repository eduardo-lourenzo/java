package java_basico;

import java.util.Scanner;

public class NumerosPrimos {
    public static void main(String[] args) {
        int number;
        boolean isPrime = true;
        double squareRoot;
        Scanner inputReader = new Scanner(System.in);

        System.out.print("Digite um número: ");
        number = inputReader.nextInt();
        inputReader.close();

        if (number <= 1) {
            isPrime = false;
        } else if (number == 2) {
            isPrime = true;
        } else if(number % 2 == 0) {
            isPrime = false;
        } else {
            squareRoot = Math.sqrt(number);
            for (int index = 3; index <= squareRoot; index += 2) {
                if(number % index == 0) {
                    isPrime = false;
                    break;
                }
            }
        }
        System.out.println(isPrime);
    }
}

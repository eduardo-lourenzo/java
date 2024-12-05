package java_basico;

import java.util.Scanner;

public class MultiplosDeUmNumero {
    public static void main(String[] args) {
        int number;
        int limit;
        int steps;
        Scanner inputReader = new Scanner(System.in);

        System.out.print("Digite o valor de n: ");
        number = inputReader.nextInt();

        System.out.print("Digite o valor de m: ");
        limit = inputReader.nextInt();

        inputReader.close();

        steps = (int)(limit/number);
        for (int index = 1; index <= steps; index++) {
            System.out.print(number * index + ", ");           
        }

    }
}

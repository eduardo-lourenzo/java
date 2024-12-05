package java_basico;

import java.util.Scanner;

public class SerieDeFibonacci {
    public static void main(String[] args) {
        int number;
        int previous = 0;
        int current = 1;
        int next;
        Scanner inputReader = new Scanner(System.in);
    
        System.out.print("Digite um número: ");
        number = inputReader.nextInt();
        inputReader.close();

        System.out.print("0, 1, ");
        for (int index = 2; index < number; index++) {
            next = previous + current;
            System.out.print(next + ", ");
            previous = current;
            current = next;
        }
    }
}

package java_basico;

import java.util.Scanner;

public class ContagemDeDigitos {
    public static void main(String[] args) {
        Integer number;
        String word;
        Scanner inputReader = new Scanner(System.in);

        System.out.print("Digite um número: ");
        number = inputReader.nextInt();
        inputReader.close();

        if(number < 0) {
            number *= -1;
        }

        word = number.toString();

        System.out.println(word.length());
    }
}
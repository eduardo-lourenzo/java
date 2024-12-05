package java_basico;

import java.util.Scanner;

public class InversaoDeNumero {
    public static void main(String[] args) {
        Integer number;
        String symbol = "";
        String originalWord;
        String invetedWord = "";
        Scanner inputReader = new Scanner(System.in);

        System.out.print("Digite um número: ");
        number = inputReader.nextInt();
        inputReader.close();

        if(number < 0) {
            symbol = "-";
            number *= -1;
        }

        originalWord = number.toString();

        invetedWord += symbol;
        for (int index = originalWord.length() - 1 ; index >= 0; index--) {
            invetedWord += originalWord.charAt(index);
        }

        System.out.println(invetedWord);
    }
}

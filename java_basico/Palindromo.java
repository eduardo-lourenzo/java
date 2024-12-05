package java_basico;

import java.util.Scanner;

public class Palindromo {
    public static void main(String[] args) {
        boolean isPalindrome = true;
        Integer number;
        String word;
        Scanner inputReader = new Scanner(System.in);

        System.out.print("Digite um número: ");
        number = inputReader.nextInt();
        inputReader.close();

        word = number.toString();

        for (int left = 0, right = word.length() - 1; left <= right; left++, right--) {
            if(word.charAt(left) != word.charAt(right)) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println(isPalindrome);
    }
}

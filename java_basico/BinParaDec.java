package java_basico;

import java.util.Scanner;

public class BinParaDec {
    public static void main(String[] args) {
        int decimal = 0;
        int range;
        String binary;
        Scanner inputReader = new Scanner(System.in);

        System.out.print("Digite um número binário: ");
        binary = inputReader.next();
        inputReader.close();

        range = binary.length() - 1;
        for (int index = range; index >= 0; index--) {
            if(binary.charAt(index) == '1') {
                decimal += Math.pow(2, range - index);
            }            
        }

        System.out.println(decimal);
    }
}

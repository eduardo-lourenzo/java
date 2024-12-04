import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {
        boolean repeat = true;
        boolean remain = true;
        char operator = 'Z';
        short option = 1;
        double leftHandSide = 0.0d;
        double rightHandSide = 0.0d;
        double result = 0.0d;
        String inputBuffer = "";
        Scanner inputReader = new Scanner(System.in);

        while (remain) {
            do {
                System.out.println("\n===========================");
                System.out.println("Escolha o caracter da operação:");
                System.out.println("A: adição.");
                System.out.println("S: subtração.");
                System.out.println("M: multiplicação.");
                System.out.println("D: divisão.");
                System.out.println("0: sair.");

                inputBuffer = inputReader.next();

                if (inputBuffer.length() > 1) {
                    repeat = true;
                    System.out.println("Digite somente uma caracter.");
                    continue;
                }

                operator = inputBuffer.toUpperCase().charAt(0);

                if (operator == '0') {
                    System.out.println("Saindo...");
                    System.exit(0);
                }

                if (operator == 'A' || operator == 'S' || operator == 'M' || operator == 'D') {
                    repeat = false;
                } else {
                    repeat = true;
                    System.out.println("Operação inválida");
                }
            } while (repeat);

            System.out.print("Digite o primeiro número: ");
            leftHandSide = inputReader.nextDouble();

            System.out.print("Digite o segundo número: ");
            rightHandSide = inputReader.nextDouble();

            while (operator == 'D' && rightHandSide == 0.0d) {
                System.out.print("Não é possível dividir por zero.\nDigite outro número: ");
                rightHandSide = inputReader.nextDouble();
            }

            switch (operator) {
                case 'A': {
                    result = leftHandSide + rightHandSide;
                    operator = '+';
                    break;
                }
                case 'S': {
                    result = leftHandSide - rightHandSide;
                    operator = '-';
                    break;
                }
                case 'M': {
                    result = leftHandSide * rightHandSide;
                    operator = 'x';
                    break;
                }
                case 'D': {
                    result = leftHandSide / rightHandSide;
                    operator = '/';
                    break;
                }
            }

            System.out.println(leftHandSide + " " + operator + " " + rightHandSide + " = " + result);
            
            System.out.println("\n================");
            do {
                
                System.out.println("Deseja continuar?");
                System.out.println("1: Sim ou 0: Não");
                option = inputReader.nextShort();
            } while (option != 0 && option != 1);

            if (option == 1) {
                remain = true;
            } else {
                remain = false;
            }

        }
        inputReader.close();
        System.out.println("Fim da calculadora!");
    }
}
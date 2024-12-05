import java.util.Scanner;

public class Bonus09Dez {
    public static void main(String[] args) {
        int currentYear = 2024;
        int yearOfBirth;
        int age;
        String name;
        Scanner inputReader = new Scanner(System.in);

        System.out.print("Digite seu nome: ");
        name = inputReader.nextLine();

        System.out.print("Digite o ano do seu nascimento: ");
        yearOfBirth = inputReader.nextInt();

        inputReader.close();

        age = currentYear - yearOfBirth;
        System.out.println(name + " tem " + age + " anos.");
    }
}

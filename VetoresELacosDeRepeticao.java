public class VetoresELacosDeRepeticao {
    public static void main(String[] args) {
        int index;
        int[] primeNumber = {2, 3, 5, 7, 11};

        System.out.println("Laço For:");
        for (index = 0; index < primeNumber.length; index++) {
            System.out.print(primeNumber[index] + " ");
        }
        System.out.println('\n');
        System.out.println("Laço While:");
        index = 0;
        while (index < primeNumber.length) {
            System.out.print(primeNumber[index] + " ");
            index++;
        }

        System.out.println('\n');
        System.out.println("Laço Do-While:");
        index = 0;
        do {
            System.out.print(primeNumber[index] + " ");
            index++;
        } while (index < primeNumber.length);
    }
}

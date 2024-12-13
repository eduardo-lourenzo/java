package desafios;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

/* 
* [X] [ReqMed01] - Criar várias rodadas.
* [X] [ReqMed02] - Acumular a pontuação das rodadas.
* [X] [ReqMed03] - Perguntar se continua.
* [ ] [ReqMax01] - Adicionar níveis de dificuldade.
* [ ] [ReqMax01a] -- Fácil: Números entre 1 e 10.
* [ ] [ReqMax01b] -- Médio: Números entre 1 e 50.
* [ ] [ReqMax01c] -- Difícil: Números entre 1 e 100.
* [ ] [ReqMax02] - Exibir pontuação acumulada das rodadas.
* [ ] [ReqMax02a] -- Exibir lista com os acertos.
* [ ] [ReqMax02b] -- Exibir lista com os erros.
*/

public class JogoDoAdivinha {
    static final int LIMITE_FACIL = 10;
    static final int LIMITE_MEDIO = 50;
    static final int LIMITE_DIFICIL = 100;

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean continuarRodada = true;
        int numeroDoSorteio;
        int numeroDoPalpite;
        int pontuacaoDaRodada;
        int pontuacaoDoJogo = 0;
        int diferencaAbsoluta;

        imprimirBoaVinda();
        while (continuarRodada) {
            numeroDoSorteio = obterNumeroAleatorio(LIMITE_FACIL);

            // [fix] Capturar excessão se não for um inteiro.
            System.out.print("Qual o numero do seu palpite? ");
            numeroDoPalpite = scanner.nextInt();

            while (numeroDoPalpite < 1 || numeroDoPalpite > LIMITE_FACIL) {
                System.out.println("O palpite está fora da faixa de valores!");
                System.out.print("Digite um número entre 1 e " + LIMITE_FACIL + ": ");
                numeroDoPalpite = scanner.nextInt();
            }

            // [feat] - Criar função que retorna a pontuação.
            diferencaAbsoluta = Math.abs(numeroDoSorteio - numeroDoPalpite);
            if (diferencaAbsoluta == 0) {
                pontuacaoDaRodada = 10;
            } else if (diferencaAbsoluta == 1) {
                pontuacaoDaRodada = 5;
            } else {
                pontuacaoDaRodada = 0;
            }

            pontuacaoDoJogo += pontuacaoDaRodada;

            System.out.println("Sorteado = " + numeroDoSorteio + " : " + numeroDoPalpite + " = Palpite");
            System.out.println("Pontuação da rodada = " + pontuacaoDaRodada + ".");

            continuarRodada = continuarJogando();
        }
        scanner.close();

        System.out.println("Pontuação do jogo: " + pontuacaoDoJogo);
        imprimirDespedida();
    }

    public static void imprimirBoaVinda() {
        System.out.println("============================");
        System.out.println("Bem-vindo ao Jogo do Adivinha");
        System.out.println("============================");
    }

    public static void imprimirDespedida() {
        System.out.println("=============================");
        System.out.println("Encerrando o Jogo do Adivinha");
        System.out.println("=============================");
    }

    public static boolean continuarJogando() {
        boolean travado = true;
        boolean opcaoBooleana = false;
        int opcaoInteira;
        

        do {
            try {
                System.out.println("_________________________");
                System.out.println("Deseja continuar jogando?");
                System.out.print("0 = Não | 1 = Sim: ");
                opcaoInteira = scanner.nextInt();

                if (opcaoInteira == 0) {
                    opcaoBooleana = false;
                    travado = false;
                } else if (opcaoInteira == 1) {
                    opcaoBooleana = true;
                    travado = false;
                } else {
                    throw new InputMismatchException();
                } 
            } catch (Exception e) {
                // TO-DO: handle exception
                System.err.println("A entrada é inválida!");
                scanner.nextLine();
                travado = true;
            }
        } while (travado);

        return opcaoBooleana;
    }

    public static int obterNumeroAleatorio(int limiteMaximo) {
        System.out.println("___________________");
        System.out.println("Sorteando número...");

        return new Random().nextInt(limiteMaximo) + 1;
    }
}

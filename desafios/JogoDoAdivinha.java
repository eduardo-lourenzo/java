package desafios;

import java.util.Scanner;
import java.util.Random;

/* 
* [X] [ReqMed01] - Criar várias rodadas.
* [X] [ReqMed02] - Acumular a pontuação das rodadas.
* [ ] [ReqMed03] - Perguntar se continua.
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

    public static void main(String[] args) {
        boolean continuarJogando = true;
        int numeroSorteado;
        int numeroDoPalpite;
        int pontuacaoDaRodada;
        int pontuacaoDoJogo = 0;
        int diferencaAbsoluta;
        Scanner scanner = new Scanner(System.in);

        while (continuarJogando) {
            System.out.println("___________________");
            System.out.println("Sorteando número...");
            numeroSorteado = obterNumeroAleatorio(LIMITE_FACIL);

            // [fix] Capturar excessão se não for um inteiro.
            System.out.print("Qual o numero do seu palpite? ");
            numeroDoPalpite = scanner.nextInt();

            while (numeroDoPalpite < 1 || numeroDoPalpite > LIMITE_FACIL) {
                System.out.println("O palpite está fora da faixa de valores!");
                System.out.print("Digite um número entre 1 e " + LIMITE_FACIL + ": ");
                numeroDoPalpite = scanner.nextInt();
            }

            // [feat] - Criar função que retorna a pontuação.
            diferencaAbsoluta = Math.abs(numeroSorteado - numeroDoPalpite);
            if (diferencaAbsoluta == 0) {
                pontuacaoDaRodada = 10;
            } else if (diferencaAbsoluta == 1) {
                pontuacaoDaRodada = 5;
            } else {
                pontuacaoDaRodada = 0;
            }

            pontuacaoDoJogo += pontuacaoDaRodada;

            System.out.println("Sorteado = " + numeroSorteado + " : " + numeroDoPalpite + " = Palpite");
            System.out.println("Pontuação da rodada = " + pontuacaoDaRodada + ".");

            // [fix] - Tratar entrada do usuário.
            // [feat] - Cirar função que retorna um booleano.
            System.out.println("Deseja continuar jogando?");
            System.out.print("0 = Não | 1 = Sim: ");
            continuarJogando = (scanner.nextInt() == 0) ? false : true;
        }
        scanner.close();

        System.out.println("Pontuação do jogo: " + pontuacaoDoJogo);
    }

    public static int obterNumeroAleatorio(int limiteMaximo) {
        return new Random().nextInt(limiteMaximo) + 1;
    }
}

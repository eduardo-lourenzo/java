package desafios;

import java.util.Random;
import java.util.Scanner;

/* 
* [X] [ReqMin01] - Sortear número aleatório dentro de um intervalo.
* [X] [ReqMin02] - Obter palpite do jogador.
* [ ] [ReqMin02a] -- Acerto = 10 pontos.
* [ ] [ReqMin02b] -- 1 unidade de distãocia = 5 pontos.
* [ ] [ReqMin02c] -- Erro = 0 pontos.
* [ ] [ReqMin03] - Exibir pontuação ao final da rodada.
* [ ] [ReqMed01] - Criar várias rodadas.
* [ ] [ReqMed02] - Acumular a pontuação das rodadas.
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
        int numeroSorteado;
        int numeroEscolhido;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Sorteando número.");
        numeroSorteado = obterNumeroAleatorio(LIMITE_FACIL);

        //[ ] [Test] - verificar se o número digitado está na faixa de valores válido.
        System.out.print("Qual o numero do seu palpite? ");
        numeroEscolhido = scanner.nextInt();

        while (numeroEscolhido < 0 || numeroEscolhido > LIMITE_FACIL) {
            System.out.println("O palpite está fora da faixa de valores!");
            System.out.println("Digite um número entre 0 e " + LIMITE_FACIL + ".");
            numeroEscolhido = scanner.nextInt();
        }

        System.out.println("Sorteado = " + numeroSorteado + " : " + numeroEscolhido + " = Palpite");

        scanner.close();
    }

    public static int obterNumeroAleatorio(int limiteMaximo) {
        return new Random().nextInt(limiteMaximo + 1);
    }
}

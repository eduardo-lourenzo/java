package desafios;

import java.util.Random;
import java.util.Scanner;

/* 
* [X] [ReqMin01] - Sortear número aleatório dentro de um intervalo.
* [X] [ReqMin02] - Obter palpite do jogador.
* [X] [ReqMin02a] -- Acerto = 10 pontos.
* [X] [ReqMin02b] -- 1 unidade de distãocia = 5 pontos.
* [X] [ReqMin02c] -- Erro = 0 pontos.
* [X] [ReqMin03] - Exibir pontuação ao final da rodada.
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
        int numeroDoPalpite;
        int pontuaçãoDaRodada;
        int diferencaAbsoluta;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Sorteando número.");
        numeroSorteado = obterNumeroAleatorio(LIMITE_FACIL);

        System.out.print("Qual o numero do seu palpite? ");
        numeroDoPalpite = scanner.nextInt();

        while (numeroDoPalpite < 0 || numeroDoPalpite > LIMITE_FACIL) {
            System.out.println("O palpite está fora da faixa de valores!");
            System.out.print("Digite um número entre 0 e " + LIMITE_FACIL + ": ");
            numeroDoPalpite = scanner.nextInt();
        }

        diferencaAbsoluta = Math.abs(numeroSorteado - numeroDoPalpite);
        if (diferencaAbsoluta == 0) {
            pontuaçãoDaRodada = 10;
        }else if (diferencaAbsoluta == 1) {
            pontuaçãoDaRodada = 5;
        } else {
            pontuaçãoDaRodada = 0;
        }

        System.out.println("Pontuação da rodada = " + pontuaçãoDaRodada + ".");
        System.out.println("Sorteado = " + numeroSorteado + " : " + numeroDoPalpite + " = Palpite");

        scanner.close();
    }

    public static int obterNumeroAleatorio(int limiteMaximo) {
        //[ ] [Bug] - Corrigir faixa de valores.
        return new Random().nextInt(limiteMaximo + 1);
    }
}

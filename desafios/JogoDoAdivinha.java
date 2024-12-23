package desafios;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;

/* 
* Created on : 12-12-2024
* Author     : Eduardo Cardoso Lourenzo
*/

public class JogoDoAdivinha {
    static final int LIMITE_FACIL = 10;
    static final int LIMITE_MEDIO = 50;
    static final int LIMITE_DIFICIL = 100;

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean continuarRodada;
        int numeroDoLimitePorNivel;
        int numeroDoSorteio;
        int numeroDoPalpite;
        int pontuacaoDaRodada;
        int pontuacaoDoJogo = 0;
        List<Integer> listaDeAcertos = new ArrayList<Integer>();
        List<Integer> listaDeErros = new ArrayList<Integer>();

        imprimirBoaVinda();

        numeroDoLimitePorNivel = obterLimitePorNivel();

        do {
            numeroDoSorteio = obterNumeroAleatorio(numeroDoLimitePorNivel);
            numeroDoPalpite = obterPalpite(numeroDoLimitePorNivel);
            pontuacaoDaRodada = obterPontuacao(numeroDoSorteio, numeroDoPalpite);

            pontuacaoDoJogo += pontuacaoDaRodada;
            if (pontuacaoDaRodada == 10) {
                listaDeAcertos.add(numeroDoPalpite);
            } else {
                listaDeErros.add(numeroDoPalpite);
            }

            System.out.println("Sorteado = " + numeroDoSorteio + " : " + numeroDoPalpite + " = Palpite");
            System.out.println("Pontuação da rodada = " + pontuacaoDaRodada + ".");
            System.out.println("Pontuação do  jogo  = " + pontuacaoDoJogo + ".");

            continuarRodada = continuarJogando();
        }while (continuarRodada);
        scanner.close();

        imprimirResultado(pontuacaoDoJogo, listaDeAcertos, listaDeErros);
        imprimirDespedida();
    }

    public static enum NivelDeDificuldade {
        FACIL("Fácil", 10),
        MEDIO("Médio", 50),
        DIFICIL("Difícil", 100);

        private final int valor;
        private final String descricao;

        NivelDeDificuldade(String descricao, int valor) {
            this.descricao = descricao;
            this.valor = valor;
        }

        public String obterDescricao() {
            return descricao;
        }

        public int obterValor() {
            return valor;
        }
    }

    public static void imprimirBoaVinda() {
        System.out.println("============================");
        System.out.println("Bem-vindo ao Jogo do Adivinha.");
        System.out.println("============================");
    }

    public static void imprimirDespedida() {
        System.out.println("=============================");
        System.out.println("Encerrando o Jogo do Adivinha.");
        System.out.println("=============================");
    }
   
    public static void imprimirNiveis() {
        System.out.println("_________________");
        System.out.println("Digite o número do Nível desejado:");
        
        for (NivelDeDificuldade nivel: NivelDeDificuldade.values()) {
            System.err.print(nivel.ordinal() + " = " + nivel.descricao + " | ");
        }
        System.out.print(" : ");
    }

    public static void imprimirResultado(int pontuacaoFinal, List<Integer> listaDeAcertos, List<Integer> listaDeErros) {
        System.out.println("_____________________");
        System.out.println("Pontuação Final = " + pontuacaoFinal);
        System.out.println("Acertos = " + listaDeAcertos);
        System.out.println(" Erros  = " + listaDeErros);
    }
    
    public static boolean continuarJogando() {
        boolean travado;
        boolean opcaoBooleana = false;
        int opcaoInteira;

        do {
            try {
                System.out.println("_________________________");
                System.out.println("Deseja continuar jogando?");
                System.out.print("0 = Não | 1 = Sim : ");
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
                System.err.println("A entrada é inválida!");
                scanner.nextLine();
                travado = true;
            }
        } while (travado);

        return opcaoBooleana;
    }

    public static int obterPalpite(int limiteMaximo) {
        boolean travado;
        int numeroEscolhido = 0;

        do {
            try {
                System.out.print("Digite um número entre 1 e " + limiteMaximo + " : ");
                numeroEscolhido = scanner.nextInt();

                if (numeroEscolhido < 1 || numeroEscolhido > limiteMaximo) {
                    throw new InputMismatchException();
                }

                travado = false;

            } catch (Exception e) {
                System.out.println("O palpite está fora da faixa de valores!");
                scanner.nextLine();
                travado = true;
            }
        } while (travado);

        return numeroEscolhido;
    }

    public static int obterNumeroAleatorio(int limiteMaximo) {
        System.out.println("___________________");
        System.out.println("Sorteando número...");

        return new Random().nextInt(limiteMaximo) + 1;
    }

    public static int obterPontuacao(int numeroEsquerdo, int numeroDireito) {
        int diferencaAbsoluta = Math.abs(numeroEsquerdo - numeroDireito);

        if (diferencaAbsoluta == 0) {
            return 10;
        } else if (diferencaAbsoluta == 1) {
            return 5;
        } else {
            return 0;
        }
    }

    public static int obterLimitePorNivel() {
        boolean travado;
        int numeroEscolhido = 0;

        do {
            try {
                imprimirNiveis();
                numeroEscolhido = scanner.nextInt();

                if (numeroEscolhido < 0 || numeroEscolhido >= NivelDeDificuldade.values().length) {
                    throw new InputMismatchException();  
                }

                travado = false;

            } catch (Exception e) {
                System.out.println("O Nível está fora da faixa de valores!");
                scanner.nextLine();
                travado = true;
            }
        } while (travado);

        return NivelDeDificuldade.values()[numeroEscolhido].obterValor();
    }
}

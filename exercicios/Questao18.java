import java.util.Scanner;

public class Questao18 {
    public static void main(String[] args) {
    int[] jogadores = new int[23];
        Scanner sc = new Scanner(System.in);
    int intermediario = 0;
    int totalVotos = 0;
    int melhorJogador = -1;
    int votosMelhor = 0;
        System.out.println("Quem foi o melhor jogador?");
        while (true) {
            System.out.print("Número do jogador (0=fim): ");
            intermediario = sc.nextInt();
            if (intermediario == 0) {
                break;
            } else if (intermediario >= 1 && intermediario <= 23) {
                jogadores[intermediario - 1]++;
                totalVotos++;
            } else {
                System.out.println("Informe um valor entre 1 e 23 ou 0 para sair!");
            }
        }

        System.out.println("\nResultado da votação:\n");
        System.out.println("Foram computados " + totalVotos + " votos.");
        System.out.println("Jogador   Votos   %");
        for (int i = 0; i < jogadores.length; i++) {
            if (jogadores[i] > 0) {
                double percentual = calcularPercentual(jogadores[i], totalVotos);
                System.out.printf("%2d %10d %6.1f%%\n", (i + 1), jogadores[i], percentual);
                if (jogadores[i] > votosMelhor) {
                    votosMelhor = jogadores[i];
                    melhorJogador = i + 1;
                }
            }
        }

        if (melhorJogador != -1) {
            double percentualMelhor = calcularPercentual(votosMelhor, totalVotos);
            System.out.printf("\nO melhor jogador foi o número %d, com %d votos, correspondendo a %.1f%% do total de votos.\n",
                melhorJogador, votosMelhor, percentualMelhor);
        }
    public static double calcularPercentual(int votosJogador, int totalVotos) {
        if (totalVotos == 0) return 0.0;
        return ((double) votosJogador / totalVotos) * 100.0;
    }
    }

}
/*
 * 18. Uma grande emissora de televisão quer fazer uma enquete entre os seus
 * telespectadores para saber qual o melhor jogador após cada jogo. Para isto,
 * faz-se necessário o desenvolvimento de um programa em Java, que será
 * utilizado pelas telefonistas, para a computação dos votos. Sua equipe foi
 * contratada para desenvolver este programa, utilizando a linguagem de
 * programação Java. Para computar cada voto, a telefonista digitará um número,
 * entre 1 e 23, correspondente ao número da camisa do jogador. Um número de
 * jogador igual a zero, indica que a votação foi encerrada. Se um número
 * inválido for digitado, o programa deve ignorá-lo, mostrando uma breve
 * mensagem de aviso, e voltando a pedir outro número. Após o final da votação,
 * o programa deverá exibir:
 * O total de votos computados; Os números e respectivos votos de todos os
 * jogadores que receberam votos; O percentual de votos de cada um destes
 * jogadores; O número do jogador escolhido como o melhor jogador da partida,
 * juntamente com o número de votos e o percentual de votos dados a ele.
 * Observe que os votos inválidos e o zero final não devem ser computados como
 * votos. O resultado aparece ordenado pelo número do jogador. O programa deve
 * fazer uso de arrays. O programa deverá executar o cálculo do percentual de
 * cada jogador através de uma função. Esta função receberá dois parâmetros: o
 * número de votos de um jogador e o total de votos. A função calculará o
 * percentual e retornará o valor calculado. Abaixo segue uma tela de exemplo. O
 * disposição das informações deve ser o mais próxima possível ao exemplo. Os
 * dados são fictícios e podem mudar a cada execução do programa. Ao final, o
 * programa deve ainda gravar os dados referentes ao resultado da votação em um
 * arquivo texto no disco, obedecendo a mesma disposição apresentada na tela.
 * Enquete:
 * Quem foi o melhor jogador?
 * Número do jogador (0=fim): 9
 * Número do jogador (0=fim): 10
 * Número do jogador (0=fim): 9
 * Número do jogador (0=fim): 10
 * Número do jogador (0=fim): 11
 * Número do jogador (0=fim): 10
 * Número do jogador (0=fim): 50
 * Informe um valor entre 1 e 23 ou 0 para sair!
 * Número do jogador (0=fim): 9
 * Número do jogador (0=fim): 9
 * Número do jogador (0=fim): 0
 * 
 * Resultado da votação:
 * 
 * Foram computados 8 votos.
 * Jogador Votos %
 * 9 4 50,0%
 * 10 3 37,5%
 * 11 1 12,5%
 * 
 * O melhor jogador foi o número 9, com 4 votos, correspondendo a 50% do total
 * de votos.
 * 
 * 10% 1000= 10/1000*100
 */
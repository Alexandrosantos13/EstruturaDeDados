import java.util.ArrayList;
import java.util.Scanner;

public class Questão22 {
    public static void main(String[] args) {
        Double mouses = 0.0;
        ArrayList<String> problemas = new ArrayList<>();
        ArrayList<Double> quantidade = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        for (int i = 0; true; i++) {
            String temp;
            System.out.println("Digite o problema do mouse (digite Sair para parar o programa");
            temp = sc.nextLine();
            if (temp.equalsIgnoreCase("sair") == true) {
                break;
            } else {
                problemas.add(temp);
                System.out.println("Qual a quantidade de mouses com o problema");
                quantidade.add(sc.nextDouble());
                mouses = mouses + quantidade.get(i);
                sc.nextLine();
            }

        }

        System.out.println("\nQuantidade de mouses: " + mouses);
        System.out.printf("%-30s %-15s %-10s\n", "Situação", "Quantidade", "Percentual");
        for (int i = 0; i < quantidade.size(); i++) {
            double percentualatual = quantidade.get(i) / mouses * 100;
            System.out.printf("%d- %-27s %-15.0f %-9.1f%%\n", (i + 1), problemas.get(i), quantidade.get(i),
                    percentualatual);
        }
    }
}
/*
 * Sua organização acaba de contratar um estagiário para trabalhar no Suporte de
 * Informática, com a intenção de fazer um levantamento nas sucatas encontradas
 * nesta área. A primeira tarefa dele é testar todos os cerca de 200 mouses que
 * se encontram lá, testando e anotando o estado de cada um deles, para
 * verificar o que se pode aproveitar deles.
 * 
 * Foi requisitado que você desenvolva um programa para registrar este
 * levantamento. O programa deverá receber um número indeterminado de entradas,
 * cada uma contendo: um número de identificação do mouse o tipo de defeito:
 * 
 * necessita da esfera;
 * necessita de limpeza; a.necessita troca do cabo ou conector; a.quebrado ou
 * inutilizado Uma identificação igual a zero encerra o programa.
 * Ao final o programa deverá emitir o seguinte relatório:
 * 
 * Quantidade de mouses: 100
 * 
 * Situação Quantidade Percentual
 * 1- necessita da esfera 40 40%
 * 2- necessita de limpeza 30 30%
 * 3- necessita troca do cabo ou conector 15 15%
 * 4- quebrado ou inutilizado 15 15%
 */
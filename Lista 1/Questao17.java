import java.util.ArrayList;
import java.util.Scanner;

public class Questao17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> Atletas = new ArrayList<>();
        ArrayList<Double> saltos = new ArrayList<>();
        double Media = 0;
        String intermediario;
        while (true) {
            System.out.println("Digite o nome do Atleta");
            intermediario = sc.nextLine();
            if (intermediario == "") {
                break;
            } else {
                Atletas.add(intermediario);
                for (int i = 0; i < 5; i++) {
                    System.out.printf(("%nDigite a distancia em metros do ") + (i + 1) + "º salto%n");
                    saltos.add(sc.nextDouble());
                    Media = Media + saltos.get(i);

                }
                System.out.printf("%nresultado final:%nAtleta: " + Atletas.get(0) + "%nSaltos: ");
                for (int i = 0; i < 5; i++) {
                    System.out.print("-" + saltos.get(i));
                }
                System.out.printf("%nMédia dos saltos: " + (Media / 5) + " m%n%n");

            }

            intermediario = "";
            Atletas.clear();
            saltos.clear();
            Media = 0;

        }

    }

}
/*
 * Em uma competição de salto em distância cada atleta tem direito a cinco
 * saltos. O resultado do atleta será determinado pela média dos cinco valores
 * restantes. Você deve fazer um programa que receba o nome e as cinco
 * distâncias alcançadas pelo atleta em seus saltos e depois informe o nome, os
 * saltos e a média dos saltos. O programa deve ser encerrado quando não for
 * informado o nome do atleta.
 */
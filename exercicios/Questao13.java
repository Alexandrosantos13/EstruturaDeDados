import java.util.Scanner;

public class Questao13 {
    public static void main(String[] args) {
        float[] mesmediatemp = new float[12];
        float mediaAno = 0;
        String[] mesExtenso = { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto",
                "Setembro", "Outubro", "Novembro", "Dezembro" };
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 12; i++) {
            System.out.println("Digite a temperatura média do mês de " + mesExtenso[i]);
            mesmediatemp[i] = sc.nextFloat();
            mediaAno = mediaAno + mesmediatemp[i];
        }
        mediaAno = mediaAno / 12;

        for (int i = 0; i < 12; i++) {
            if (mesmediatemp[i] > mediaAno) {
                System.out.printf(mesExtenso[i] + " teve a temperatura superior a média anual. %n" + mesExtenso[i]
                        + "= " + mesmediatemp[i] + "%nMedia anual= " + mediaAno + "%n");
            }
        }
    }

}
/*
 * Faça um programa que receba a temperatura média de cada mês do ano e
 * armazene-as em uma lista. Após isto, calcule a média anual das temperaturas e
 * mostre todas as temperaturas acima da média anual, e em que mês elas
 * ocorreram (mostrar o mês por extenso: 1 – Janeiro, 2 – Fevereiro, ...).
 */
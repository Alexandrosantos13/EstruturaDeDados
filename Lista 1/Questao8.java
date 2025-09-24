import java.util.Scanner;

public class Questao8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] idade = new int[5];
        float[] altura = new float[5];
        for (int i = 0; i < 5; i++) {
            System.out.println("Digite a idade da pessoa " + (i + 1));
            idade[i] = sc.nextInt();
            System.out.println("Digite a altura da pessoa " + (i + 1));
            altura[i] = sc.nextFloat();
        }
        for (int i = 4; i >= 0; i--) {
            System.out.println("altura (em metros) da pessoa " + (i + 1) + ": " + altura[i]);
            System.out.println("idade da pessoa " + (i + 1) + ": " + idade[i]);
        }

    }

}
/*
 * Faça um programa que peça a idade e a altura de 5 pessoas, armazene cada
 * informação no seu respectivo vetor. Imprima a idade e a altura na ordem
 * inversa a ordem lida.
 */
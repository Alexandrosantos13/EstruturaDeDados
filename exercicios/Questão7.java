import java.util.Scanner;

public class Questão7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] vetor = new int[5];
        for (int i = 0; i < 5; i++) {
            System.out.println("Digite um valor");
            vetor[i] = sc.nextInt();
        }

        for (int i = 0; i <= 2; i++) {
            int intermediario = 0;
            if (i == 0) {
                for (int x = 0; x < 5; x++) {
                    intermediario = intermediario + vetor[x];
                }
                System.out.println("A soma dos valores do vetor é: " + intermediario);
            } else if (i == 1) {
                intermediario = 1;
                for (int x = 0; x < 5; x++) {
                    intermediario = intermediario * vetor[x];
                }
                System.out.println("A multiplicação dos valores do vetor é: " + intermediario);
            } else {
                System.out.println("os valores presentes no vetor são");
                for (int x = 0; x < 5; x++) {
                    System.out.print(vetor[x] + " ");
                }

            }

        }
    }

}
/*
 * Faça um programa que leia um vetor de 5 números inteiros, mostre a soma, a
 * multiplicação e os números.
 */
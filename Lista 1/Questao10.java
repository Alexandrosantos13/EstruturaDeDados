import java.util.Scanner;

public class Questao10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] VetorA = new int[10];
        int[] VetorB = new int[10];
        int[] VetorC = new int[20];
        int indexA = 0;
        int indexB = 0;

        for (int i = 0; i <= 1; i++) {
            if (i == 0) {
                for (int x = 0; x < 10; x++) {
                    System.out.println("Digite um valor para o vetor A");
                    VetorA[x] = sc.nextInt();
                }
            }
            if (i == 1) {
                for (int x = 0; x < 10; x++) {
                    System.out.println("Digite um valor para o vetor B");
                    VetorB[x] = sc.nextInt();
                }
            }

        }

        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0 || i == 0) {
                VetorC[i] = VetorA[indexA];
                indexA++;
            } else {
                VetorC[i] = VetorB[indexB];
                indexB++;
            }
        }

        System.out.println("Vetor C (intercalado):");
        for (int i = 0; i < 20; i++) {
            System.out.print(VetorC[i] + " ");
        }
    }

}
/*
 * Faça um programa que leia dois vetores com 10 elementos cada. Gere um
 * terceiro vetor de 20 elementos, cujos valores deverão ser compostos pelos
 * elementos intercalados dos dois outros vetores.
 */
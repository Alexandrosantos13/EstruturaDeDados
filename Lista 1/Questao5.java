import java.util.Scanner;

public class Questao5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] pares = new int[20];
        int[] impares = new int[20];
        int[] aux = new int[20];
        int indexpar = 0;
        int indeximpar = 0;
        for (int i = 0; i < 20; i++) {
            System.out.println("Digite um numero");
            aux[i] = sc.nextInt();
            if (aux[i] % 2 == 0 || aux[i] == 0) {
                pares[indexpar] = aux[i];
                indexpar++;
            } else {
                impares[indeximpar] = aux[i];
                indeximpar++;
            }
        }
        System.out.println("pares:");
        for (int i = 0; i < indexpar; i++) {
            System.out.print(pares[i] + " ");
        }
        System.out.printf("%nimpares:%n");
        for (int i = 0; i < indeximpar; i++) {
            System.out.print(impares[i] + " ");
        }

    }
}
/*
 * Faça um programa que leia 20 números inteiros e armazene-os num vetor.
 * Armazene os números pares no vetor PAR e os números IMPARES no vetor impar.
 * Imprima os três vetores.
 */
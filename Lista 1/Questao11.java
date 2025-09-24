import java.util.Scanner;

public class Questao11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] VetorA = new int[10];
        int[] VetorB = new int[10];
        int[] VetorC = new int[10];
        int[] VetorD = new int[30];
        int indexA = 0;
        int indexB = 0;
        int indexC = 0;

        for (int i = 0; i <= 2; i++) {
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
            if (i == 2) {
                for (int x = 0; x < 10; x++) {
                    System.out.println("Digite um valor para o vetor C");
                    VetorC[x] = sc.nextInt();
                }
            }

        }

        for (int i = 0; i < 30; i++) {
            if (i % 3 == 0) {
                VetorD[i] = VetorA[indexA++];
            } else if (i % 3 == 1) {
                VetorD[i] = VetorB[indexB++];
            } else {
                VetorD[i] = VetorC[indexC++];
            }
        }

        System.out.println("Vetor C (intercalado):");
        for (int i = 0; i < 30; i++) {
            System.out.print(VetorD[i] + " ");
        }
    }

}
/* Altere o programa anterior, intercalando 3 vetores de 10 elementos cada. */
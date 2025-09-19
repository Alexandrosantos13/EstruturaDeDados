import java.util.Scanner;

public class Questao6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float[] Medias = new float[10];
        int alunosNaMedia=0;

        for (int i = 1; i < 11; i++) {
            float intermediario = 0;
            for (int x = 0; x < 4; x++) {
                System.out.println("Digite a primeira nota do aluno " + i);
                intermediario = intermediario + sc.nextFloat();
            }
            Medias[i - 1] = (intermediario / 4);

        }
        for (int i = 1; i < Medias.length + 1; i++) {
            if (Medias[i - 1] >= 7) {
                System.out.printf("%nO aluno " + i + " esta na média com nota " + Medias[i - 1]+"%n");
                alunosNaMedia++;
            }
        }
        System.out.println("Quantidade de alunos na média: "+alunosNaMedia);

    }

}
/*
 * Faça um programa que peça as quatro notas de 10 alunos, calcule e armazene
 * num vetor a média de cada aluno, imprima o número de alunos com média maior
 * ou igual a 7.0.
 */
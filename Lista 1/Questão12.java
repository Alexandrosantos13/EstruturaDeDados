import java.util.Scanner;

public class Questão12 {
    public static void main(String[] args) {
        int[] idade = new int[30];
        float[] altura = new float[30];
        Scanner sc = new Scanner(System.in);
        float media = 0;
        int submedia = 0;

        for (int i = 0; i < 30; i++) {
            System.out.println("Digite a idade do aluno " + (i + 1));
            idade[i] = sc.nextInt();
            System.out.println("Digite a altura do aluno " + (i + 1));
            altura[i] = sc.nextFloat();
            media = media + altura[i];
        }
        media = media / 30;

        for (int i = 0; i < 30; i++) {
            if (altura[i] < media && idade[i] > 13) {
                submedia++;
            }
        }

        System.out.println(
                "O total de alunos com mais de 13 anos possuem altura inferior à média de altura é: " + submedia);

    }
}
/*
 * Foram anotadas as idades e alturas de 30 alunos. Faça um Programa que
 * determine quantos alunos com mais de 13 anos possuem altura inferior à média
 * de altura desses alunos.
 */
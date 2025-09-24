import java.util.ArrayList;
import java.util.Scanner;

public class Questao15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> valores = new ArrayList<>();
        int somavalores = 0;
        int acimamedia = 0;
        int abaixosete = 0;

        while (true) {
            System.out.println("Forneça um valor, forneça -1 para finalizar o programa");
            int checagem = sc.nextInt();
            if (checagem == -1) {
                break;
            }
            valores.add(checagem);
        }

        // Mostre a quantidade de valores que foram lidos;
        System.out.println("Foram digitados " + valores.size() + " no total");

        // Exiba todos os valores na ordem em que foram informados, um ao lado do outro
        System.out.println("Valores informados: ");
        for (int v : valores) {
            System.out.print(v + " ");
        }
        System.out.println();

        // Exiba todos os valores na ordem inversa à que foram informados, um abaixo do
        // outro;
        System.out.printf("%nValores informados em ordem inversa: %n");
        for (int i = valores.size() - 1; i >= 0; i--) {
            System.out.println(valores.get(i));
        }

        // Calcule e mostre a soma dos valores;
        for (int v : valores) {
            somavalores += v;
        }
        System.out.println("A soma dos valores é: " + somavalores);

        // Calcule e mostre a média dos valores;
        float mediavalores = valores.size() > 0 ? (float) somavalores / valores.size() : 0;
        System.out.println("A média dos valores é: " + mediavalores);

        // Calcule e mostre a quantidade de valores acima da média calculada;
        for (int v : valores) {
            if (v > mediavalores) {
                acimamedia++;
            }
        }
        System.out.println("O total de valores acima da média é " + acimamedia);

        // Calcule e mostre a quantidade de valores abaixo de sete;
        for (int v : valores) {
            if (v < 7) {
                abaixosete++;
            }
        }
        System.out.println("O total de valores abaixo de sete é " + abaixosete);

        // Encerre o programa com uma mensagem;
        System.out.println("Questão dos inferno\nAdeus, encerrando programa");

    }
}
/*
 * Faça um programa que leia um número indeterminado de valores, correspondentes
 * a notas, encerrando a entrada de dados quando for informado um valor igual a
 * -1 (que não deve ser armazenado). Após esta entrada de dados, faça:
 * 
 * Mostre a quantidade de valores que foram lidos;
 * Exiba todos os valores na ordem em que foram informados, um ao lado do
 * outro;(loop imprimir sem ln iniciando de 0)//
 * Exiba todos os valores na ordem inversa à que foram informados, um abaixo do
 * outro;(loop iniciado de lenght até 0)//
 * Calcule e mostre a soma dos valores;//
 * Calcule e mostre a média dos valores;//
 * Calcule e mostre a quantidade de valores acima da média calculada;//
 * Calcule e mostre a quantidade de valores abaixo de sete;
 * Encerre o programa com uma mensagem;
 */
import java.util.Random;

public class Questao24 {
	public static void main(String[] args) {
		int[] resultados = new int[100];
		int[] contadores = new int[6]; // índices 0-5 representam os valores 1-6
		Random rand = new Random();

		// Simula 100 lançamentos
		for (int i = 0; i < 100; i++) {
			int valor = lancarDado(rand);
			resultados[i] = valor;
			contadores[valor - 1]++;
		}

		// Exibe quantas vezes cada valor foi obtido
		System.out.println("Resultado dos lançamentos:");
		for (int i = 0; i < 6; i++) {
			System.out.println("Valor " + (i + 1) + ": " + contadores[i] + " vezes");
		}
	}

	public static int lancarDado(Random rand) {
		return rand.nextInt(6) + 1; // retorna valor entre 1 e 6
	}
}
/*Faça um programa que simule um lançamento de dados. Lance o dado 100 vezes e armazene os resultados em um vetor . Depois, mostre quantas vezes cada valor foi conseguido. Dica: use um vetor de contadores(1-6) e uma função para gerar numeros aleatórios, simulando os lançamentos dos dados. */
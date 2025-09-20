import java.util.ArrayList;
import java.util.Scanner;

public class Questao16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> salarios = new ArrayList<>();
        String[] intervalos = {
                "$200 - $299",
                "$300 - $399",
                "$400 - $499",
                "$500 - $599",
                "$600 - $699",
                "$700 - $799",
                "$800 - $899",
                "$900 - $999",
                "$1000 em diante"
        };
        int intermediario = 0;
        int[] quantidade = new int[9];
        while (true) {
            System.out.println("Digite o valor de vendas do funcionario (digite -1 para encerrar)");
            intermediario = sc.nextInt();
            if (intermediario == -1) {
                break;
            } else {
                salarios.add(200 + ((intermediario * 9 / 100)));
            }
        }

        for (int i = 0; i < intervalos.length; i++) {
            if (i == 0) {
                for (int x = 0; x < salarios.size(); x++) {
                    if (salarios.get(x) >= 200 && salarios.get(x) <= 299) {
                        quantidade[i]++;
                    }
                }
            } else if (i == 1) {
                for (int x = 0; x < salarios.size(); x++) {
                    if (salarios.get(x) >= 300 && salarios.get(x) <= 399) {
                        quantidade[i]++;
                    }
                }
            } else if (i == 2) {
                for (int x = 0; x < salarios.size(); x++) {
                    if (salarios.get(x) >= 400 && salarios.get(x) <= 499) {
                        quantidade[i]++;
                    }
                }
            } else if (i == 3) {
                for (int x = 0; x < salarios.size(); x++) {
                    if (salarios.get(x) >= 500 && salarios.get(x) <= 599) {
                        quantidade[i]++;
                    }
                }
            } else if (i == 4) {
                for (int x = 0; x < salarios.size(); x++) {
                    if (salarios.get(x) >= 600 && salarios.get(x) <= 799) {
                        quantidade[i]++;
                    }
                }
            } else if (i == 5) {
                for (int x = 0; x < salarios.size(); x++) {
                    if (salarios.get(x) >= 700 && salarios.get(x) <= 799) {
                        quantidade[i]++;
                    }
                }
            } else if (i == 6) {
                for (int x = 0; x < salarios.size(); x++) {
                    if (salarios.get(x) >= 800 && salarios.get(x) <= 899) {
                        quantidade[i]++;
                    }
                }
            } else if (i == 7) {
                for (int x = 0; x < salarios.size(); x++) {
                    if (salarios.get(x) >= 900 && salarios.get(x) <= 999) {
                        quantidade[i]++;
                    }
                }
            } else if (i == 8) {
                for (int x = 0; x < salarios.size(); x++) {
                    if (salarios.get(x) >= 500 && salarios.get(x) <= 599) {
                        quantidade[i]++;
                    }
                }
            } else if (i == 9) {
                for (int x = 0; x < salarios.size(); x++) {
                    if (salarios.get(x) > 999) {
                        quantidade[i]++;
                    }
                }
            }
            System.out.println(intervalos[i]);
            System.out.println(quantidade[i]);
        }

    }
}

/*
 * Utilize uma lista para resolver o problema a seguir. Uma empresa paga seus
 * vendedores com base em comissões. O vendedor recebe $200 por semana mais 9
 * por cento de suas vendas brutas daquela semana. Por exemplo, um vendedor que
 * teve vendas brutas de $3000 em uma semana recebe $200 mais 9 por cento de
 * $3000, ou seja, um total de $470. Escreva um programa (usando um array de
 * contadores) que determine quantos vendedores receberam salários nos seguintes
 * intervalos de valores:
 */
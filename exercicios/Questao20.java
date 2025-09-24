import java.util.ArrayList;
import java.util.Scanner;

public class Questao20 {
    public static void main(String[] args) {
        ArrayList<Double> salario = new ArrayList<>();
        ArrayList<Double> abono = new ArrayList<>();
        int colaboradores = 0;
        int valorminimo = 0;
        double gastoabono = 0;
        double maiorabono = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("Projeção de Gastos com Abono\r\n" + //
                "============================\n ");

        for (int i = 0; true; i++) {
            double intermediario = 0;
            System.out.print("Salário: ");
            intermediario = sc.nextDouble();
            if (intermediario == 0) {
                System.out.println("");
                break;
            } else {
                colaboradores++;
                salario.add(intermediario);
                if (salario.get(i) <= 500) {
                    abono.add(100.00);
                    valorminimo++;
                    gastoabono = gastoabono + abono.get(i);
                    if (abono.get(i) > maiorabono) {
                        maiorabono = abono.get(i);
                    }
                } else {
                    abono.add((salario.get(i) / 100.00) * 20.00);
                    gastoabono = gastoabono + abono.get(i);
                    if (abono.get(i) > maiorabono) {
                        maiorabono = abono.get(i);
                    }
                }
            }
        }
        System.out.println("Salário    - Abono ");
        for (int i = 0; i < salario.size(); i++) {
            System.out.printf("R$" + salario.get(i) + "  -  R$" + abono.get(i) + "\n");
        }
        System.out.println("Foram processados " + colaboradores + " colaboradores\r\n" + //
                "Total gasto com abonos: R$ " + gastoabono + "\r\n" + //
                "Valor mínimo pago a " + valorminimo + " colaboradores\r\n" + //
                "Maior valor de abono pago: R$ " + maiorabono + "\n");
    }
}

/*
 * Exercício 20
 * As Organizações Tabajara resolveram dar um abono aos seus colaboradores em
 * reconhecimento ao bom resultado alcançado durante o ano que passou. Para isto
 * contratou você para desenvolver a aplicação que servirá como uma projeção de
 * quanto será gasto com o pagamento deste abono.
 * 
 * Após reuniões envolvendo a diretoria executiva, a diretoria financeira e os
 * representantes do sindicato laboral, chegou-se a seguinte forma de cálculo:
 * 
 * Cada funcionário receberá o equivalente a 20% do seu salário bruto de
 * dezembro;
 * O piso do abono será de 100 reais, isto é, aqueles funcionários cujo salário
 * for muito baixo, recebem este valor mínimo;
 * Neste momento, não se deve ter nenhuma preocupação com colaboradores com
 * tempo menor de casa, descontos, impostos ou outras particularidades. Seu
 * programa deverá permitir a digitação do salário de um número indefinido
 * (desconhecido) de salários. Um valor de salário igual a 0 (zero) encerra a
 * digitação. Após a entrada de todos os dados o programa deverá calcular o
 * valor do abono concedido a cada colaborador, de acordo com a regra definida
 * acima.
 * 
 * Ao final, o programa deverá apresentar:
 * 
 * O salário de cada funcionário, juntamente com o valor do abono;
 * O número total de funcionário processados;
 * O valor total a ser gasto com o pagamento do abono;
 * O número de funcionário que receberá o valor mínimo de 100 reais;
 * O maior valor pago como abono; A tela abaixo é um exemplo de execução do
 * programa, apenas para fins ilustrativos. Os valores podem mudar a cada
 * execução do programa.
 * 
 * Projeção de Gastos com Abono
 * ============================
 * 
 * Salário: 1000
 * Salário: 300
 * Salário: 500
 * Salário: 100
 * Salário: 4500
 * Salário: 0
 * 
 * Salário - Abono
 * R$ 1000.00 - R$ 200.00
 * R$ 300.00 - R$ 100.00
 * R$ 500.00 - R$ 100.00
 * R$ 100.00 - R$ 100.00
 * R$ 4500.00 - R$ 900.00
 * 
 * Foram processados 5 colaboradores
 * Total gasto com abonos: R$ 1400.00
 * Valor mínimo pago a 3 colaboradores
 * Maior valor de abono pago: R$ 900.00
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Questao23 {
    public static void main(String[] args) throws Exception {
        List<String> nomes = new ArrayList<>();
        List<Long> bytes = new ArrayList<>();

        // Leitura do arquivo
        BufferedReader br = new BufferedReader(new FileReader("usuarios.txt"));
        String linha;
        while ((linha = br.readLine()) != null) {
            if (linha.trim().isEmpty()) continue;
            String nome = linha.substring(0, 15).trim();
            long valor = Long.parseLong(linha.substring(15).trim());
            nomes.add(nome);
            bytes.add(valor);
        }
        br.close();

        // Cálculos
        double[] mb = new double[bytes.size()];
        double total = 0;
        for (int i = 0; i < bytes.size(); i++) {
            mb[i] = bytesToMB(bytes.get(i));
            total += mb[i];
        }
        double media = total / mb.length;

        // Gerar relatório
        PrintWriter pw = new PrintWriter("relatorio.txt");
        pw.println("ACME Inc.               Uso do espaço em disco pelos usuários");
        pw.println("------------------------------------------------------------------------");
        pw.println("Nr.  Usuário        Espaço utilizado     % do uso\n");

        for (int i = 0; i < nomes.size(); i++) {
            double percentual = calculaPercentual(mb[i], total);
            pw.printf("%-4d %-15s %10.2f MB %16.2f%%%n", (i+1), nomes.get(i), mb[i], percentual);
        }
        pw.println();
        pw.printf("Espaço total ocupado: %.2f MB%n", total);
        pw.printf("Espaço médio ocupado: %.2f MB%n", media);
        pw.close();
    }

    public static double bytesToMB(long bytes) {
        return bytes / Math.pow(1024, 2);
    }

    public static double calculaPercentual(double valor, double total) {
        if (total == 0) return 0;
        return valor / total * 100;
    }
}
/*A ACME Inc., uma empresa de 500 funcionários, está tendo problemas de espaço em disco no seu servidor de arquivos. Para tentar resolver este problema, o Administrador de Rede precisa saber qual o espaço ocupado pelos usuários, e identificar os usuários com maior espaço ocupado. Através de um programa, baixado da Internet, ele conseguiu gerar o seguinte arquivo, chamado "usuarios.txt":

usuarios.txt
alexandre       456123789
anderson        1245698456
antonio         123456456
carlos          91257581
cesar           987458
rosemary        789456125
Neste arquivo, o nome do usuário possui 15 caracteres.

A partir deste arquivo, você deve criar um programa que gere um relatório, chamado "relatório.txt", no seguinte formato:

ACME Inc.               Uso do espaço em disco pelos usuários
------------------------------------------------------------------------
Nr.  Usuário        Espaço utilizado     % do uso

1    alexandre       434,99 MB             16,85%
2    anderson       1187,99 MB             46,02%
3    antonio         117,73 MB              4,56%
4    carlos           87,03 MB              3,37%
5    cesar             0,94 MB              0,04%
6    rosemary        752,88 MB             29,16%

Espaço total ocupado: 2581,57 MB
Espaço médio ocupado: 430,26 MB
O arquivo de entrada deve ser lido uma única vez, e os dados armazenados em memória, caso sejam necessários, de forma a agilizar a execução do programa. A conversão da espaço ocupado em disco, de bytes para megabytes deverá ser feita através de uma função separada, que será chamada pelo programa principal. O cálculo do percentual de uso também deverá ser feito através de uma função, que será chamada pelo programa principal. */
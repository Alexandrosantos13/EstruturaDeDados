import java.util.Scanner;
public class Questao19{
    public static void main (String [] args){
        float[] votos = new float[6];
        String [] sistemas = {"Windows Server","Unix","Linux","Netware","Mac OS","Outro"};
        Scanner sc = new Scanner(System.in);
        float totalvotos=0;
        float[] porcentagemvotos = new float[6];
        System.out.printf("Qual o melhor Sistema Operacional para uso em servidores?\n1- Windows Server\r\n" + //
                "2- Unix\r\n" + //
                "3- Linux\r\n" + //
                "4- Netware\r\n" + //
                "5- Mac OS\r\n" + //
                "6- Outro\n");
            System.out.println("Quantos votos teve o Windows Server?");
            votos[0]=sc.nextInt();
            totalvotos+=votos[0];
             System.out.println("Quantos votos teve o Unix");
            votos[1]=sc.nextInt();
            totalvotos+=votos[1];
             System.out.println("Quantos votos teve o Linux?");
            votos[2]=sc.nextInt();
            totalvotos+=votos[2];
             System.out.println("Quantos votos teve o Netware?");
            votos[3]=sc.nextInt();
            totalvotos+=votos[3];
             System.out.println("Quantos votos teve o Mac OS?");
            votos[4]=sc.nextInt();
            totalvotos+=votos[4];
             System.out.println("Quantos votos teve outros SO");
            votos[5]=sc.nextInt();
            totalvotos+=votos[5];

            for (int i=0;i<6;i++){
                porcentagemvotos[i]=(votos[i]/totalvotos)*100;
            }



            System.out.printf("Sistema Operacional     Votos   %%\r\n" + 
                  "-------------------      -----   ---\r\n" + 
                  "Windows Server            " + votos[0] + "   " + String.format("%.1f", porcentagemvotos[0]) + "%%\r\n" +
                  "Unix                      " + votos[1] + "   " + String.format("%.1f", porcentagemvotos[1]) + "%%\r\n" +
                  "Linux                     " + votos[2] + "   " + String.format("%.1f", porcentagemvotos[2]) + "%%\r\n" +
                  "Netware                   " + votos[3] + "   " + String.format("%.1f", porcentagemvotos[3]) + "%%\r\n" +
                  "Mac OS                    " + votos[4] + "   " + String.format("%.1f", porcentagemvotos[4]) + "%%\r\n" +
                  "Outro                     " + votos[5] + "   " + String.format("%.1f", porcentagemvotos[5]) + "%%\r\n" +
                  "-------------------     -----\r\n" + 
                  "Total                    " + totalvotos);




            }
        
        
    
}
/*Uma empresa de pesquisas precisa tabular os resultados da seguinte enquete feita a um grande quantidade de organizações:

"Qual o melhor Sistema Operacional para uso em servidores?"

As possíveis respostas são:

1- Windows Server
2- Unix
3- Linux
4- Netware
5- Mac OS
6- Outro
Você foi contratado para desenvolver um programa que leia o resultado da enquete e informe ao final o resultado da mesma. O programa deverá ler os valores até ser informado o valor 0, que encerra a entrada dos dados. Não deverão ser aceitos valores além dos válidos para o programa (0 a 6). Os valores referentes a cada uma das opções devem ser armazenados num vetor. Após os dados terem sido completamente informados, o programa deverá calcular a percentual de cada um dos concorrentes e informar o vencedor da enquete. O formato da saída foi dado pela empresa, e é o seguinte:

Sistema Operacional     Votos   %
-------------------     -----   ---
Windows Server           1500   17%
Unix                     3500   40%
Linux                    3000   34%
Netware                   500    5%
Mac OS                    150    2%
Outro                     150    2%
-------------------     -----
Total                    8800

O Sistema Operacional mais votado foi o Unix, com 3500 votos, correspondendo a 40%  */
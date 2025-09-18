import java.util.Scanner;
public class Questao4 {
    public static void main (String [] args){
        Scanner sc = new Scanner(System.in);
        String[] palavra = new String[1];
        int consoantes=0;
        System.out.println("Digite uma palavra");
        palavra[0] = sc.nextLine();
        char [] aux = palavra[0].toLowerCase().toCharArray();

        for (int i=aux.length; i>0; i--){
            String letra=String.valueOf(aux[i-1]);
            if (!letra.equals("a") && !letra.equals("e") && !letra.equals("i") && !letra.equals("o") && !letra.equals("u")){
                if (Character.isLetter(aux[i-1])) { 
                    consoantes++;
                    System.out.println(letra);
                }
            }
        }
        System.out.println("O total de consoantes foi "+ consoantes);
    }
}
/*4. Faça um programa em Java que leia um vetor de 10 caracteres, e diga quantas consoantes foram lidas. Imprima as consoantes.
 * quebre a palavra em 10 caracteres e atribua cada caractere a um slot em um array
 * dps faça um loop onde um contador vai receber ele mesmo mais 1 a cada não vogal
 */
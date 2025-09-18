import java.util.Scanner;
public class Questao3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] notas= new int[4];
        double media = 0;
        for (int i=0; i<notas.length; i++){
            
            System.out.println("Digite a nota");
            notas[i] = sc.nextInt();
            media = media+notas[i];
        }
        media=media/notas.length;
        System.out.printf("A média é %.2f", media);
    }
}
/*3. Faça um programa em Java que leia 4 notas, mostre as notas e a média na tela.
 * 
 */
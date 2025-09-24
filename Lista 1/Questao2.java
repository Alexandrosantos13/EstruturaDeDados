public class Questao2 {
    public static void main(String[]args){
        int [] lista = new int[10];
            lista[0]=1;
            lista[1]=2;
            lista[2]=3;
            lista[3]=4;
            lista[4]=5;
            lista[5]=6;
            lista[6]=7;
            lista[7]=8;
            lista[8]=9;
            lista[9]=10;
        for (int i=lista.length-1;i>-1; i--){
            System.out.println(lista[i]);
        }

    }
}
/*2. Faça um programa em Java que leia um vetor de 10 números reais e mostre-os na ordem inversa.
 * Passo 1_ pegue o lenght do array
 * Passo 2_ inicie o i pelo lenght do array -1
 * Passo 3_ diminua de 1 em 1 até -1
 * Passo 4_ conclua o codigo.
 */
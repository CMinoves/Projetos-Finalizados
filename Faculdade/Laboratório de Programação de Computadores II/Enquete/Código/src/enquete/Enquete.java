/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enquete;
import java.security.SecureRandom;
import java.util.Scanner;
/**
 *
 * @author Cristhian
 */
public class Enquete {
        /**
     *
     * @param star2
     */
    public static void frequencia(int [] star2){
        for(int x=0; x<10;x++){
            System.out.println("Nº de notas " + (x+1) + ":" + star2[x]);
        }
    }
    public static  void media(int [] star2){
        float med=0;
        float num=0;
        int x;
        for(x=0;x<10;x++){
            med=med+((x+1)*star2[x]);
            num=num+star2[x];
        }
        med=med/num;
        System.out.println("A média das notas é:"+med);
    }
    public static void numero(int [] star2){
        int qtde=1;
        for(int x=0;x<10;x++){
            qtde+=star2[x];
        }
        System.out.println("Foram entrevistados "+qtde+" alunos.");
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SecureRandom gerador = new SecureRandom();
        int [] star = new int [10];
        float soma=0;
        char continuar;
        System.out.println("Quantos alunos serão intrevistados?");
        int qtde = gerador.nextInt(50);
        System.out.println("Serão entrevistados "+qtde+" alun0s");
        for(int x=0;x<qtde;x++){
            System.out.println("Digite um número inteiro representando sua nota de 1(pouco satisfeito) até 10(muito satisfeito)");
            int nota = gerador.nextInt(11);
            soma += nota;
            for(int n = 0; n<=9; n++){
                if(nota == (n+1)){
                    star[n] ++;
                }
            }
        }
        frequencia(star);
        media(star);
        numero(star);
    } 
}

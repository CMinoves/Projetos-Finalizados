package lista1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Jord
 */
public class Lista1 {


    
    public static void main(String[] args) {
        Random gerador = new Random();
        Scanner input = new Scanner(System.in);
        boolean verificador;
        int chave = 0;
        int resposta;
        double timei,timef;
        System.out.println("Qual experimento realizar? 1 ou 2?");
        resposta = input.nextInt();
        ArvoreBinaria[] colecao = new ArvoreBinaria[10];
        for(int x = 0;x<9;x++){
            colecao[x] = new ArvoreBinaria();
            ArrayList<Integer> numeros = new ArrayList();
            /*esse arraylist será usado para evitr a tentativa de inserção do
            mesmo número mais de uma vez sem ter que alterar a classe "ArvoreBinaria"*/
            if(resposta==1){
                chave = 1000 + gerador.nextInt((x+1)*1000);
                chave --;
            }
            System.out.println("Inserindo elementos na árvore "+(x+1));
            for(int y = 0; y<(x+1)*1000;y++){
                if(resposta ==2){
                    do{
                       // System.out.println(y);
                        chave = 1000 + gerador.nextInt(100000);
                        verificador = teste(chave,numeros);
                        /*para evitar a tentativa de repetição de números, o que
                        poderia causar uma árvore com menos nós que o desejado, apesar de
                        fazer com que o bloco verificador da clase ArvoreBinaria seja
                        inútil*/
                    }while(verificador);
                    numeros.add(chave);
                }else{
                   // System.out.println(y);
                    chave++;
                    /*aqui a chave vai saltando de um em um */
                }
                Item key = new Item(chave);
                colecao[x].insere(key);
            }
            System.out.println("Buscando o elemento inexistente na árvore "+(x+1));
            Item pesq = new Item(40);//não há nenhum item com chave 40
            timei = System.nanoTime();
            verificador = colecao[x].pesquisa(pesq);
            timef = System.nanoTime();
            timef = timef-timei;
            if(!verificador){
                System.out.println("Item não encontrado");
            }else{
                System.out.println("Item encontrado");
            }
            System.out.println("Numero de comparacoes: "+colecao[x].getComparacoes());
            System.out.println("Tempo gasto em:");
            System.out.println("Nanossegundos: "+timef);
            System.out.println("Microssegundos: "+(timef/1000));
            System.out.println("Milissegundos: "+(timef/1000000));
            System.out.println("Segundos: "+(timef/1000000000));
        }    
            
     }
        
    public static boolean teste(int key, ArrayList<Integer> Lista){
        Iterator<Integer> it = Lista.iterator();
        while(it.hasNext()){
            int aux = it.next();
            if(key == aux){
            return true;
            }
        }
        return false;
    }
}
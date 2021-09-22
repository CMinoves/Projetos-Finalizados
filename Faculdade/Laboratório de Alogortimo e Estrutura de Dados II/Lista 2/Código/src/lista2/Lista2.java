package lista2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Cristhian
 */
public class Lista2 {


    
    public static void main(String[] args) {
        Random gerador = new Random();
        Scanner input = new Scanner(System.in);
        boolean verificador = false;
        int chave = 0;
        int resposta;
        System.out.println("Qual experimento realizar? 1, 2 ou 3?");
        resposta = input.nextInt();
        ArvoreSBB[] colecao = new ArvoreSBB[11];
        
        for(int x = 1;x<=10;x++){
            colecao[x] = new ArvoreSBB();
            ArrayList<Integer> numeros = new ArrayList();
            /*esse arraylist será usado para evitr a tentativa de inserção do
            mesmo número mais de uma vez sem ter que alterar a classe "ArvoreBinaria"*/
            System.out.println("Inserindo elementos na árvore "+x+" do experimento "+resposta);
            switch(resposta){
                case 1:
                    int y;
                    for(y = 1;y<=(x)*1000;y++){
                        Item key = new Item(y);
                        colecao[x].insere(key);
                    }
                    System.out.println("Pesquisando elementos na árvore "+x+" do experimento "+resposta);
                    Item pesq = new Item(0);
                    pesq.setChave(y);
                    pesq = colecao[x].pesquisa(pesq);
                    if(pesq == null){
                        System.out.println("Elemento não encotrado");
                    }else{
                        System.out.println("Elemento encontrado! Algo deu errado!");
                    }
                    System.out.println("Número de nós visitados: "+colecao[x].getNosVisitados());
                    System.out.println("Quantidade de níveis da árvore: "+colecao[x].getQuantidadeNiveisArvore());
                break;
                    
                case 2:
                    for(int z = 1;z<=(x)*1000;z++){
                        do{
                        chave = 1+gerador.nextInt(500000);
                        verificador = teste(chave,numeros);
                        }while(verificador);
                        numeros.add(chave);
                        Item key = new Item(chave);
                        colecao[x].insere(key);
                    }
                    System.out.println("Pesquisando elementos na árvore "+x+" do experimento "+resposta);
                    Item pesq1 = new Item(0);
                    pesq1.setChave(500001);
                    pesq1 = colecao[x].pesquisa(pesq1);
                    if(pesq1 == null){
                        System.out.println("Elemento não encotrado");
                    }else{
                        System.out.println("Elemento encontrado! Algo deu errado!");
                    }
                    System.out.println("Número de nós visitados: "+colecao[x].getNosVisitados());
                    System.out.println("Quantidade de níveis da árvore: "+colecao[x].getQuantidadeNiveisArvore());
                    
                break;
                
                case 3:
                    int z;
                    int limite = 0;
                    switch (x){
                        case 1: limite = 5; break;
                        
                        case 2: limite = 10; break;
                        
                        case 3: limite = 50; break;
                        
                        case 4: limite = 100; break;
                        
                        case 5: limite = 500; break;
                        
                        case 6: limite = 1000; break;
                        
                        case 7: limite = 5000; break;
                        
                        case 8: limite = 10000; break;
                        
                        case 9: limite = 50000; break;
                        
                        case 10: limite = 100000; break;
                        
                    }
                    for(z = 1;z<=limite;z++){
                        do{
                        chave = 1+gerador.nextInt(500000);
                        verificador = teste(chave,numeros);
                        }while(verificador);
                        
                        numeros.add(chave);
                        Item key = new Item(chave);
                        colecao[x].insere(key);
                    }
                    System.out.println("Pesquisando elementos na árvore "+x+" do experimento "+resposta);
                    Item pesq2 = new Item(0);
                    pesq2.setChave(500001);
                    pesq2 = colecao[x].pesquisa(pesq2);
                    if(pesq2 == null){
                        System.out.println("Elemento não encotrado");
                    }else{
                        System.out.println("Elemento encontrado! Algo deu errado!");
                    }
                    System.out.println("Número de nós visitados: "+colecao[x].getNosVisitados());
                    System.out.println("Quantidade de níveis da árvore: "+colecao[x].getQuantidadeNiveisArvore());
                break;
            }
            
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
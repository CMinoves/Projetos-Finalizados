/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista3;

import java.util.Scanner;

/**
 *
 * @author Cristhian
 */
public class Lista3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArvoreB a = new ArvoreB(10);
        int op, ordem = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Qual experimento realizar? 1 a 4");
        op = input.nextInt();
        switch(op){
            case 1: ordem = 2; break;
            case 2: ordem = 4; break;
            case 3: ordem = 8; break;
            case 4: ordem = 16; break;
        }
        ArvoreB[] colecao = new ArvoreB[10];
        for(int x = 0;x<10;x++){
            colecao[x] = new ArvoreB(ordem);
            for(int y = 1;y<=(x+1)*1000;y++){
                Item p = new Item(y);
                colecao[x].insere(p);
            }
            System.out.println("Procurando um item inexistente na árvore "+(x+1));
            Item p = new Item(-1);
            p = colecao[x].pesquisa(p);
            if(p == null){
                System.out.println("Item não encontrado!");
            }else{
                System.out.println("Item encontrado, mas como?");
            }
            System.out.println("Número de páginas visitadas: "+colecao[x].getPaginasVisitadas());
            System.out.println("Número de comparacoes: "+colecao[x].getNumeroComparacoes());
        }
    }
}

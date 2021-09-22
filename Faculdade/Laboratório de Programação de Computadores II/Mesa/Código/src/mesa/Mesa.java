/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mesa;

import java.util.Scanner;

/**
 *
 * @author aluno
 */
public class Mesa {

    /**
     * @param args the command line arguments
     */
    
    public static void Compara(Carta cj1, Carta cj2){
        System.out.println("Dentro de Compara");
        System.out.println(cj1.getValor());
        System.out.println(cj2.getValor());
        if(cj1.getValor()>cj2.getValor()){
            System.out.println("Jogador Nº1 venceu");
        }else{
            if(cj2.getValor()>cj1.getValor()){
                System.out.println("Jogador Nº2 venceu");
            }else{
                if(cj1.getNaipe().equals("Ouros")== true){
                    System.out.println("Jogador Nº1 venceu!");
                }else{
                    if(cj2.getNaipe().equals("Ouros")==true){
                        System.out.println("Jogador Nº2 venceu!");
                    }else{
                        System.out.println("Jogo empatado!");
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       Baralho b1 = new Baralho();
       Jogador j1 = new Jogador();
       Jogador j2 = new Jogador();
       Carta cj1 = new Carta();
       Carta cj2 = new Carta();
       int hand;
       System.out.println("Vamos jogar! Qual será o tamanho da mão de cada jogador?");
       hand = input.nextInt();
       b1.Embaralhar();
       System.out.println(b1.getCarta(2).getNaipe());
       j1.compraMao(b1, hand,0);
       j2.compraMao(b1, hand, 1);
       cj1 = j1.maiorCarta(hand);
       cj2 = j2.maiorCarta(hand);
       System.out.println("A maior carta do Jogador Nº1 é um "+ cj1.getValor()+" de "+cj1.getNaipe());
       System.out.println("A maior carta do Jogador Nº2 é um "+ cj2.getValor()+" de "+cj2.getNaipe());
       Compara(cj1,cj2);
    }
    
}

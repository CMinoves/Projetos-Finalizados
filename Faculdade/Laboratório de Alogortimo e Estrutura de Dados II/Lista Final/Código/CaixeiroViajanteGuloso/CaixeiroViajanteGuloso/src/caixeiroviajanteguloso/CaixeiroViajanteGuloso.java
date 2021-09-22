/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caixeiroviajanteguloso;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Cristhian
 */
public class CaixeiroViajanteGuloso {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int no = 0;
        int fim = 0;
        String nomearq = "";
        System.out.println("Digite qual grafo usar: ");
        System.out.println("1 - pa561");
        System.out.println("2 - si535");
        System.out.println("3 - si1032");
        int op = input.nextInt();
        switch (op) {
            case 1:
                nomearq = "pa561.tsp";
                no = 561;
                fim = 9;
                break;
            case 2:
                nomearq = "si535.tsp";
                no = 535;
                fim = 7;
                break;
            case 3:
                nomearq = "si1032.tsp";
                no = 1032;
                fim = 7;
            break;
        }
        //bloco de leitura do arquivo

        int teste = 0;
        int j = 0;
        int i = 0;
        int[][]matadj = new int[no][no];
        try {
            FileReader arq = new FileReader(nomearq);
            BufferedReader lerArq = new BufferedReader(arq);
            int aux = 0;
            String linha;
            String[]separado;
            for(int o = 0;o<fim;o++){
                linha = lerArq.readLine();
            }

               while ((linha = lerArq.readLine())!= null) {
                   separado = linha.split(" ");
                   if(op==1){
                   for(j = 0;j<separado.length;j++){

                       matadj[i][j] = Integer.valueOf(separado[j]);
                       matadj[j][i] = Integer.valueOf(separado[j]);
                       
                   }
                   i++;
                   teste ++;
                   }else{
                       for(j=1;j<separado.length;j++){
                           if(aux == no){
                               i++;
                               aux = i;
                           }
                        matadj[i][aux] = Integer.valueOf(separado[j]);
                        matadj[aux][i] = Integer.valueOf(separado[j]);
                        aux++;
                       }
                   }
               }
            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }
        //fim da leitura do arquivo
        System.out.println("Qual será a cidade de origem? de 0 até "+(no-1));
        int inicio = input.nextInt();
        long tempo = System.nanoTime();
        int[]f = new int[no];
        int[]caminho = new int[no];
        int insere = 1;
        long custo = 0;
        //salvando a coluna referente a cidade de chegada/partida para ser usada no final
        for(int y = 0;y<no;y++){
            f[y] = matadj[y][inicio];
            matadj[y][inicio] = 0;
        }
        int menor;
        caminho[0] = inicio;
        for(int x = 1;x<no-1;x++){
            menor = 2147483647;//maior valor para int
            if(x == no-2){//ultimo valor buscado
                caminho[insere] = caminho[0];
                custo+=f[inicio];
            }else{
                for(int y = 0;y<no-1;y++){
                    /*nesse laço é percorrido todo a linha do ponto de 
                    partida para ver qual é o caminho de menor custo*/
                    if(matadj[inicio][y]<menor && matadj[inicio][y]!=0){
                        caminho[insere] = y;
                        menor = matadj[inicio][y];
                    }
                }
                custo +=matadj[inicio][caminho[insere]];//atualização do valor do custo
                for(int y = 0;y<no;y++){
                    /*esse laço zera toda a coluna da matriz de adjacência referente
                    //a cidade na qual o caixeiro acabou de sair, para evitar
                    que ele volte até ela;*/
                    matadj[y][caminho[insere]] = 0;
                }
                //atualizando o novo ponto de partida
                inicio = caminho[insere];
                insere++;
            }
        }
        System.out.println("O caminho tomado foi: ");
        for(int x=0;x<no-2;x++){
            System.out.print(caminho[x]+"-->");
        }
        System.out.println(caminho[no-2]);
        System.out.println("Soma dos trajetos: "+custo);
        
        long end = System.nanoTime();
                end = (end-tempo);
                System.out.println();
                System.out.println("Tempo de execução: ");
                System.out.println("Nanosegundos: "+end);
                System.out.println("Microsegundo: "+(end/1000));
                System.out.println("Milissegundo: "+(end/1000000));
                System.out.println("Segundo: "+(end/1000000000));
    }
    
}

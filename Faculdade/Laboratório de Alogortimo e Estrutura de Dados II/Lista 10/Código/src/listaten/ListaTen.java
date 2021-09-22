/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaten;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author Cristhian
 */
public class ListaTen {
    
     public static Grafo.Aresta lerAresta() throws Exception {
        System.out.println("Aresta:");
        System.out.print("  V1:");
        int v1 = Integer.parseInt(in.readLine());
        System.out.print("  V2:");
        int v2 = Integer.parseInt(in.readLine());
        System.out.print("  Peso:");
        int peso = Integer.parseInt(in.readLine());
        return new Grafo.Aresta(v1, v2, peso);
    }

    public static Grafo.Aresta lerAresta(int u, int v, int p) {
        int v1 = u, v2 = v, peso = p;
        return new Grafo.Aresta(v1, v2, peso);
    }

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
     Scanner input = new Scanner(System.in);

    

   
    //Solicita ao usuário a entrada dos dados do Grafo
        System.out.print ("No. vertices:"); //Início da Leitura do Grafo
    int nVertices = Integer.parseInt (in.readLine());
    System.out.print ("No. arestas:"); 
    int nArestas = Integer.parseInt (in.readLine()); //Término da Leitura
    Grafo grafo = new Grafo(nVertices);
        System.out.println("");
            for (int i = 0; i < nArestas; i++) {
                Grafo.Aresta a = lerAresta();
                grafo.insereArestaNaoOrientada(a.v1(), a.v2(), a.peso()); //Inserção de vértices e peso no Grafo   
                grafo.insereArestaNaoOrientada(a.v2(), a.v1(), a.peso());
            }
            AlgoritmosEmGrafos Algoritmos = new AlgoritmosEmGrafos(grafo);
            System.out.println("Qual será o experimento?");
            int op = input.nextInt();
            switch (op){
                case 1:
                    for(int x = 1;x<nVertices;x++){            
                        System.out.println("Cálculo de fluxo de 0 até "+x);
                        System.out.println("Fluxo máximo: "+Algoritmos.fordFulkerson(0, x, nVertices));
                    }
                break;
                
                case 2:
                    System.out.println("Qual será o início?");
                    int inicio = input.nextInt();
                    System.out.println("Qual será o fim?");
                    int fim  = input.nextInt();
                    System.out.println("Cálculo de fluxo de "+ inicio+" até "+fim+":");
                    System.out.println("O fluxo máximo é: "+Algoritmos.fordFulkerson(inicio, fim, nVertices));
            }
        }
    }
    

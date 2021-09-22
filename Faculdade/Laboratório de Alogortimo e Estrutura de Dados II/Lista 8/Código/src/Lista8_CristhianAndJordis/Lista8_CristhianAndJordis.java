package Lista8_CristhianAndJordis;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Jord&Cristhian
 */
public class Lista8_CristhianAndJordis {

    static BufferedReader in = new BufferedReader(
            new InputStreamReader(System.in));

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
    //Solicita ao usuário a entrada dos dados do Grafo
    public static void main(String[] args) throws Exception {
        System.out.print ("No. vertices:"); //Início da Leitura do Grafo
    int nVertices = Integer.parseInt (in.readLine());
    System.out.print ("No. arestas:"); 
    int nArestas = Integer.parseInt (in.readLine());
    System.out.print ("Raiz da ACMC:"); 
    int raiz = Integer.parseInt (in.readLine()); //Término da Leitura
    Grafo grafo = new Grafo(nVertices);
        System.out.println("Raiz : "+raiz);
        System.out.println("");
            for (int i = 0; i < nArestas; i++) {
                Grafo.Aresta a = lerAresta();
                grafo.insereArestaNaoOrientada(a.v1(), a.v2(), a.peso()); //Inserção de vértices e peso no Grafo   
                grafo.insereArestaNaoOrientada(a.v2(), a.v1(), a.peso());
            }
            grafo.imprime(); //Método de exibição da matriz de adjacência
            AlgoritmosEmGrafos Algoritmos = new AlgoritmosEmGrafos(grafo);
            Algoritmos.obterAgm(raiz);
            Algoritmos.imprime(); //Método para exibição dos caminhos do Grafo
            for(int x = 1;x<nVertices;x++){
                System.out.println("Nó: "+x);
                Algoritmos.antecessor(x);
            }
        }
}

package lista7agoravai;

import java.io.*;
import java.util.Scanner;
//import cap7.listaadj.autoreferencia.Grafo; /*-- vide Programa@{\it ~\ref{prog:estruturaslistaap}@ --*/

public class TestaDijkstra {

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

    public static void main(String[] args) throws Exception {
        /*System.out.print ("No. vertices:"); 
    int nVertices = Integer.parseInt (in.readLine());
    System.out.print ("No. arestas:"); 
    int nArestas = Integer.parseInt (in.readLine());
    System.out.print ("Raiz da ACMC:"); 
    int raiz = Integer.parseInt (in.readLine());*/
        int Primeira = 1;
        int vEntrada, vSaida, TotalEmArestas = 0,TotalEmVertices = 0;
       // try {
            Scanner leitor = new Scanner(new File("grafoa.txt"));
            Grafo grafo = null;
            while (leitor.hasNext()) {
                String linha = leitor.nextLine();
                String[] linhaaux = linha.split(" ");

                if (Primeira == 1) {
                    String Vertices = linhaaux[0];
                    String Arestas = linhaaux[1];
                    TotalEmVertices = Integer.valueOf(Vertices);
                    TotalEmArestas = Integer.valueOf(Arestas);
                    Primeira = 0;
                    grafo = new Grafo(TotalEmVertices);
                } else {
                    String verticeEntrada = linhaaux[0];
                    String verticeSaida = linhaaux[1];
                    String PesoEmString = linhaaux[2];
                    vEntrada = Integer.valueOf(verticeEntrada);
                    vSaida = Integer.valueOf(verticeSaida);
                    int PesoAresta = Integer.valueOf(PesoEmString);
                    grafo.insereAresta(vEntrada, vSaida, PesoAresta);

                }
            }
            for (int i = 0; i < TotalEmArestas; i++) {
                Grafo.Aresta a = lerAresta();
                // @{\it Duas chamadas porque o grafo \'e n\~ao direcionado}@
                grafo.insereAresta(a.v1(), a.v2(), a.peso());
                grafo.insereAresta(a.v2(), a.v1(), a.peso());
            }
            grafo.imprime();
            Dijkstra dj = new Dijkstra(grafo);
            dj.obterArvoreCMC(0);
            dj.imprime();
            dj.imprimeCaminho(0, TotalEmVertices-1);
        }
  //  }
  // / catch(IOException e){
   // e.printStackTrace();
   // }
}

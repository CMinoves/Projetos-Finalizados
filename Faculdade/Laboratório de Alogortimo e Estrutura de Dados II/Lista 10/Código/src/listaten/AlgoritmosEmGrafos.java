/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaten;

import java.util.LinkedList;

/**
 *
 * @author Cristhian
 * Inspirado no código encontrado em: https://www.geeksforgeeks.org/ford-fulkerson-algorithm-for-maximum-flow-problem/
 */
public class AlgoritmosEmGrafos {
     private int antecessor[];
  private double p[];
  private Grafo grafo;

  public AlgoritmosEmGrafos (Grafo grafo) {
      this.grafo = grafo; 
  }
  


    boolean bfs(int rGraph[][], int s, int t, int parent[], int V) 
    { 

        //Cria um vetor de nós visitados e coloca false para todos
        boolean visited[] = new boolean[V]; 
        for(int i=0; i<V; ++i) 
            visited[i]=false; 
  
        //cria a fila encadeada da origem até o destino
        LinkedList<Integer> queue = new LinkedList<Integer>(); 
        queue.add(s); 
        visited[s] = true; 
        parent[s]=-1; 
  
        //Loop padrão de Busca em Largura
        while (!queue.isEmpty()) 
        { 
            int u = queue.poll(); 
  
            for (int v=0; v<V; v++) 
            { 
                if (visited[v]==false && rGraph[u][v] > 0) 
                { 
                    queue.add(v); 
                    parent[v] = u; 
                    visited[v] = true; 
                } 
            } 
        } 
  

        //retorna verdadeiro ao chegar ao destino do fluxo
        return (visited[t] == true); 
    } 
  
    int fordFulkerson(int s, int t, int V) 
    { 
        int graph[][] = grafo.getMatrizAdjacencia();
        int u, v; 
        
        //criacao do grafo residual, o qual armazenará a capacidade residual entre as arestas adjacentes
        int rGraph[][] = new int[V][V]; 
  
        for (u = 0; u < V; u++) 
            for (v = 0; v < V; v++) 
                rGraph[u][v] = graph[u][v]; 
        //grafo residual é preenchido com o grafo original
        
        //grafo para armazenar a busca em largura
        int parent[] = new int[V]; 
  
        int max_flow = 0;  // inicializacao do fluxo
  

        while (bfs(rGraph, s, t, parent, V)) 
        { 
            //procurando o minimo residual do resultado da busca em largura
            int path_flow = Integer.MAX_VALUE; 
            for (v=t; v!=s; v=parent[v]) 
            { 
                u = parent[v]; 
                path_flow = Math.min(path_flow, rGraph[u][v]); 
            } 
  
            //atualizacao da capacidade residual da aresta e de de caminho inverso
            for (v=t; v != s; v=parent[v]) 
            { 
                u = parent[v]; 
                rGraph[u][v] -= path_flow; 
                rGraph[v][u] += path_flow; 
            } 
  
            // incrementacao do fluxo
            max_flow += path_flow; 
        } 
  
        //escrevendo a matriz de adjacência do fluxo
        System.out.println("Matriz  de adjacência: ");
        for(int x =s;x<=t;x++){
            for(int y = s;y<=t;y++){
                System.out.print(rGraph[x][y]+" ");
            }
            System.out.println();
        }
        return max_flow; 
    } 
}

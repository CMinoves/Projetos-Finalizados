
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Diego Santos e Mariana Bulgarelli
 */
// Implementacao dos metodos public Aresta primeiroListaAdj(int v), public Aresta proxAdj(int v) e  public boolean listaAdjVazia(int v) e da classe Aresta adaptadas de http://www2.dcc.ufmg.br/livros/algoritmos-java/implementacoes-07.php
public class Grafos {

    // Exe 1.2 - Atributos da classe
    private int numeroVertices;
    public static int[][] matrizAdjacencia;
    private int prox[];
    private int[] pos;  // posicao atual ao se percorrer os adjacentes de um vertice v

    // Método construtor que recebe vértices como parâmetro, inicializa todas as posições da matriz de adjacência com 0 e inicializa o numero de vertices.
    public Grafos(int vertices) {
        prox = new int[vertices];
        pos = new int[vertices];
        matrizAdjacencia = new int[vertices][vertices];
        for (int i = 0; i < vertices; i++) {
            prox[i] = 0;
            pos[i] = i;
            for (int j = 0; j < vertices; j++) {
                matrizAdjacencia[i][j] = 0;
            }
        }
        numeroVertices = vertices;
    }

    public static class Aresta {

        // Atributos da classe
        private int v1, v2;
        int peso;

        // Metodo construtor
        public Aresta(int v1, int v2, int peso) {
            this.v1 = v1;
            this.v2 = v2;
            this.peso = peso;
        }

        // Método que retorna o peso
        public int peso() {
            return this.peso;
        }

        //  Metodo que retorna o vertice 1
        public int v1() {
            return this.v1;
        }

        // Metodo que retorna o vertice 2
        public int v2() {
            return this.v2;
        }
    }

    // Método que insere na matriz de adjacencia uma nova aresta com seu determinado peso
    public void insereAresta(int vertice1, int vertice2, int peso) {
        this.matrizAdjacencia[vertice1][vertice2] = peso;
        //System.out.println("aresta "+ matrizAdjacencia[vertice1][vertice2]);
    }

    // Método que verifica a existência de determinada aresta entre vértices do grafo
    public boolean existeAresta(int vertice1, int vertice2) {
        return (this.matrizAdjacencia[vertice1][vertice2] != 0);
    }

    // Método que retorna a lista de vértices adjacentes a determinado vértice v
    public ArrayList<Integer> listaDeAdjacencia(int vertice1) {
        ArrayList<Integer> lista = new ArrayList<>();   // Cria array
        for (int i = 0; i < this.numeroVertices; i++) {
            if (this.matrizAdjacencia[vertice1][i] > 0) {
                lista.add(i);                           // Adiciona no array list
            }
        }
        return lista;
    }

    // Metodo que retorna o peso de uma aresta
    public int getPeso(int vertice1, int vertice2) {
        return this.matrizAdjacencia[vertice1][vertice2];
    }

    // Método que retorna o numero de vertices
    public int getNumeroVertices() {
        return numeroVertices;
    }

    // Método que retorna a matriz de adjacência
    public static int[][] getMatrizAdjacencia() {
        return matrizAdjacencia;
    }

    // Metodo que adiciona arestas na matriz de adjacencia
    public void insereArestaNaoOrientada(int vertice1, int vertice2, int peso) {
        this.insereAresta(vertice1, vertice2, peso);
        this.insereAresta(vertice2, vertice1, peso);
    }

    // retorna true or false dependendo se o valor de prox em determinada posição for igual ou diferente de 0
    public boolean listaAdjVazia(int v) {
        for (int i = 0; i < this.numeroVertices; i++) {
            if (this.matrizAdjacencia[v][i] > 0) {
                return false;
            }
        }
        return true;
    }

    // Retorna a proxima aresta que o vertice v participa ou null se a lista de adjacencia de v estiver no fim
    public Aresta proxAdj(int v) {
        this.pos[v]++;
        while ((this.pos[v] < this.numeroVertices) && (this.matrizAdjacencia[v][this.pos[v]] == 0)) {
            this.pos[v]++;
        }
        if (this.pos[v] == this.numeroVertices) {
            return null;
        } else {
            return new Aresta(v, this.pos[v], this.matrizAdjacencia[v][this.pos[v]]);
        }
    }

    // Retorna a primeira aresta que o vertice v participa ou null se a lista de adjacencia de v for vazia
    public Aresta primeiroListaAdj(int v) {
        this.pos[v] = -1;
        return this.proxAdj(v);
    }

    public void imprime() {
        System.out.print("   ");
        for (int i = 0; i < this.numeroVertices; i++) {
            System.out.print(i + "   ");
        }
        System.out.println();
        for (int i = 0; i < this.numeroVertices; i++) {
            System.out.print(i + "  ");
            for (int j = 0; j < this.numeroVertices; j++) {
                System.out.print(this.matrizAdjacencia[i][j] + "   ");
            }
            System.out.println();
        }
    }
}

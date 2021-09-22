package Lista8_CristhianAndJordis;
import java.util.ArrayList;

/**
 *
 * @author Jord&Cristhian
 */
public class Grafo {
    
    public static class Aresta {    //Classe Aresta que é inclusa em Grafo
        private int v1, v2, peso;
       
        public Aresta (int v1, int v2, int peso) {
            this.v1 = v1; 
            this.v2 = v2; 
            this.peso = peso;
        }
        
        public int peso () { 
            return this.peso; 
        }
        
        public int v1 () { 
            return this.v1; 
        }
        
        public int v2 () { 
            return this.v2; 
        }
            
    }
    
    private  int numeroVertices;
    private  int[][] matrizAdjacencia;
    private int pos[];
    
    // Método construtor que recebe vértices como parâmetro, inicializa todas as posições da matriz de adjacência com 0 e inicializa o numero de vertices.
    public Grafo(int vertices){
        matrizAdjacencia = new int[vertices][vertices];
        pos = new int[vertices];
        for(int i = 0; i < vertices; i++){
            for(int j = 0; j < vertices; j++){
                matrizAdjacencia[i][j] = 0;
            }
        }
        numeroVertices = vertices;
        for (int i = 0; i < this.numeroVertices; i++) {
            for (int j = 0; j < this.numeroVertices; j++) 
                this.matrizAdjacencia[i][j] = 0;
            this.pos[i] = -1; 
        }
    
    }
    
    // Método que insere na matriz de adjacencia uma nova aresta com seu determinado peso
    public void insereArestaNaoOrientada(int vertice1, int vertice2, int peso){
        this.matrizAdjacencia[vertice1][vertice2] = peso;
    }
    
    // Método que verifica a existência de determinada aresta entre vértices do grafo
    public boolean existeAresta(int vertice1, int vertice2){
        return (this.matrizAdjacencia[vertice1][vertice2] != 0);
    }
    

    public ArrayList<Integer> listaDeAdjacencia(int vertice1){
        ArrayList<Integer> lista = new ArrayList<>();   // Cria array
        for(int i = 0; i < this.numeroVertices;i++){
            if(this.matrizAdjacencia[vertice1][i] > 0)
                lista.add(i);                           // Adiciona no array list
        }
        return lista;
    }
    
    public boolean listaAdjVazia (int v) {  //Método que checa se a matriz de adjacêcia está vazia
        for (int i =0; i < this.numeroVertices; i++)
            if (this.matrizAdjacencia[v][i] > 0) 
                return false;
        return true;
    }
    
     public void imprime () {   //Método de exibição da matriz de adjacência
    System.out.print ("   ");
    for (int i = 0; i < this.numeroVertices; i++) 
      System.out.print (i + "   "); 
    System.out.println ();
    for (int i = 0; i < this.numeroVertices; i++) { 
      System.out.print (i + "  ");
      for (int j = 0; j < this.numeroVertices; j++)
        System.out.print (this.matrizAdjacencia[i][j] + "   ");
      System.out.println ();
    }
  }
     
    public Aresta proxAdj (int v) {
    this.pos[v] ++;
    while ((this.pos[v] < this.numeroVertices) && (this.matrizAdjacencia[v][this.pos[v]] == 0)) 
        this.pos[v]++;
    
    if (this.pos[v] == this.numeroVertices) 
        return null;
    else 
        return new Aresta (v, this.pos[v], this.matrizAdjacencia[v][this.pos[v]]);
    }
    
     public Aresta primeiroListaAdj (int v) {
    this.pos[v] = -1; 
    return this.proxAdj (v);
    }
     
    // Metodo que retorna o peso de uma aresta
    public int getPeso(int vertice1, int vertice2){
        return this.matrizAdjacencia[vertice1][vertice2];
    }

    // Método que retorna o numero de vertices
    public int getNumeroVertices() {
        return numeroVertices;
    }
    
    // Método que retorna a matriz de adjacência
    public int[][] getMatrizAdjacencia() {
        return matrizAdjacencia;
    }
}

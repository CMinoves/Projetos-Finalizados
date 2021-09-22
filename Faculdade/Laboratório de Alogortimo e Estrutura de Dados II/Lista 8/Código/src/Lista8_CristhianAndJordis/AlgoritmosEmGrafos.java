package Lista8_CristhianAndJordis;

public class AlgoritmosEmGrafos {
  private int antecessor[];
  private double p[];
  private Grafo grafo;

  public AlgoritmosEmGrafos (Grafo grafo) {
      this.grafo = grafo; 
  }
  
  public void obterAgm (int raiz) throws Exception {    //Método que obtém a Árvore Geradora Mínima
    int n = this.grafo.getNumeroVertices();
    this.p = new double[n]; 
    int vs[] = new int[n+1]; 
    boolean itensHeap[] = new boolean[n]; this.antecessor = new int[n];
    for (int u = 0; u < n; u ++) {
      this.antecessor[u] = -1;
      p[u] = Double.MAX_VALUE; 
      vs[u+1] = u; 
      itensHeap[u] = true;
    }
    p[raiz] = 0;
    FPHeapMinIndireto heap = new FPHeapMinIndireto (p, vs); 
    heap.constroi ();
    while (!heap.vazio ()) {
      int u = heap.retiraMin (); 
      itensHeap[u] = false;
      if (!this.grafo.listaAdjVazia (u)) {
        Grafo.Aresta adj = grafo.primeiroListaAdj (u);
        while (adj != null) {
          int v = adj.v2 ();
          if (itensHeap[v] && (adj.peso () < this.peso (v))) {
            antecessor[v] = u; heap.diminuiChave (v, adj.peso ());
          }
          adj = grafo.proxAdj (u);
        }
      }
    }
  }
  public void antecessor (int u) {  //Método para exibir o Pai do Nó em questão 
      System.out.println(this.antecessor[u]); 
  }
  
  public double peso (int u) {  //Método que retorna o peso da aresta
      return this.p[u]; 
  }
  
  public void imprime () {  //Método que exibe O Pai e o Nó filho, além do Peso total da Árvore
      int total = 0;
    for (int u = 0; u < this.p.length; u++)
      if (this.antecessor[u] != -1){ 
        System.out.println ("(" +antecessor[u]+ "," +u+ ") -- p:" +peso (u));
        total += peso(u);
      }
      System.out.println("Peso total: "+total);
  }
}

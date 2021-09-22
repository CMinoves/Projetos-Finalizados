/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista5;

/**
 *
 * @author Cristhian&Jordã
 */
public class ArvorePatricia {
  private static abstract class PatNo { }
  private static class PatNoInt extends PatNo {
    int index; PatNo esq, dir;
  }  
  private static class PatNoExt extends PatNo {
    char chave; // @{\it O tipo da chave depende da aplica\c{c}\~ao}@
  }
  
  private PatNo raiz;
  private int nbitsChave;
  private int[] Repetidos;
  private int nosvisitados;
  
 
  //Retorna o i'esimo bit da chave k a partir da esquerda
  private int bit (int i, char k) {
    if (i == 0) return 0;
    int c = (int)k;
    for (int j = 1; j <= this.nbitsChave - i; j++) c = c/2;
    return c % 2;
  }

  // @{\it Verifica se p \'e n\'o externo}@
  private boolean eExterno (PatNo p) {    
    Class classe = p.getClass ();
    return classe.getName().equals(PatNoExt.class.getName());
  }
  //criação de um novo nó interno
  private PatNo criaNoInt (int i, PatNo esq, PatNo dir) {
    PatNoInt p = new PatNoInt ();
    p.index = i; p.esq = esq; p.dir = dir;
    return p;
  }
  //criação de um novo nó interno
  private PatNo criaNoExt (char k) {
    PatNoExt p = new PatNoExt ();
    p.chave = k;
    return p;
  }
  
  boolean controle;
  //método privado para a busca de uma chave na árvore
  private boolean pesquisa (char k, PatNo t) {
    this.nosvisitados++;
    if (this.eExterno (t)) {
      PatNoExt aux = (PatNoExt)t;
      if (aux.chave == k) controle = true;//System.out.println ("Elemento encontrado");
      else controle = false; //System.out.println ("Elemento nao encontrado");
    }
    else { 
      PatNoInt aux = (PatNoInt)t;
      if (this.bit (aux.index, k) == 0) pesquisa (k, aux.esq);
      else pesquisa (k, aux.dir);
    }
    return controle;
  }
  //Método quando for necessário a inserção em um local anterior ao nó externo
  private PatNo insereEntre (char k, PatNo t, int i) {
    this.Repetidos[k]++;
    PatNoInt aux = null; 
    if (!this.eExterno (t)) aux = (PatNoInt)t;
    if (this.eExterno (t) || (i < aux.index)) { // @{\it Cria um novo n\'o externo}@
      PatNo p = this.criaNoExt (k);
      if (this.bit (i, k) == 1) return this.criaNoInt (i, t, p);
      else return this.criaNoInt (i, p, t);
    }
    else {
      if (this.bit (aux.index, k) == 1) 
        aux.dir = this.insereEntre (k, aux.dir, i);
      else aux.esq = this.insereEntre (k, aux.esq, i);
      return aux;
    }
  }
  //método privado que inicia o processo de inserção 
  private PatNo insere (char k, PatNo t) {
    if (t == null) return this.criaNoExt (k);
    else {
      PatNo p = t;
      while (!this.eExterno (p)) {
        PatNoInt aux = (PatNoInt)p;
        if (this.bit (aux.index, k) == 1) p = aux.dir; else p = aux.esq;
      }
      PatNoExt aux = (PatNoExt)p;
      int i = 1; // @{\it acha o primeiro bit diferente}@
      while ((i <= this.nbitsChave)&&
             (this.bit (i, k) == this.bit (i, aux.chave))) i++;
      if (i > this.nbitsChave) {
       // System.out.println ("Erro: chave ja esta na arvore");
        this.Repetidos[k]++;
        return t;
      }
      else return this.insereEntre (k, t, i);
    }
  }
  //método construtor da árovre
  public ArvorePatricia (int nbitsChave) {
    this.raiz = null; this.nbitsChave = nbitsChave; this.Repetidos = new int[256];
  }
  //método público que inica a pesquisa de um elemento
  public void pesquisa (char k) { this.pesquisa (k, this.raiz); }
  //método público que inica a inserção de um elemento
  public void insere (char k) { this.raiz = this.insere (k, this.raiz); } 
    //retorna o número de nós visitados
    public int getNosvisitados() {
        return nosvisitados;
    }
  //método público para saber quantos nós externos possui a árvore
  public void verRepeticoes(){
      char a = 0;
      int x = 0;
      while(a<256){
          controle = false;
          pesquisa(a);
          if(controle){
              x++;
          }
          a++;
        }
      System.out.println("Nós externos: "+x);
      }
  }


import java.util.ArrayList;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author disan
 */

//Nesta classe foi implementado o metodo de forca bruta utilizando a permutacao entre as cidades e calculando as distancias totais
public class ForcaBruta {
    private Grafos grafo;
    private ArrayList<ArrayList<Integer>>caminhosPossiveis;
    private ArrayList<Integer>menorCaminho;
    private int numVertices;
    private int menorDistancia;
    
    public ForcaBruta(int numVertices,Grafos grafo){
        this.grafo = grafo;
        caminhosPossiveis = new ArrayList<>();
        this.numVertices = numVertices;
        menorDistancia = Integer.MAX_VALUE;
        menorCaminho = null;
    }
    
    //este metodo calcula a distancia total em um caminho
    public int distanciaTotal(ArrayList<Integer> caminho,int verticeInicial){
        int soma = 0;
        if(grafo.existeAresta(verticeInicial,caminho.get(0))&&grafo.existeAresta(caminho.get(caminho.size()-1), verticeInicial)){
            soma += grafo.getPeso(verticeInicial, caminho.get(0));
            soma += grafo.getPeso(caminho.get(caminho.size()-1),verticeInicial);
            for(int i = 0; i < caminho.size()-1;i++){
                if(grafo.existeAresta(caminho.get(i), caminho.get(i+1))){
                    soma += grafo.getPeso(caminho.get(i), caminho.get(i+1));
                }else{
                    return Integer.MAX_VALUE;
                }
            }
            return soma;
        }else{
            return Integer.MAX_VALUE;
        }
        
    }
    
    //este metodo busca o menor caminho dentre de um grafo que contenha todos os vertices e volte para o vertice inicial (0)
    public void menorCaminho(int verticeInicial){
        caminhosPossiveis = Permutacao.permutacoesPossiveis(verticeInicial,numVertices);
        menorDistancia = Integer.MAX_VALUE;
        for(ArrayList<Integer> caminhoAtual: caminhosPossiveis){
            if(menorDistancia > distanciaTotal(caminhoAtual,verticeInicial)){
                menorDistancia = distanciaTotal(caminhoAtual,verticeInicial);
                menorCaminho = caminhoAtual;
            }
        }
        
        if(menorCaminho != null){
            menorCaminho.add(0,verticeInicial);
            menorCaminho.add(verticeInicial);
        }
    } 

    public Grafos getGrafo() {
        return grafo;
    }

    public void setGrafo(Grafos grafo) {
        this.grafo = grafo;
    }

    public ArrayList<Integer> getMenorCaminho() {
        return menorCaminho;
    }


    public int getNumVertices() {
        return numVertices;
    }

    public void setNumVertices(int numVertices) {
        this.numVertices = numVertices;
    }

    public int getMenorDistancia() {
        return menorDistancia;
    }
    
    
    
    
}

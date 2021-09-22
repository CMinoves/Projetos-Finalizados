
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templatesa
 * and open the template in the editor.
 */

/**
 *
 * @author disan
 */

//Esse classe servira para criar as permutacoes entre as cidades para que seja usada para encontrar a menor distancia entre elas
//Foi baseado no site http://bearcave.com/random_hacks/permute.html no algoritmo da Universidade de Exeter
public class Permutacao {
    
    public static ArrayList<ArrayList<Integer>> permutacoes;

    //gera o vetor que sera permutado sem o vertice inicial que sera adicionado posteriormente
    public static ArrayList<ArrayList<Integer>> permutacoesPossiveis(int verticeInicial, int numVertices) {
        permutacoes = new ArrayList<>();
        ArrayList<ArrayList<Integer>> permutacoesPossiveis = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> v = new ArrayList<>();
        SecureRandom random = new SecureRandom();
        while(v.size()!= numVertices-1){
            int n = random.nextInt(numVertices);
            if(n != verticeInicial&& !v.contains(n))
                v.add(n);
        }
        int []v1 = new int[numVertices-1];
        for(int i = 0; i < numVertices-1; i++){
            v1[i] = v.get(i);
        }
        
        permuta(v1,0,numVertices-1);
        
        
        
        return permutacoes;
        
    }
    //Algoritmo da Universidade de Exeter
    private static void permuta(int [] v, int inicio,int n) {
        if(inicio == n-1){
            if(v != null){
                ArrayList<Integer> permutaAtual = new ArrayList<>();
                for(int i = 0; i < n; i++){
                    permutaAtual.add(v[i]);
                }
                permutacoes.add(permutaAtual);
            }
        } else{
            for(int i = inicio; i < n; i++){
                int tmp = v[i];
                
                v[i] = v[inicio];
                v[inicio] = tmp;
                permuta(v,inicio+1,n);
                v[inicio] = v[i];
                v[i] = tmp;
            }
        }
    }
    
}

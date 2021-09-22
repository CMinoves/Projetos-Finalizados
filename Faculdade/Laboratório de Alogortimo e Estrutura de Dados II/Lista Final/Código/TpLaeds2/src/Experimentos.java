
import java.security.SecureRandom;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author disan
 */
public class Experimentos {

    public static void main(String[] args) {

        for (int i = 2; i < 15; i++) {
            System.out.println("##################################");
            System.out.println("Numero de cidades: " + i);
            Grafos g = gerarGrafo(i);
            ForcaBruta fb = new ForcaBruta(i, g);
            long tempoInicial = System.nanoTime();
            fb.menorCaminho(0);
            System.out.println("-------------------------");
            System.out.println("Tempo de execucao: " + (System.nanoTime() - tempoInicial) + "ns");
            System.out.println("-------------------------");
            if (fb.getMenorCaminho() != null) {
                for (int cidade : fb.getMenorCaminho()) {
                    System.out.print(cidade + "->");
                }
            } else {
                System.out.println("Nao e possivel passar por todas as cidades");
            }
            System.out.println("");
            System.out.println("Menor distancia: " + fb.getMenorDistancia());
        }

    }

    private static Grafos gerarGrafo(int i) {
        Grafos g = new Grafos(i);
        SecureRandom rand = new SecureRandom();
        for (int j = 0; j < i; j++) {
            for (int k = 0; k < i; k++) {
                if (j != k) {
                    g.insereAresta(j, k, rand.nextInt(100));
                }
            }
        }
        return g;
    }

}

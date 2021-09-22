/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mesa;

import java.security.SecureRandom;

/**
 *
 * @author aluno
 */
public class Baralho {
    private Carta baralho[];
    
    public Carta getCarta(int x){
        Carta c1 = new Carta();
        c1 = this.baralho[x];
        return c1;
    }

    public Baralho() { 
        baralho = new Carta [52];
        String nai[] = {"Copas", "Paus", "Ouros", "Espadas"};
        for(int x = 0; x<4; x++){
            for(int y = 1; y<=13;y++){
                baralho[(13*x)+(y-1)] = new Carta(y,nai[x]);
            }
        }
        //System.out.println(this.baralho.getCarta(2).getValor());
    }
    public void Embaralhar(){
        System.out.println("Baralho sendo embaralhado...");
        SecureRandom gerador = new SecureRandom();
        Carta aux = new Carta();
        int c1,c2;
        for(int x = 0;x<500;x++){
            c1 = gerador.nextInt(51);
            c2 = gerador.nextInt(51);
            aux = this.baralho[c1];
            this.baralho[c1] = this.baralho[c2];
            this.baralho[c2] = aux;
        }
    }
    
    
}

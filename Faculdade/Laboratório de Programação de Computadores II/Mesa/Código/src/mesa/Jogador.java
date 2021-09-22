/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mesa;

/**
 *
 * @author aluno
 */
public class Jogador {
    private Carta mao[];

    public Jogador() {
        mao = new Carta[26];
    }
    public void compraMao(Baralho b1,int handSize,int begin){
        if(begin == 0){
            for(int x = 0; x<handSize;x++){
                this.mao[x] = b1.getCarta(x);
            }
        }else{
            for(int x = 0;x<handSize;x++){
                this.mao[x] = b1.getCarta(50-x);
            }
        }
    }
    public Carta maiorCarta(int tam){
        Carta maior = new Carta();
        maior = this.mao[0];
        for(int x = 1; x<tam;x++){
            if(maior.getValor()<this.mao[x].getValor()){
                maior = this.mao[x];
            }else{
                if(maior.getValor()==this.mao[x].getValor() && this.mao[x].getNaipe().equals("Ouros")){
                   maior = this.mao[x];
                }
            }
        }
        return maior;
    }
}

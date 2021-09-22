/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testerelogio;

/**
 *
 * @author aluno
 */
public class Contador {
    private int valor;
    private int limite;

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    public Contador(int l, int v) {
        this.valor=v;
        this.limite = l;
    }
    
    public void incrementar(){
        this.valor = this.valor +1;
    }
}


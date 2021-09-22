/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formasdaoras;
import static java.lang.Math.*;

/**
 *
 * @author aluno
 */
public class Circulo extends FormaBidimensional{
    private double raio;
    
    public Circulo(double raio){
        super("Círculo");
        this.raio = raio;        
    }  
        @Override
    public double calculoVolume() {
            System.out.println("O círculo não tem volume");
            return -1;
    }

    @Override
    public double calculoArea() {
        double a;
        a = Math.PI*(Math.pow(this.raio, 2));
        this.setArea(a);
        return a;
    }
}

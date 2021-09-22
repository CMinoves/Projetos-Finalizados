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
public class Esfera extends FormaTridimensional{
    private double raio;
    public Esfera(double raio) {
        super("Esfera");
        this.raio = raio;
    }
    
        @Override
    public double calculoVolume() {
        double v;
        v = 4/3*Math.PI*Math.pow(raio, 3);
        this.setVolume(v);
        return v;
    }

    @Override
    public double calculoArea() {
        double a;
        a = 4*Math.PI*Math.pow(raio,2);
        this.setArea(a);
        return a;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formasdaoras;

/**
 *
 * @author aluno
 */
public class Cubo extends FormaTridimensional {
    
    private double aresta;
    
    public Cubo(double aresta) {
        super("Cubo");
        this.aresta = aresta;
    }
    
    @Override
    public double calculoVolume() {
        double v;
        v = aresta*aresta*aresta;
        this.setVolume(v);
        return v;
    }

    @Override
    public double calculoArea() {
        double a;
        a = 6*aresta*aresta;
        this.setArea(a);
        return a;
    }
    
}

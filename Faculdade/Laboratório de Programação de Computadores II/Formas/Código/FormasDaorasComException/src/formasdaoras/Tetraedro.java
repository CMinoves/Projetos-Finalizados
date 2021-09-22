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
public class Tetraedro extends FormaTridimensional{
    private double aresta;
    
    public Tetraedro(double aresta){
        super("Tetraedro");
        this.aresta = aresta;
    }
    
            @Override
    public double calculoVolume() {
        double v;
        v = Math.pow(aresta,3)*Math.sqrt(2)/12;
        this.setVolume(v);
        return v;
    }

    @Override
    public double calculoArea() {
        double a;
        a = Math.pow(aresta,2)*Math.sqrt(3);
        this.setArea(a);
        return a;
    }
}

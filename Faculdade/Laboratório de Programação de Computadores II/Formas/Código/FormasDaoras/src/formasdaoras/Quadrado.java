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
public class Quadrado extends FormaBidimensional{
    
    private double lado;
    
    public Quadrado(double lado){
        super("Quadrado");
        this.lado = lado;
    }
    
    @Override
    public double calculoVolume() {
            System.out.println("O quadrado não tem volume");
            return -1;
    }

    @Override
    public double calculoArea() {
        double a;
        a = lado*lado;
        this.setArea(a);
        return a;
    }
    
}

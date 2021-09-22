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
public class Triangulo extends FormaBidimensional{
    private double lado;
    
    public Triangulo(double lado){
        super("Triângulo");
        this.lado = lado;
    }

    @Override
    public double calculoArea() {
        double a;
        a = Math.sqrt(3)/4*Math.pow(lado, 2);
        this.setArea(a);
        return a;
    }
}

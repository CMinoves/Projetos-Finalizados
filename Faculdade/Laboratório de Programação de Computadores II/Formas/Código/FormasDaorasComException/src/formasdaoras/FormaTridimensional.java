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
public abstract class FormaTridimensional implements Forma {
   private String nome;
   private double area;
   private double volume;

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public FormaTridimensional(String nome) {
        this.nome = nome;
        this.area = 0;
        this.volume = 0;
    }

    public String getNome() {
        return nome;
    }
   
    @Override
    public double calculoVolume() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double calculoArea() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

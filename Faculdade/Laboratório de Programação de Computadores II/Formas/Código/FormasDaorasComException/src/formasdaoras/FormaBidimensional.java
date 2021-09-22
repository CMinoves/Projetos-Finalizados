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
public abstract class FormaBidimensional implements Forma{
    private String nome;
    private double area;
    
    public FormaBidimensional(String nome){
        this.nome = nome;
        this.area = 0;
    }   

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getNome() {
        return nome;
    }
    
    @Override
    public double calculoVolume() throws NaoExisteVolumeException{
        throw new NaoExisteVolumeException();
    }


    @Override
    public double calculoArea() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

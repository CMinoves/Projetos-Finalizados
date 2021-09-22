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
public class Relogio {
    private Contador hora;
    private Contador minuto;
    private String formato;

    public Relogio(int limiteh, int valorh, int limitem, int valorm) {
        hora = new Contador(limiteh, valorh);
        minuto = new Contador(limitem, valorm);
        formato = "a.m";
    }
    
    public Contador getHora() {
        return hora;
    }

    public void setHora(Contador hora) {
        this.hora = hora;
    }

    public Contador getMinuto() {
        return minuto;
    }

    public void setMinuto(Contador minuto) {
        this.minuto = minuto;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }
    public void Tictac(){
        if(this.minuto.getLimite() != minuto.getValor()){
            minuto.incrementar();
            MostrarRelogio();
        }else{
            if(hora.getLimite()==12 && hora.getValor()==12 && minuto.getValor()==59){ //1
                hora.setValor(01);
            }else{
            hora.incrementar();
            } //end 1
            minuto.setValor(00);
            if(hora.getLimite()==12 && hora.getValor()==12 && minuto.getValor()==00){ //2
            //hora.setValor(01);
            //minuto.setValor(00);
                if("a.m".equals(getFormato())){
                    setFormato("p.m");
                }else{
                    setFormato("a.m");
                }
                MostrarRelogio();
            } // end 2
        }
    }
    public void MostrarRelogio(){
        if (hora.getLimite()==24){
            if(hora.getValor()<10){
                if(minuto.getValor()<10){
                   System.out.println("0"+hora.getValor()+":0"+minuto.getValor()); 
                }else{
                    System.out.println("0"+hora.getValor()+":"+minuto.getValor());
                }
            }else{
                if(minuto.getValor()<10){
                    System.out.println(""+hora.getValor()+":0"+minuto.getValor());
                }else{
                    System.out.println(hora.getValor()+":"+minuto.getValor());
                }
            }
        }else{
            if(hora.getValor()<10){
                if(minuto.getValor()<10){
                   System.out.println("0"+hora.getValor()+":0"+minuto.getValor()+" "+formato); 
                }else{
                    System.out.println("0"+hora.getValor()+":"+minuto.getValor()+" "+formato);
                }
            }else{
                if(minuto.getValor()<10){
                    System.out.println(hora.getValor()+":0"+minuto.getValor()+" "+formato);
                }else{
                    System.out.println(hora.getValor()+":"+minuto.getValor()+" "+formato);
                }

        }
      }
    }
    public void troca(int num){
        this.minuto.setLimite(num);
    }
}

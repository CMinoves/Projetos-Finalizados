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
public class TesteRelogio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Relogio clock12 = new Relogio(12, 0, 59,-1);
        Relogio clock24 = new Relogio(24,0,59,-1);
        System.out.println("Relógio de 12 horas");
        for(int x = 0; x<1440;x++){
            clock12.Tictac();
        }
        System.out.println("Relógio de 24 horas");
        for(int x = 0; x<1440;x++){
            clock24.Tictac();
        }
    }
    
}

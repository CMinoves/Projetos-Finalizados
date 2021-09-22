/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formasdaoras;

/**
 *
 * @author Cristhian
 */
public class NaoExisteVolumeException extends Exception {
    
    
    public NaoExisteVolumeException(){
        super("Formas Bidimensionais não têm volume");
    }
}

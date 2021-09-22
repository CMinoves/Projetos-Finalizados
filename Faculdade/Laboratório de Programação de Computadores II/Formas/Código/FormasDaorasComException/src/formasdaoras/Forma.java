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
public interface Forma {
    public double calculoVolume() throws NaoExisteVolumeException ;
    public double calculoArea() ;
}

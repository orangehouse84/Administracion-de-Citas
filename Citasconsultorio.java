/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package orangehouse.citasconsultorio;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oscar
 */
public class Citasconsultorio {

    public static void main(String args[]) {
        try {
            InterfazGrafica interfaz = new InterfazGrafica(); 
        } catch (IOException ex) {
            Logger.getLogger(Citasconsultorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
   





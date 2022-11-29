/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;
import java.io.*;

/**
 *
 * @author Carvajal-Triviño
 */
// 4.actualizacion: 5 min
// 3.retiro: 4 min
// 2.deposito: 3 min
// 1.pago de servicios: 2 min
// 0.consulta: 1.5 min
public class ProcesoRegistro {
    PilaR conjuntoProceso[];

    public ProcesoRegistro() {
        for (int i = 0; i <= 4; i++) {
            PilaR proceso = new PilaR();
            conjuntoProceso[i] = proceso;
        }
        
       
    }

    void alcacenamiento() throws IOException{
        for (int i = 0; i <= 4; i++) {
            conjuntoProceso[i].guardarRegistro();
        }
    }
}

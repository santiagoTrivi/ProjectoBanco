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
    PilaR conjuntoProceso[] = new PilaR[5];

    public ProcesoRegistro() {
        for (int i = 0; i <= 4; i++) {
            PilaR proceso = new PilaR();
            conjuntoProceso[i] = proceso;
        }
        
       
    }
    void insertarData(Persona data){
        switch (data.getSolicitud()){
            case "consulta":
                conjuntoProceso[0].insertar(data);
            break;
            case "pago":
                conjuntoProceso[1].insertar(data);
            break;
            case "deposito":
                conjuntoProceso[2].insertar(data);
            break;
            case "retiro":
                conjuntoProceso[3].insertar(data);
            case "actualizacion":
                conjuntoProceso[4].insertar(data);
            break;
        }
    }
    void alcacenamiento() throws IOException{
        for (int i = 0; i <= 4; i++) {
            conjuntoProceso[i].guardarRegistro();
        }
    }
}

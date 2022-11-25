package banco;
import java.io.*;
import java.time.*;
// 5.actualizacion: 5 min
// 4.retiro: 4min
// 3.deposito: 3min
// 2.pago de servicios: 2 min
// 1.consulta: 1.5 min

/**
 *
 * @author Carvajal-Triviño
 */
public class Banco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        LocalTime hora = LocalTime.of(8, 0);
        LocalTime horaCierre = LocalTime.of(15, 30);
        ColaPersonas a = new ColaPersonas();
        a.cargarDocumento();
        Nodo persona = new Nodo();
        persona = a.decencolar();
        System.out.println(persona.getCliente().getNombre());
        persona = a.decencolar();
        System.out.println(persona.getCliente().getNombre());
        
        
    }
    
}

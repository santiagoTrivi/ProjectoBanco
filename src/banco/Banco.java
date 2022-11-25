package banco;
import java.io.*;
import java.time.*;

// 5.actualizacion: 5 min
// 4.retiro: 4min
// 3.deposito: 3min
// 2.pago de servicios: 2 min
// 1.consulta: 1.5 min

public class Banco {

    
    public static void main(String[] args) throws IOException {
    
        LocalTime hora = LocalTime.of(8, 0);
        LocalTime horaCierre = LocalTime.of(16, 0);
        int comparacion = hora.compareTo(horaCierre);
        while(comparacion < 0){
            System.out.println(hora);
            hora = hora.plusMinutes(30);
            comparacion = hora.compareTo(horaCierre);
        }
        
        Cola colaprioridad = new Cola(Boolean.TRUE);
        Cola cola   = new Cola(Boolean.FALSE);   
    }
}

        
        
        
        
        
         
                 
        
    
        
    

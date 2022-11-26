package banco;
import java.io.*;
import java.time.*;

// 5.actualizacion: 5 min
// 4.retiro: 4 min
// 3.deposito: 3 min
// 2.pago de servicios: 2 min
// 1.consulta: 1.5 min

public class Banco {

    
    public static void main(String[] args) throws IOException {
    
        LocalTime hora = LocalTime.of(8, 0);
        LocalTime horaCierre = LocalTime.of(16, 0);
        int comparacion = hora.compareTo(horaCierre);
        Cola colaprioridad = new Cola(Boolean.TRUE);
        Cola cola  = new Cola(Boolean.FALSE); 
        
        while(comparacion < 0){
            String x = cola.decencolar().getCliente().getSolicitud();
            switch (x){
                case "consulta":
                    hora = hora.plusMinutes(1);
                    comparacion = hora.compareTo(horaCierre);
                break;
                case "pago":
                    hora = hora.plusMinutes(2);
                    comparacion = hora.compareTo(horaCierre);
                break;
                case "deposito":
                    hora = hora.plusMinutes(3);
                    comparacion = hora.compareTo(horaCierre);
                break;
                case "retiro":
                    hora = hora.plusMinutes(4);
                    comparacion = hora.compareTo(horaCierre);
                case "actualizacion":
                    hora = hora.plusMinutes(5);
                    comparacion = hora.compareTo(horaCierre);
                break;
            }
        } 
        
    }
}

        
        
        
        
        
         
                 
        
    
        
    

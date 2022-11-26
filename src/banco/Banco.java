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
        Cola colaprioridad = new Cola(Boolean.TRUE);
        Cola cola  = new Cola(Boolean.FALSE); 
        
        Integer atendidos = 0;
        while(hora.isBefore(horaCierre)){
            if (colaprioridad.isEmpty() && cola.isEmpty()) {
                System.out.println("Todos los clientes fueron atendidos, restan horas de trabajo: " + Math.abs(horaCierre.minusHours(hora.getHour()).getHour()));
                break;
            }
            
            String x;
            if (atendidos > 4) {
                if (colaprioridad.isEmpty()) {
                    continue;
                }
                x = colaprioridad.decencolar().getCliente().getSolicitud();
                atendidos = 0;
            } else {
                if (cola.isEmpty()) {
                    atendidos++;
                    continue;
                }
                x = cola.decencolar().getCliente().getSolicitud(); 
            }

            switch (x.toLowerCase()){
                case "consulta":
                    hora = hora.plusMinutes(1).plusSeconds(30);
                break;
                case "pago":
                    hora = hora.plusMinutes(2);
                break;
                case "deposito":
                    hora = hora.plusMinutes(3);
                break;
                case "retiro":
                    hora = hora.plusMinutes(4);
                case "actualizacion":
                    hora = hora.plusMinutes(5);
                break;
            }
            atendidos++;
        } 
        cola.guardarPendientes();
        colaprioridad.guardarPendientes();
    }
}

        
        
        
        
        
         
                 
        
    
        
    

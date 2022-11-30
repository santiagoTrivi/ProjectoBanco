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
        ProcesoRegistro procesoregistro = new ProcesoRegistro();
        LocalTime hora = LocalTime.of(8, 0);
        LocalTime horaCierre = LocalTime.of(16, 0);
        Cola colaprioridad = new Cola(Boolean.TRUE);
        Cola cola  = new Cola(Boolean.FALSE); 
        PilaR registro = new PilaR();


        
        Integer atendidos = 0;
        while(hora.isBefore(horaCierre)){
            if (colaprioridad.isEmpty() && cola.isEmpty()) {
                System.out.println("Todos los clientes fueron atendidos, restan horas de trabajo: " + Math.abs(horaCierre.minusHours(hora.getHour()).getHour()));
                break;
            }
            
            Nodo ciudadano;
            if (atendidos > 4) {
                if (colaprioridad.isEmpty()) {
                    continue;
                }
                ciudadano = colaprioridad.decencolar();
                switch (ciudadano.getCliente().getSolicitud().toLowerCase()){
                case "consulta":
                    hora = hora.plusMinutes(1).plusSeconds(50);
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
                atendidos = 0;
            } else {
                if (cola.isEmpty()) {
                    atendidos++;
                    continue;
                }
                ciudadano = cola.decencolar();
                switch (ciudadano.getCliente().getSolicitud().toLowerCase()){
                case "consulta":
                    hora = hora.plusMinutes(1).plusSeconds(50);
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
            }

            procesoregistro.insertarData(ciudadano.getCliente());
            atendidos++;
        } 
        procesoregistro.alcacenamiento();
        cola.guardarPendientes();
        colaprioridad.guardarPendientes();
        registro.guardarRegistro();

    }
}

        
        
        
        
        
         
                 
        
    
        
    

package banco;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;


public class Cola {
    private Nodo inicio, finalc;
    private Boolean prioridad;
    
    void encolar(Persona k) throws IOException {
        Nodo nodo = new Nodo();
        nodo.setCliente(k);
        if(this.inicio == null){
            this.inicio = this.finalc = nodo;  
        }else{
            this.finalc.setSiguiente(nodo);
            this.finalc = this.finalc.getSiguiente();
        }   
        System.out.println(k.toString());
    }
    
    public Cola(Boolean pri) throws IOException {
        this.prioridad = pri;
        this.inicio = null;
        this.finalc = null;   
        this.cargarDocumento();
    }
 
    Nodo decencolar(){
        if(this.isEmpty()){
            System.out.println("No hay nadie en la cola");
            return null;
        }else{
            Nodo temp = this.inicio;
            this.inicio = this.inicio.getSiguiente();
            temp.setSiguiente(null);
            return temp;
        }
    }
  
    boolean isEmpty(){
        return inicio == null;
    }
    
        
      void cargarDocumento() throws IOException{
       // Scanner fileP = new Scanner(new File("clientesPendientes"));//
        Scanner file = new Scanner(new File("clientes.txt"));
      // this.action(fileP);//
        while(file.hasNextLine()){
            String[] datos; // nombre, appelido, cedula, solicitud, prioridad}
            datos = file.nextLine().split(";");
            Persona cliente = new Persona();
            cliente.setNombre(datos[0]);
            cliente.setApellido(datos[1]);
            cliente.setCedula(datos[2]);
            cliente.setSolicitud(datos[3]);
            cliente.setPrioridad(Boolean.parseBoolean(datos[4]));
            
            if (this.prioridad == cliente.isPrioridad()) {
                this.encolar(cliente);
            }
            
        }
    }
}

    


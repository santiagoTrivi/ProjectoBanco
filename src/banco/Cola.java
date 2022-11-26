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
        nodo.setSiguiente(null);
        if(this.inicio == null && this.finalc == null){
            this.inicio = nodo;
            this.finalc = nodo;  
        }
        
        this.finalc.setSiguiente(nodo);
        this.finalc = this.finalc.getSiguiente();
    }
    
    public Cola(Boolean pri) throws IOException {
        this.prioridad = pri;
        this.inicio = null;
        this.finalc = null;   
        this.cargarDocumento(new String[]{"clientesPendientes.txt", "clientes.txt"});
    }
 
    Nodo decencolar(){
        if(this.isEmpty()){
            System.out.println("No hay nadie en la cola");
            return null;
        }else{
            Nodo temp = this.inicio;
            this.inicio = this.inicio.getSiguiente();
            temp.setSiguiente(null);
                System.out.println(temp.getCliente().toString());

            return temp;
        }

    }
  
    boolean isEmpty(){
        return inicio == null;
    }
    
        
    void cargarDocumento(String[] archivos) throws IOException{
        Scanner file = null;
        for (int i=0;i<archivos.length;i++)
           // Scanner fileP = new Scanner(new File("clientesPendientes"));//
                file = new Scanner(new File(archivos[i]));
          // this.action(fileP);//
            while(file.hasNextLine()){
                String[] datos; // nombre, apelido, cedula, solicitud, prioridad}
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
    
    void guardarPendientes() throws IOException {

        String archivo = "clientesPendientes.txt";
        while(!this.isEmpty()) {
            Persona cliente = null;
            cliente = this.decencolar().getCliente();
                try ( FileWriter fw = new FileWriter(archivo, true);  BufferedWriter bw = new BufferedWriter(fw);  PrintWriter out = new PrintWriter(bw)) {
                    out.println(cliente.toString());
                } catch (IOException e) {
                //exception handling left as an exercise for the reader
                }
           // }
        }
    }
}

    


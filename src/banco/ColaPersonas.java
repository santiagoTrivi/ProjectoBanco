package banco;
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author Carvajal-Triviño
 */
class persona{
    private String nombre, apellido;
    private int cedula;
    private String solicitud;
    private boolean prioridad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(String solicitud) {
        this.solicitud = solicitud;
    }

    public boolean isPrioridad() {
        return prioridad;
    }

    public void setPrioridad(boolean prioridad) {
        this.prioridad = prioridad;
    }      
}
class Nodo{
    private Nodo siguiente;
    private persona cliente;

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public persona getCliente() {
        return cliente;
    }

    public void setCliente(persona cliente) {
        this.cliente = cliente;
    }
}
public class ColaPersonas {
    private Nodo inicio, finalc;
    void encolar(persona p){
        Nodo nodo = new Nodo();
        nodo.setCliente(p);
        if(this.inicio == null){
            this.inicio = this.finalc = nodo;  
        }else{
            this.finalc.setSiguiente(nodo);
            this.finalc = this.finalc.getSiguiente();
        }   
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
    Nodo decencolarPriori(){
        Nodo prioridad = null;
        if (this.isEmpty()) {
            System.out.println("la cola esta vacia");
            return null;
        }else{
            ColaPersonas colaAux = new ColaPersonas();
            while(!this.isEmpty() && prioridad != null){
                Nodo temp = this.decencolar();
                if (temp.getCliente().isPrioridad()) {
                    prioridad = temp;
                }else{
                    colaAux.encolar(temp.getCliente()); //queueAux.enqueue(temp.valor, temp.prioridad);
                }
            }
            if (prioridad == null) {
                prioridad = colaAux.decencolar(); //queueAux.dequeue();
            }
            while(!this.isEmpty()){
                Nodo temp = this.decencolar();
                colaAux.encolar(temp.getCliente());
                //queueAux.enqueue(temp.valor, temp.prioridad);
            }
            this.inicio = colaAux.inicio; //queueAux.front;
            this.finalc = colaAux.finalc; //queueAux.rear;
            return prioridad;
        }    
    }        
    
    boolean isEmpty(){
        return inicio == null;
    }
    void cargarDocumento() throws IOException{
       // Scanner fileP = new Scanner(new File("clientesPendientes"));//
        Scanner file = new Scanner(new File("clientes.txt"));
      // this.action(fileP);//
        while(file.hasNext()){
            String[] datos; // nombre, appelido, cedula, solicitud, prioridad
            datos = file.nextLine().split(";");
            persona cliente = new persona();
            cliente.setNombre(datos[0]);
            cliente.setApellido(datos[1]);
            cliente.setCedula(Integer.parseInt(datos[2]));
            cliente.setSolicitud(datos[3]);
            cliente.setPrioridad(Boolean.parseBoolean(datos[4]));
            this.encolar(cliente);
        }
        
        /*this.action(file);
        File archivo = new File("clientesPendientes");
        archivo.delete(); */
    }
}

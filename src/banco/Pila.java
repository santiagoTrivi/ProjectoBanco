package banco;
import java.io.*;

public class Pila {

class Nodo{
    private Persona clienteA; 
    private Nodo down;

    public Persona getClienteA() {
        return clienteA;
    }

    public void setClienteA(Persona clienteA) {
        this.clienteA = clienteA;
    }

    public Nodo getDown() {
        return down;
    }

    public void setDown(Nodo down) {
        this.down = down;
    }
    
}
public class pila {
    private Nodo top;

    void insertar(Persona k){
        Nodo nodo = new Nodo();
        nodo.setClienteA(k);
        if(top == null){
            top = nodo;
        }else{
            nodo.setDown(top);
            this.top = nodo;
        }
    }
    boolean isEmpty(){
        return this.top == null; 
    }
    Nodo pop(){
        Nodo temp;
        if (this.isEmpty()){
            System.out.println("Pila Vacia");
            return null;
        }else{
            temp = this.top;
            this.top = this.top.getDown();
            temp.setDown(null);
            return temp;
        }
    }
         void guardarRegistro() throws IOException{
         while(!this.isEmpty()){
            Nodo aux = this.top;
            String archivo = "Taquilla.txt";
            try(FileWriter fw = new FileWriter(archivo, true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter out = new PrintWriter(bw))
                {
                    out.println(aux.getClienteA().toString());
                    
                } catch (IOException e) {
                    //exception handling left as an exercise for the reader
                }
            this.pop();
        }
           
    }
        }
        
        
       
        
    
}

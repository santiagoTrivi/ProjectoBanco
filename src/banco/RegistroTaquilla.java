/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

/**
 *
 * @author Carvajal-Triviño
 */
class NodoPila{
    private persona clienteA; 
    private NodoPila down;

    public persona getClienteA() {
        return clienteA;
    }

    public void setClienteA(persona clienteA) {
        this.clienteA = clienteA;
    }

    public NodoPila getDown() {
        return down;
    }

    public void setDown(NodoPila down) {
        this.down = down;
    }
    
}
public class RegistroTaquilla {
    private NodoPila top;

    void insertar(persona clp){
        NodoPila nodo = new NodoPila();
        nodo.setClienteA(clp);
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
    NodoPila pop(){
        NodoPila temp;
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
}

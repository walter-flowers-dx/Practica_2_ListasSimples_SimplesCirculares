package Ejercicio_8;

public class ListaSimpleClientes {
    protected NodoClientes P; 
    
    public ListaSimpleClientes() {
        P = null;       
    }

    public NodoClientes getP() {
        return P;
    }

    public void setP(NodoClientes p) {
        P = p;
    }
}
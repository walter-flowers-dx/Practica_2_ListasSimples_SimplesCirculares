package Ejercicio_10;

public class ListaSimpleHechizos {
	protected NodoHechizos P;  //raiz de la lista
	
	public ListaSimpleHechizos() {
		P = null;		// la raiz apunta a nullo es decir
						// se define una lista simple vacia
	}

	public NodoHechizos getP() {
		return P;
	}

	public void setP(NodoHechizos p) {
		this.P = p;
	}
}

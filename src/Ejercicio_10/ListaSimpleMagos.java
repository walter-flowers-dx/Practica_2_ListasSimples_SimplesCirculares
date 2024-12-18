package Ejercicio_10;

public class ListaSimpleMagos {
	protected NodoMagos P;  //raiz de la lista
	
	public ListaSimpleMagos() {
		P = null;		// la raiz apunta a nullo es decir
						// se define una lista simple vacia
	}

	public NodoMagos getP() {
		return P;
	}

	public void setP(NodoMagos p) {
		this.P = p;
	}
	
}

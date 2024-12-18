package Ejercicio_6;

public class ListaSimplePaises {
	protected NodoPaises P;  //raiz de la lista
	
	public ListaSimplePaises() {
		P = null;		// la raiz apunta a nullo es decir
						// se define una lista simple vacia
	}

	public NodoPaises getP() {
		return P;
	}

	public void setP(NodoPaises p) {
		this.P = p;
	}
	
}

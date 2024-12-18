package Ejercicio_2;

public class ListaSimplePeliculas {
	protected NodoPeliculas P;  //raiz de la lista
	
	public ListaSimplePeliculas() {
		P = null;		// la raiz apunta a nullo es decir
						// se define una lista simple vacia
	}

	public NodoPeliculas getP() {
		return P;
	}

	public void setP(NodoPeliculas p) {
		P = p;
	}
	
}

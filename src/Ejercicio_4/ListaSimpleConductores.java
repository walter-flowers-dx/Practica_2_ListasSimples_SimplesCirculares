package Ejercicio_4;

public class ListaSimpleConductores {
	protected NodoConductores P;  //raiz de la lista
	
	public ListaSimpleConductores() {
		P = null;		// la raiz apunta a nullo es decir
						// se define una lista simple vacia
	}

	public NodoConductores getP() {
		return P;
	}

	public void setP(NodoConductores p) {
		P = p;
	}
	
}

package Ejercicio_4;

public class ListaSimpleVehiculos {
	protected NodoVehiculos P;  //raiz de la lista
	
	public ListaSimpleVehiculos() {
		P = null;		// la raiz apunta a nullo es decir
						// se define una lista simple vacia
	}

	public NodoVehiculos getP() {
		return P;
	}

	public void setP(NodoVehiculos p) {
		P = p;
	}
	
}

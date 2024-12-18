//Marcelo Aruquipa
package Ejercicio_8;

public class ListaSimpleVentas {
	protected NodoVentas P;  //raiz de la lista
	
	public ListaSimpleVentas() {
		P = null;		// la raiz apunta a nullo es decir
						// se define una lista simple vacia
	}

	public NodoVentas getP() {
		return P;
	}

	public void setP(NodoVentas p) {
		this.P = p;
	}
	
}

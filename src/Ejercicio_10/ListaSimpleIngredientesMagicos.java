package Ejercicio_10;

public class ListaSimpleIngredientesMagicos {
 protected NodoIngredientesMagicos P;  //raiz de la lista
	
	public ListaSimpleIngredientesMagicos() {
		P = null;		// la raiz apunta a nullo es decir
						// se define una lista simple vacia
	}

	public NodoIngredientesMagicos getP() {
		return P;
	}

	public void setP(NodoIngredientesMagicos p) {
		P = p;
	}
}

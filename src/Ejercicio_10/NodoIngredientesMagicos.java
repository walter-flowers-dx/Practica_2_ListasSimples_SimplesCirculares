package Ejercicio_10;

public class NodoIngredientesMagicos {
	private IngredientesMagicos q;  //define el dato objeto persona
	private NodoIngredientesMagicos sig; //definiendo el campo enlace sig
	
	public NodoIngredientesMagicos() {  //constructor
		sig = null;
	}

	public IngredientesMagicos getQ() {
		return q;
	}

	public void setQ(IngredientesMagicos q) {
		this.q = q;
	}

	public NodoIngredientesMagicos getSig() {
		return sig;
	}

	public void setSig(NodoIngredientesMagicos sig) {
		this.sig = sig;
	}
	
}

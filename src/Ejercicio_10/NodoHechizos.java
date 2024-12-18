package Ejercicio_10;

public class NodoHechizos {
	private Hechizos hechizos;
	private NodoHechizos sig; //definiendo el campo enlace sig
	
	public NodoHechizos() {  //constructor
		sig = null;
	}

	public Hechizos getHechizos() {
		return hechizos;
	}

	public void setHechizos(Hechizos hechizos) {
		this.hechizos = hechizos;
	}

	public NodoHechizos getSig() {
		return sig;
	}

	public void setSig(NodoHechizos sig) {
		this.sig = sig;
	}

	
}

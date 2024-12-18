package Ejercicio_10;

public class NodoMagos {
	private Magos magos;
	
	private NodoMagos sig; //definiendo el campo enlace sig
	
	public NodoMagos() {  //constructor
		sig = null;
	}

	public Magos getMagos() {
		return magos;
	}

	public void setMagos(Magos magos) {
		this.magos = magos;
	}

	public NodoMagos getSig() {
		return sig;
	}

	public void setSig(NodoMagos sig) {
		this.sig = sig;
	}
	
	
}
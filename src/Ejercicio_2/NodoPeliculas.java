package Ejercicio_2;

public class NodoPeliculas {
	private Peliculas q;  //define el dato objeto Peliculas
	private NodoPeliculas sig; //definiendo el campo enlace sig
	
	public NodoPeliculas() {  //constructor
		sig = null;
	}

	public Peliculas getQ() {
		return q;
	}

	public void setQ(Peliculas q) {
		this.q = q;
	}

	public NodoPeliculas getSig() {
		return sig;
	}

	public void setSig(NodoPeliculas sig) {
		this.sig = sig;
	}
	
}

package Ejercicio_4;

public class NodoConductores {
	private Conductores q;  //define el dato objeto Conductores
	private NodoConductores sig; //definiendo el campo enlace sig
	
	public NodoConductores() {  //constructor
		sig = null;
	}

	public Conductores getQ() {
		return q;
	}

	public void setQ(Conductores q) {
		this.q = q;
	}

	public NodoConductores getSig() {
		return sig;
	}

	public void setSig(NodoConductores sig) {
		this.sig = sig;
	}
	
}

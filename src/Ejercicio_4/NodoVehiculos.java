package Ejercicio_4;

public class NodoVehiculos {
	private Vehiculos q;  //define el dato objeto Vehiculos
	private NodoVehiculos sig; //definiendo el campo enlace sig
	
	public NodoVehiculos() {  //constructor
		sig = null;
	}

	public Vehiculos getQ() {
		return q;
	}

	public void setQ(Vehiculos q) {
		this.q = q;
	}

	public NodoVehiculos getSig() {
		return sig;
	}

	public void setSig(NodoVehiculos sig) {
		this.sig = sig;
	}
	
}

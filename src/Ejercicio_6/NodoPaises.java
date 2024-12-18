package Ejercicio_6;

public class NodoPaises {
	private String pais;  //define el dato objeto persona
	private String idiomaOficial;
	
	private NodoPaises sig; //definiendo el campo enlace sig
	
	public NodoPaises() {  //constructor
		sig = null;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getIdiomaOficial() {
		return idiomaOficial;
	}

	public void setIdiomaOficial(String idiomaOficial) {
		this.idiomaOficial = idiomaOficial;
	}

	public NodoPaises getSig() {
		return sig;
	}

	public void setSig(NodoPaises sig) {
		this.sig = sig;
	}
	
	
}
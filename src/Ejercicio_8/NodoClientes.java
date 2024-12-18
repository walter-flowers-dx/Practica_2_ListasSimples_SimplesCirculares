package Ejercicio_8;

public class NodoClientes {
	private String nombre;
    private int nroCompras;  
    private LS_CircularVentas ls_CircularVentas;
    private NodoClientes sig;
    
    public NodoClientes() {  //constructor
		sig = null;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNroCompras() {
		return nroCompras;
	}

	public void setNroCompras(int nroCompras) {
		this.nroCompras = nroCompras;
	}

	public NodoClientes getSig() {
		return sig;
	}

	public void setSig(NodoClientes sig) {
		this.sig = sig;
	}

	public LS_CircularVentas getLs_CircularVentas() {
		return ls_CircularVentas;
	}

	public void setLs_CircularVentas(LS_CircularVentas ls_CircularVentas) {
		this.ls_CircularVentas = ls_CircularVentas;
	}
    
    
    
}
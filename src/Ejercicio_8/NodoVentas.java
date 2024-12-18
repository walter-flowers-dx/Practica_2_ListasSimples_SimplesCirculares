//Marcelo Aruquipa
package Ejercicio_8;

public class NodoVentas {
	private String prenda;  //define el dato objeto persona
	private String talla;
	private double precio;
	
	private NodoVentas sig; //definiendo el campo enlace sig
	
	public NodoVentas() {  //constructor
		sig = null;
	}

	public String getPrenda() {
		return prenda;
	}

	public void setPrenda(String prenda) {
		this.prenda = prenda;
	}

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public NodoVentas getSig() {
		return sig;
	}

	public void setSig(NodoVentas sig) {
		this.sig = sig;
	}

	
	
}

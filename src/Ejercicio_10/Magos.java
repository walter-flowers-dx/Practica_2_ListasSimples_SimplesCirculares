package Ejercicio_10;

public class Magos {
	private String nombre;
	private String nombreHechizoFavorito;
	
	public Magos(String nombre, String nombreHechizoFavorito) {
		super();
		this.nombre = nombre;
		this.nombreHechizoFavorito = nombreHechizoFavorito;
	}

	public String getNombre() {
		return nombre;
	}

	public void setMagos(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreHechizoFavorito() {
		return nombreHechizoFavorito;
	}

	public void setNombreHechizoFavorito(String nombreHechizoFavorito) {
		this.nombreHechizoFavorito = nombreHechizoFavorito;
	}

	public String toString() {
		return "Magos [Nombre=" + nombre + ", nombreHechizoFavorito=" + nombreHechizoFavorito + "]";
	}
	
	public void mostrar() {
		System.out.println(toString());
	}
}

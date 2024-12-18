package Ejercicio_10;

import java.util.Scanner;

public class Hechizos {
	private String nombre;
	private String tipo; 
	private String idPrimerIngrediente;
	private String idUltimoIngrediente;
	
	public Hechizos(String nombre, String tipo, String idPrimerIngrediente, String idUltimoIngrediente) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.idPrimerIngrediente = idPrimerIngrediente;
		this.idUltimoIngrediente = idUltimoIngrediente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getIdPrimerIngrediente() {
		return idPrimerIngrediente;
	}

	public void setIdPrimerIngrediente(String idPrimerIngrediente) {
		this.idPrimerIngrediente = idPrimerIngrediente;
	}

	public String getIdUltimoIngrediente() {
		return idUltimoIngrediente;
	}

	public void setIdUltimoIngrediente(String idUltimoIngrediente) {
		this.idUltimoIngrediente = idUltimoIngrediente;
	}
	
	public void leer() {
		Scanner lee = new Scanner(System.in);
		System.out.println("Intr. Datos: nombre, tipo, primerIngre, ultiIngre");
		nombre = lee.next();
		tipo = lee.next();
		idPrimerIngrediente = lee.next();
		idUltimoIngrediente = lee.next();
	}

	public String toString() {
		return "Hechizos [nombre=" + nombre + ", tipo=" + tipo + ", idPrimerIngrediente=" + idPrimerIngrediente
				+ ", idUltimoIngrediente=" + idUltimoIngrediente + "]";
	}
	
	public void mostrar() {
		System.out.println(toString());
	}
}

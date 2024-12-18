package Ejercicio_10;

import java.util.Scanner;

public class IngredientesMagicos {
	private String nombre;
	private String idIngrediente;
	private double costo;
	
	public IngredientesMagicos(String nombre, String idIngrediente, double costo) {
		super();
		this.nombre = nombre;
		this.idIngrediente = idIngrediente;
		this.costo = costo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIdIngrediente() {
		return idIngrediente;
	}

	public void setIdIngrediente(String idIngrediente) {
		this.idIngrediente = idIngrediente;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}
	
	public void leer() {
		Scanner lee = new Scanner(System.in);
		System.out.println("Intr. Datos: nombre, idIngrediente, costo");
		nombre = lee.next();
		idIngrediente = lee.next();
		costo = lee.nextDouble();
	}

	public String toString() {
		return "IngredientesMagicos [nombre=" + nombre + ", idIngrediente=" + idIngrediente + ", costo=" + costo + "]";
	}
	
	public void mostrar() {
		System.out.println(toString());
	}
}

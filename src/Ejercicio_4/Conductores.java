package Ejercicio_4;

import java.util.Scanner;

public class Conductores {
	private String nombre;
	private int edad;
	
	public Conductores(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public void leer(){
		Scanner lee = new Scanner(System.in);
		System.out.println("Intr. Datos: nombre, edad");
		nombre = lee.next();
		edad = lee.nextInt();
	}

	public String toString() {
		return "Conductores [nombre=" + nombre + ", edad=" + edad + "]";
	}
	
	public void mostrar() {
		System.out.println(toString());
	}
}

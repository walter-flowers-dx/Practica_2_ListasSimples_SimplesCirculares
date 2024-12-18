package Ejercicio_2;

import java.util.Scanner;

public class Peliculas {
	private String titulo;
	private String director;
	private double duracion;
	
	public Peliculas(String titulo, String director, double duracion) {
		super();
		this.titulo = titulo;
		this.director = director;
		this.duracion = duracion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public double getDuracion() {
		return duracion;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}
	
	public void leer() {
		Scanner lee = new Scanner(System.in);
		System.out.println("Intr. Datos: titulo, director duracion");
		titulo = lee.next();
		director = lee.next();
		duracion = lee.nextDouble();
	}

	public String toString() {
		return "Peliculas [titulo=" + titulo + ", director=" + director + ", duracion=" + duracion + "]";
	}
	
	public void mostrar() {
		System.out.println(toString());
	}
	
	
}

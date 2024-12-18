package Ejercicio_4;

import java.util.Scanner;

public class Vehiculos {
	private String modelo;
	private String fabricante;
	private String tipo;
	private String nombreConductor;
	
	public Vehiculos(String modelo, String fabricante, String tipo, String nombreConductor) {
		super();
		this.modelo = modelo;
		this.fabricante = fabricante;
		this.tipo = tipo;
		this.nombreConductor = nombreConductor;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public String getFabricante() {
		return fabricante;
	}
	
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getNombreConductor() {
		return nombreConductor;
	}
	
	public void setNombreConductor(String nombreConductor) {
		this.nombreConductor = nombreConductor;
	}
	
	public void leer() {
		Scanner lee = new Scanner(System.in);
		System.out.println("Intr. Datos: modelo, fabricante, tipo, nomConductor");
		modelo = lee.next();
		fabricante = lee.next();
		tipo = lee.next();
		nombreConductor = lee.next();
	}

	public String toString() {
		return "Vehiculos [modelo=" + modelo + ", fabricante=" + fabricante + ", tipo=" + tipo + ", nombreConductor="
				+ nombreConductor + "]";
	}
	
	public void mostrar() {
		System.out.println(toString());
	}
}

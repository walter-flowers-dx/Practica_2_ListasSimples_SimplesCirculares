//Marcelo Aruquipa
package Ejercicio_8;

import java.util.Scanner;

public class LS_CircularVentas extends ListaSimpleVentas{

	public LS_CircularVentas() {
		super();  //constructor de la clase padre ListaSimplePer
	}

	public boolean esVacia() {
		if(P == null)
			return true;   //lista vacia
		return false;      //lista NO vacia
	}
	
	public int nroNodos() {
		int c = 0;
		if(P != null) {
			NodoVentas R = P;
			while(R.getSig() != P) {
				c++;
				R = R.getSig();
			}
			c++;  //para contar el ultimo nodo
		}
		return c;
	}
	public void adiFinal(String prenda,String talla, double precio) {
		NodoVentas nuevo = new NodoVentas();
		nuevo.setPrenda(prenda);
		nuevo.setTalla(talla);
		nuevo.setPrecio(precio);
		
		if(P == null) {
			P = nuevo;   //p apunta a nuevo
			P.setSig(P);
		}
		else {
			NodoVentas R = P;
			while( R.getSig() != P){
			     R = R.getSig();
			}
			R.setSig(nuevo);
			nuevo.setSig(P);
		}
	}
	
	public void adiPrincipio(String prenda,String talla, int precio) {
		NodoVentas nuevo = new NodoVentas();
		nuevo.setPrenda(prenda);
		nuevo.setTalla(talla);
		nuevo.setPrecio(precio);
		if(P == null) {
			P = nuevo;
			P.setSig(P);
		}else {
			NodoVentas R = P;
			while(R.getSig() != P) {
				R = R.getSig();
			}
			R.setSig(nuevo);
			nuevo.setSig(P);
			P = nuevo;
		}
	}
	
	public void mostrar() {
		NodoVentas R = P;   //R apunta  a la raiz P
		while(R.getSig() != P) {
			System.out.println(R.getPrenda() + " - " + R.getTalla() + " - " + R.getPrecio());
			R = R.getSig();
		}
		System.out.println(R.getPrenda() + " - " + R.getTalla() + " - " + R.getPrecio());
	}
	
	public NodoVentas eliPrincipio() {
		NodoVentas x = null;    
		if(!esVacia()) {
			if(P.getSig() == P) {
				x = P;
				x.setSig(null);
				P = null;
			}else {
				x = P ;     // x apunta a la raiz P
				NodoVentas R = P;
				while(R.getSig() != P) {
					R = R.getSig();
				}
				P = P.getSig();
				R.setSig(P);
				x.setSig(null);
			}
		}
		return x;
	}
	
	public NodoVentas eliFinal() {
		NodoVentas x = new NodoVentas();
		if(P != null) {
			if(P.getSig() == P) {
				x = P; 
				x.setSig(null);
				P = null;
			}else {
				NodoVentas S = new NodoVentas();
				NodoVentas R = P;
				while(R.getSig() != P) {
					S = R;         //S apunta a R
					R = R.getSig(); //R apunta al siguiente de R
				}
				x = R;
				x.setSig(null);
				S.setSig(P);
			}
		}
		return x;
	}
	
	public void llenar1(int n) {
		Scanner lee =  new Scanner(System.in);
		for (int i = 1; i <= n; i++) {
			System.out.println("prenda - talla - precio");
			String prenda = lee.next();
			String talla = lee.next();
			double precio = lee.nextDouble();
			adiFinal(prenda, talla, precio);
		}
	}
	
	public void llenar2(int n) {
		Scanner lee =  new Scanner(System.in);
		for (int i = 1; i <= n; i++) {
			System.out.println("prenda - talla - precio");
			String prenda = lee.next();
			String talla = lee.next();
			double precio = lee.nextDouble();
			adiFinal(prenda, talla, precio);
		}
	}
}

package Ejercicio_6;

import java.util.Scanner;

public class LS_CircularPaises extends ListaSimplePaises{

	public LS_CircularPaises() {
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
			NodoPaises R = P;
			while(R.getSig() != P) {
				c++;
				R = R.getSig();
			}
			c++;  //para contar el ultimo nodo
		}
		return c;
	}
	public void adiFinal(String pais, String idiomaOficial) {
		NodoPaises nuevo = new NodoPaises();
		nuevo.setPais(pais);
		nuevo.setIdiomaOficial(idiomaOficial);
		
		if(P == null) {
			P = nuevo;   //p apunta a nuevo
			P.setSig(P);
		}
		else {
			NodoPaises R = P;
			while( R.getSig() != P){
			     R = R.getSig();
			}
			R.setSig(nuevo);
			nuevo.setSig(P);
		}
	}
	
	public void adiPrincipio(String pais, String idiomaOficial) {
		NodoPaises nuevo = new NodoPaises();
		nuevo.setPais(pais);
		nuevo.setIdiomaOficial(idiomaOficial);
		if(P == null) {
			P = nuevo;
			P.setSig(P);
		}else {
			NodoPaises R = P;
			while(R.getSig() != P) {
				R = R.getSig();
			}
			R.setSig(nuevo);
			nuevo.setSig(P);
			P = nuevo;
		}
	}
	
	public void mostrar() {
		NodoPaises R = P;   //R apunta  a la raiz P
		while(R.getSig() != P) {
			System.out.println(R.getPais() + " - " + R.getIdiomaOficial());
			R = R.getSig();
		}
		System.out.println(R.getPais() + " - " + R.getIdiomaOficial());
	}
	
	public NodoPaises eliPrincipio() {
		NodoPaises x = null;    
		if(!esVacia()) {
			if(P.getSig() == P) {
				x = P;
				x.setSig(null);
				P = null;
			}else {
				x = P ;     // x apunta a la raiz P
				NodoPaises R = P;
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
	
	public NodoPaises eliFinal() {
		NodoPaises x = new NodoPaises();
		if(P != null) {
			if(P.getSig() == P) {
				x = P; 
				x.setSig(null);
				P = null;
			}else {
				NodoPaises S = new NodoPaises();
				NodoPaises R = P;
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
			System.out.println("pais - idiomaOficial");
			String pais = lee.next();
			String idiomaOficial = lee.next();
			adiFinal(pais, idiomaOficial);
		}
	}
	
	public void llenar2(int n) {
		Scanner lee =  new Scanner(System.in);
		for (int i = 1; i <= n; i++) {
			System.out.println("pais - idiomaOficial");
			String pais = lee.next();
			String idiomaOficial = lee.next();
			adiFinal(pais, idiomaOficial);
		}
	}
}

package Ejercicio_10;

public class LS_NormalIngredientesMagicos extends ListaSimpleIngredientesMagicos{

	public LS_NormalIngredientesMagicos() {
		super();
	}

	public boolean esVacia() {
		if(P == null)
			return true;
		return false;
	}

	public void adiPrincipio(IngredientesMagicos z) {
		NodoIngredientesMagicos nuevo = new NodoIngredientesMagicos();
		nuevo.setQ(z);
		nuevo.setSig(P); //el siguiente del nodo nuevo apunta a nodo raiz
		P = nuevo;      //P apunta a nuevo
	}
	
	public void adiFinal(IngredientesMagicos z) {
		NodoIngredientesMagicos nuevo = new NodoIngredientesMagicos();
		nuevo.setQ(z);
		
		if(esVacia())
			P = nuevo;   //p apunta a nuevo
		else {
			NodoIngredientesMagicos R = P;
			while( R.getSig() != null ){
			     R = R.getSig();
			}
			R.setSig(nuevo);
		}
	}
	
	
	public void mostrar() {
		NodoIngredientesMagicos R = P;   //R apunta  a la raiz P
		while(R != null) {
			R.getQ().mostrar();
			R = R.getSig();
		}
	}

	public int nroNodos() {
		NodoIngredientesMagicos R = P;
		int c = 0;
		if(this.esVacia())
			return 0;
		else {
			while(R != null) {
				c++;
				R = R.getSig();
			}
		}
		return c;
	}
	
	public NodoIngredientesMagicos eliPrincipio() {
		NodoIngredientesMagicos x = new NodoIngredientesMagicos();    
		if(!esVacia()) {
			x = P ;     // x apunta a la raiz P
			P = P.getSig();
			x.setSig(null);
		}
		return x;
	}
	
	public NodoIngredientesMagicos eliFinal() {
		NodoIngredientesMagicos x = new NodoIngredientesMagicos();
		if(!esVacia()) {
			if(nroNodos() == 1) {
				x = P;      //x apunta a la raiz P
				P = null;
			}else {
				NodoIngredientesMagicos R = P;
				NodoIngredientesMagicos S = P;
				while(R.getSig() != null) {
					S = R;         //S apunta a R
					R = R.getSig(); //R apunta al siguiente de R
				}
				x = R;
				S.setSig(null);
			}
		}
		return x;
	}
	
	public void leer1(int n) {
		for (int i = 1; i <= n; i++) {
			IngredientesMagicos z = new IngredientesMagicos("","",0);
			z.leer();
			adiPrincipio(z);
		}
	}
	
	public void leer2(int n) {
		for (int i = 1; i <= n; i++) {
			IngredientesMagicos z = new IngredientesMagicos("","",0);
			z.leer();
			adiFinal(z);
		}
	}
}
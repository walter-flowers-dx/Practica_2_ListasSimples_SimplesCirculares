package Ejercicio_10;

public class LS_CircularHechizos extends ListaSimpleHechizos{
	public LS_CircularHechizos() {
        super(); // Constructor de la clase padre
    }
    
    public boolean esVacia() {
        return P == null; 
    }

    public int nroNodos() {
        int c = 0;
        if (P != null) {
            NodoHechizos R = P;
            do {
                c++;
                R = R.getSig();
            } while (R != P);
        }
        return c;
    }

    public void adiFinal(Hechizos hechizos) {
        NodoHechizos nuevo = new NodoHechizos();
        nuevo.setHechizos(hechizos);

        if (P == null) {
            P = nuevo;
            P.setSig(P); // Lista circular
        } else {
            NodoHechizos R = P;
            while (R.getSig() != P) {
                R = R.getSig();
            }
            R.setSig(nuevo);
            nuevo.setSig(P);
        }
    }

    public void adiPrincipio(Hechizos hechizos) {
        NodoHechizos nuevo = new NodoHechizos();
        nuevo.setHechizos(hechizos);

        if (P == null) {
            P = nuevo;
            P.setSig(P);
        } else {
            NodoHechizos R = P;
            while (R.getSig() != P) {
                R = R.getSig();
            }
            R.setSig(nuevo);
            nuevo.setSig(P);
            P = nuevo;
        }
    }

    public void mostrar() {
        if (!esVacia()) {
            NodoHechizos R = P;
            do {
                R.getHechizos().mostrar(); // Muestra cada Hechizos
                R = R.getSig();
            } while (R != P);
        }
    }

    public NodoHechizos eliPrincipio() {
        NodoHechizos x = null;
        if (!esVacia()) {
            if (P.getSig() == P) {
                x = P;
                P = null;
            } else {
                x = P;
                NodoHechizos R = P;
                while (R.getSig() != P) {
                    R = R.getSig();
                }
                P = P.getSig();
                R.setSig(P);
            }
        }
        return x;
    }
}
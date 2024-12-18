package Ejercicio_10;
public class LS_CircularMagos extends ListaSimpleMagos {

    public LS_CircularMagos() {
        super(); // Constructor de la clase padre
    }
    
    public boolean esVacia() {
        return P == null; 
    }

    public int nroNodos() {
        int c = 0;
        if (P != null) {
            NodoMagos R = P;
            do {
                c++;
                R = R.getSig();
            } while (R != P);
        }
        return c;
    }

    public void adiFinal(Magos magos) {
        NodoMagos nuevo = new NodoMagos();
        nuevo.setMagos(magos);

        if (P == null) {
            P = nuevo;
            P.setSig(P); // Lista circular
        } else {
            NodoMagos R = P;
            while (R.getSig() != P) {
                R = R.getSig();
            }
            R.setSig(nuevo);
            nuevo.setSig(P);
        }
    }

    public void adiPrincipio(Magos magos) {
        NodoMagos nuevo = new NodoMagos();
        nuevo.setMagos(magos);

        if (P == null) {
            P = nuevo;
            P.setSig(P);
        } else {
            NodoMagos R = P;
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
            NodoMagos R = P;
            do {
                R.getMagos().mostrar(); // Muestra cada Magos
                R = R.getSig();
            } while (R != P);
        }
    }

    public NodoMagos eliPrincipio() {
        NodoMagos x = null;
        if (!esVacia()) {
            if (P.getSig() == P) {
                x = P;
                P = null;
            } else {
                x = P;
                NodoMagos R = P;
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

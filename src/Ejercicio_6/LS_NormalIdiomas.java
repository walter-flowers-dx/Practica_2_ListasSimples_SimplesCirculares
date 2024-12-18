package Ejercicio_6;

public class LS_NormalIdiomas extends ListaSimpleIdiomas {
    public LS_NormalIdiomas() {
        super();
    }

    public boolean esVacia() {
        return P == null;
    }

    public void adiPrincipio(String idioma, int nroHablantes) {
        NodoIdiomas nuevo = new NodoIdiomas();
        nuevo.setIdioma(idioma);
        nuevo.setNroHablantes(nroHablantes);
        nuevo.setSig(P);
        P = nuevo;
    }

    public void adiFinal(String idioma, int nroHablantes) {
        NodoIdiomas nuevo = new NodoIdiomas();
        nuevo.setIdioma(idioma);
        nuevo.setNroHablantes(nroHablantes);

        if (esVacia()) {
            P = nuevo;
        } else {
            NodoIdiomas R = P;
            while (R.getSig() != null) {
                R = R.getSig();
            }
            R.setSig(nuevo);
        }
    }

    public void mostrar() {
        NodoIdiomas R = P;
        while (R != null) {
            System.out.print(R.getIdioma() + " - " + R.getNroHablantes() + "\n");
            R = R.getSig();
        }
        System.out.println();
    }

    public int nroNodos() {
        NodoIdiomas R = P;
        int count = 0;
        while (R != null) {
            count++;
            R = R.getSig();
        }
        return count;
    }

    public String eliPrincipio() {
        if (esVacia()) {
            return null;
        } else {
            String idioma = P.getIdioma();
            P = P.getSig();
            return idioma;
        }
    }

    public String eliFinal() {
        if (esVacia()) {
            return null;
        } else if (nroNodos() == 1) {
            String idioma = P.getIdioma();
            P = null;
            return idioma;
        } else {
            NodoIdiomas R = P;
            NodoIdiomas S = null;
            while (R.getSig() != null) {
                S = R;
                R = R.getSig();
            }
            String idioma = R.getIdioma();
            S.setSig(null);
            return idioma;
        }
    }

    public void leer1(int n) {
        for (int i = 1; i <= n; i++) {
            adiPrincipio("Idioma_" + i, i * 1000); 
        }
    }

    public void leer2(int n) {
        for (int i = 1; i <= n; i++) {
            adiFinal("Idioma_" + i, i * 1000); 
        }
    }
}
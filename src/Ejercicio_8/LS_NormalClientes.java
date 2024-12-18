package Ejercicio_8;

public class LS_NormalClientes extends ListaSimpleClientes {
    public LS_NormalClientes() {
        super();
    }

    public boolean esVacia() {
        return P == null;
    }

    public void adiPrincipio(String nombre, int nroCompras, LS_CircularVentas ls_CircularVentas) {
        NodoClientes nuevo = new NodoClientes();
        nuevo.setNombre(nombre);
        nuevo.setNroCompras(nroCompras);
        nuevo.setLs_CircularVentas(ls_CircularVentas);
        nuevo.setSig(P);
        P = nuevo;
    }

    public void adiFinal(String nombre, int nroCompras, LS_CircularVentas ls_CircularVentas) {
    	NodoClientes nuevo = new NodoClientes();
        nuevo.setNombre(nombre);
        nuevo.setNroCompras(nroCompras);
        nuevo.setLs_CircularVentas(ls_CircularVentas);

        if (esVacia()) {
            P = nuevo;
        } else {
            NodoClientes R = P;
            while (R.getSig() != null) {
                R = R.getSig();
            }
            R.setSig(nuevo);
        }
    }

    public void mostrar() {
        NodoClientes R = P;
        while (R != null) {
            System.out.print(R.getNombre() + " - " + R.getNroCompras() + " compras:\n");
            if (R.getLs_CircularVentas() != null) {
                R.getLs_CircularVentas().mostrar();
            } else {
                System.out.println("No tiene compras registradas.");
            }
            R = R.getSig();
        }
        System.out.println();
    }


    public int nroNodos() {
        NodoClientes R = P;
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
            String idioma = P.getNombre();
            P = P.getSig();
            return idioma;
        }
    }

    public String eliFinal() {
        if (esVacia()) {
            return null;
        } else if (nroNodos() == 1) {
            String idioma = P.getNombre();
            P = null;
            return idioma;
        } else {
            NodoClientes R = P;
            NodoClientes S = null;
            while (R.getSig() != null) {
                S = R;
                R = R.getSig();
            }
            String idioma = R.getNombre();
            S.setSig(null);
            return idioma;
        }
    }

//    public void leer1(int n) {
//        for (int i = 1; i <= n; i++) {
//            adiPrincipio("Idioma_" + i, i * 1000); 
//        }
//    }
//
//    public void leer2(int n) {
//        for (int i = 1; i <= n; i++) {
//            adiFinal("Idioma_" + i, i * 1000); 
//        }
//    }
}
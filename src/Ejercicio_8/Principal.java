package Ejercicio_8;

public class Principal {

    public static void main(String[] args) {
        // LISTAS DE VENTAS
        LS_CircularVentas lscv1 = new LS_CircularVentas();
        lscv1.adiFinal("polera", "L", 45);
        lscv1.adiFinal("jeans", "44", 120);
        
        LS_CircularVentas lscv2 = new LS_CircularVentas();
        lscv2.adiFinal("vestido", "36", 75);
        
        LS_CircularVentas lscv3 = new LS_CircularVentas();
        lscv3.adiFinal("camisa", "M", 55);
        lscv3.adiFinal("jeans", "40", 100);
        
        // LISTAS DE CLIENTES
        LS_NormalClientes lsnc = new LS_NormalClientes();
        lsnc.adiFinal("Fabian", 2, lscv1);
        lsnc.adiFinal("Alicia", 1, lscv2);
        lsnc.adiFinal("Erland", 2, lscv3);
        lsnc.mostrar();
        
        System.out.println("\na) Mostrar al cliente numero X de la lista y las prendas que compro");
        mostrarClienteX(lsnc, 2);

        System.out.println("\nb) Mostrar los nombres de los clientes que compraron la prenda 'jeans'");
        mostrarClientesConPrenda(lsnc, "jeans");

        System.out.println("\nc) Calcular el monto que pago cada cliente");
        calcularMontoPorCliente(lsnc);

        System.out.println("\nd) Mostrar la prenda que mas se vendio");
        mostrarPrendaMasVendida(lsnc);
    }

    // a.
    public static void mostrarClienteX(LS_NormalClientes listaClientes, int x) {
        NodoClientes actual = listaClientes.getP();
        int contador = 1;
        
        while (actual != null && contador < x) {
            actual = actual.getSig();
            contador++;
        }
        
        if (actual != null) {
            System.out.println("Cliente #" + x + ": " + actual.getNombre() + " - Compras:");
            actual.getLs_CircularVentas().mostrar();
        } else {
            System.out.println("No existe el cliente número " + x);
        }
    }

    // b.
    public static void mostrarClientesConPrenda(LS_NormalClientes listaClientes, String prenda) {
        NodoClientes actualCliente = listaClientes.getP();
        
        while (actualCliente != null) {
            NodoVentas actualVenta = actualCliente.getLs_CircularVentas().getP();
            boolean comproPrenda = false;
            
            do {
                if (actualVenta != null && actualVenta.getPrenda().equalsIgnoreCase(prenda)) {
                    comproPrenda = true;
                    break;
                }
                if (actualVenta != null) actualVenta = actualVenta.getSig();
            } while (actualVenta != null && actualVenta != actualCliente.getLs_CircularVentas().getP());
            
            if (comproPrenda) {
                System.out.println(actualCliente.getNombre());
            }
            
            actualCliente = actualCliente.getSig();
        }
    }

    // c.
    public static void calcularMontoPorCliente(LS_NormalClientes listaClientes) {
        NodoClientes actualCliente = listaClientes.getP();
        
        while (actualCliente != null) {
            double montoTotal = 0;
            NodoVentas actualVenta = actualCliente.getLs_CircularVentas().getP();
            
            do {
                if (actualVenta != null) {
                    montoTotal += actualVenta.getPrecio();
                    actualVenta = actualVenta.getSig();
                }
            } while (actualVenta != null && actualVenta != actualCliente.getLs_CircularVentas().getP());
            
            System.out.println(actualCliente.getNombre() + " pagó un total de: " + montoTotal);
            actualCliente = actualCliente.getSig();
        }
    }

 // d.
    public static void mostrarPrendaMasVendida(LS_NormalClientes listaClientes) {
        NodoClientes actualCliente = listaClientes.getP();
        String prendaMasVendida = "";
        int maxVentas = 0;

        while (actualCliente != null) {
            NodoVentas actualVenta = actualCliente.getLs_CircularVentas().getP();
            do {
                if (actualVenta != null) {
                    int ventasActual = contarVentas(listaClientes, actualVenta.getPrenda());

                    if (ventasActual > maxVentas) {
                        maxVentas = ventasActual;
                        prendaMasVendida = actualVenta.getPrenda();
                    }
                }
                if (actualVenta != null) actualVenta = actualVenta.getSig();
            } while (actualVenta != null && actualVenta != actualCliente.getLs_CircularVentas().getP());

            actualCliente = actualCliente.getSig();
        }

        System.out.println("La prenda más vendida es: " + prendaMasVendida + " con " + maxVentas + " ventas");
    }

    public static int contarVentas(LS_NormalClientes listaClientes, String prenda) {
        NodoClientes actualCliente = listaClientes.getP();
        int contadorVentas = 0;

        while (actualCliente != null) {
            NodoVentas actualVenta = actualCliente.getLs_CircularVentas().getP();
            do {
                if (actualVenta != null && actualVenta.getPrenda().equalsIgnoreCase(prenda)) {
                    contadorVentas++;
                }
                if (actualVenta != null) actualVenta = actualVenta.getSig();
            } while (actualVenta != null && actualVenta != actualCliente.getLs_CircularVentas().getP());
            
            actualCliente = actualCliente.getSig();
        }

        return contadorVentas;
    }
}
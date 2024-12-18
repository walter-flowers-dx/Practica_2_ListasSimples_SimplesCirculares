package Ejercicio_4;

public class Principal {

    public static void main(String[] args) {
        LS_NormalConductores listaConductores = new LS_NormalConductores();
        Conductores c1 = new Conductores("Carlos", 35);
        Conductores c2 = new Conductores("Ana", 29);
        Conductores c3 = new Conductores("Luis", 42);
        Conductores c4 = new Conductores("Maria", 31);
        listaConductores.adiFinal(c1);
        listaConductores.adiFinal(c2);
        listaConductores.adiFinal(c3);
        listaConductores.adiFinal(c4);
        listaConductores.mostrar();

        LS_NormalVehiculos listaVehiculos = new LS_NormalVehiculos();
        Vehiculos v1 = new Vehiculos("ModeloA", "Toyota", "Minivan", "Carlos");
        Vehiculos v2 = new Vehiculos("ModeloB", "Ford", "Sedan", "Ana");
        Vehiculos v3 = new Vehiculos("ModeloA", "Toyota", "SUV", "Carlos");
        Vehiculos v4 = new Vehiculos("ModeloC", "Ford", "Truck", "Luis");
        Vehiculos v5 = new Vehiculos("ModeloD", "Honda", "Clasic", "Ana");
        listaVehiculos.adiFinal(v1);
        listaVehiculos.adiFinal(v2);
        listaVehiculos.adiFinal(v3);
        listaVehiculos.adiFinal(v4);
        listaVehiculos.adiFinal(v5);
        listaVehiculos.mostrar();
        
        System.out.println("\na) Mostrar el Conductor con mayor número de Vehículos");
        mostrarConductorConMasVehiculos(listaConductores, listaVehiculos);
        
        System.out.println("\nb) Mostrar el Conductor del Vehículo de modelo X");
        mostrarConductorDeModeloX("ModeloB", listaVehiculos);
        
        System.out.println("\nc) Contar los vehiculos que son del fabricante X y son conducidos por el conductor Y");
        contarVehiculosPorFabricanteConductor("Ford", "Ana", listaVehiculos);
        
        System.out.println("\nd) Eliminar los conductores que no poseen ningun vehiculo");
        eliminarConductoresSinVehiculo(listaConductores, listaVehiculos);
        System.out.println("Lista de Conductores después de eliminar los que no poseen vehículo:");
        listaConductores.mostrar();
    }
    // a.
    public static void mostrarConductorConMasVehiculos(LS_NormalConductores conductores, LS_NormalVehiculos vehiculos) {
        NodoConductores nodoConductor = conductores.getP();
        Conductores conductorConMasVehiculos = null;
        int maxVehiculos = 0;

        while (nodoConductor != null) {
            int cuenta = contarVehiculosPorConductor(nodoConductor.getQ().getNombre(), vehiculos);
            if (cuenta > maxVehiculos) {
                maxVehiculos = cuenta;
                conductorConMasVehiculos = nodoConductor.getQ();
            }
            nodoConductor = nodoConductor.getSig();
        }

        if (conductorConMasVehiculos != null) {
            System.out.println("Conductor con más vehículos: ");
            conductorConMasVehiculos.mostrar();
        } else {
            System.out.println("No se encontraron conductores con vehículos.");
        }
    }
    
    
    //b.
    public static void mostrarConductorDeModeloX(String modelo, LS_NormalVehiculos vehiculos) {
        NodoVehiculos nodoVehiculo = vehiculos.getP();

        while (nodoVehiculo != null) {
            if (nodoVehiculo.getQ().getModelo().equalsIgnoreCase(modelo)) {
                System.out.println("Conductor del vehículo modelo " + modelo + ": " + nodoVehiculo.getQ().getNombreConductor());
                return;
            }
            nodoVehiculo = nodoVehiculo.getSig();
        }

        System.out.println("No se encontró vehículo del modelo " + modelo);
    }
    
    
    // c.
    public static void contarVehiculosPorFabricanteConductor(String fabricante, String nombreConductor, LS_NormalVehiculos vehiculos) {
        NodoVehiculos nodoVehiculo = vehiculos.getP();
        int contador = 0;

        while (nodoVehiculo != null) {
            Vehiculos vehiculo = nodoVehiculo.getQ();
            if (vehiculo.getFabricante().equalsIgnoreCase(fabricante) && vehiculo.getNombreConductor().equalsIgnoreCase(nombreConductor)) {
                contador++;
            }
            nodoVehiculo = nodoVehiculo.getSig();
        }

        System.out.println("Número de vehículos del fabricante " + fabricante + " conducidos por " + nombreConductor + ": " + contador);
    }
    
    // d.
    public static void eliminarConductoresSinVehiculo(LS_NormalConductores conductores, LS_NormalVehiculos vehiculos) {
        NodoConductores nodoAnterior = null;
        NodoConductores nodoActual = conductores.getP();

        while (nodoActual != null) {
            String nombreConductor = nodoActual.getQ().getNombre();
            int cuentaVehiculos = contarVehiculosPorConductor(nombreConductor, vehiculos);

            if (cuentaVehiculos == 0) {
                if (nodoAnterior == null) {
                    conductores.setP(nodoActual.getSig());
                } else {
                    nodoAnterior.setSig(nodoActual.getSig());
                }
            } else {
                nodoAnterior = nodoActual;
            }

            nodoActual = nodoActual.getSig();
        }
    }
    
    public static int contarVehiculosPorConductor(String nombreConductor, LS_NormalVehiculos vehiculos) {
        NodoVehiculos nodoVehiculo = vehiculos.getP();
        int contador = 0;

        while (nodoVehiculo != null) {
            if (nodoVehiculo.getQ().getNombreConductor().equalsIgnoreCase(nombreConductor)) {
                contador++;
            }
            nodoVehiculo = nodoVehiculo.getSig();
        }

        return contador;
    }
}

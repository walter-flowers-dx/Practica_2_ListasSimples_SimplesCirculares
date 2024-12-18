package Ejercicio_10;

public class Principal {

	public static void main(String[] args) {
		LS_CircularMagos lscm = new LS_CircularMagos();
		Magos m1 = new Magos("Juan", "Volar");
		Magos m2 = new Magos("Maria", "Invicible");
		Magos m3 = new Magos("Rdrigo", "Volar");
		Magos m4 = new Magos("Manuel", "Inteligencia");
		Magos m5 = new Magos("Dann", "Fuerza");
		lscm.adiFinal(m1);
		lscm.adiFinal(m2);
		lscm.adiFinal(m3);
		lscm.adiFinal(m4);
		lscm.adiFinal(m5);
		System.out.println("LISTA DE MAGOS: ");
		lscm.mostrar();
		
		LS_CircularHechizos lsch = new LS_CircularHechizos();
		Hechizos h1 = new Hechizos("Fuerza", "Habilidad", "Agua Azul", "Lana Roja");
		Hechizos h2 = new Hechizos("Volar", "Habilidad", "Polvo Verde", "Plastico Morado");
		Hechizos h3 = new Hechizos("Invicible", "Estrategia", "Hoja de papel", "Aceite Negro");
		Hechizos h4 = new Hechizos("Inteligencia", "Estrategia", "Carne de Cerdo", "Polvo Verde");
		lsch.adiFinal(h1);
		lsch.adiFinal(h2);
		lsch.adiFinal(h3);
		lsch.adiFinal(h4);
		System.out.println("\nLISTA DE HECHIZOS: ");
		lsch.mostrar();
		
		LS_NormalIngredientesMagicos lsnim = new LS_NormalIngredientesMagicos();
		IngredientesMagicos im1 = new IngredientesMagicos("Agua Azul", "H1", 20);
		IngredientesMagicos im2 = new IngredientesMagicos("Polvo Verde", "H2", 10);
		IngredientesMagicos im3 = new IngredientesMagicos("Inciensio", "H3", 15);
		IngredientesMagicos im4 = new IngredientesMagicos("Carne de Cerdo", "H4", 60);
		IngredientesMagicos im5 = new IngredientesMagicos("Lana Roja", "H5", 25);
		IngredientesMagicos im6 = new IngredientesMagicos("Platico Morado", "H6", 25);
		IngredientesMagicos im7 = new IngredientesMagicos("Aceite Verde", "H7", 8);
		lsnim.adiFinal(im1);
		lsnim.adiFinal(im2);
		lsnim.adiFinal(im3);
		lsnim.adiFinal(im4);
		lsnim.adiFinal(im5);
		lsnim.adiFinal(im6);
		lsnim.adiFinal(im7);
		System.out.println("\nLISTA DE INGREDIENTES: ");
		lsnim.mostrar();
		
		System.out.println("\na) Dado el Mago con nombre X verificar si se tienen todos los ingredientes para que el mago pueda preparar su hechizo favorito");
		verificarIngredientes(lscm, lsch, lsnim, "Maria");
		
		System.out.println("\nb) Mostrar el nombre del Mago que tiene el mayor costo de preparar su hechizo favorito");
		mostrarMagoMayorCosto(lscm, lsch, lsnim);
		
		System.out.println("\nc) De todos los Magos mostrar el nombre de los ingredientes menos frecuentes para el preparado de sus hechizos");
		mostrarIngredientesMenosFrecuentes(lscm, lsch, lsnim);
		
		System.out.println("\nd) Mostrar el nombre de los Magos que usan el ingrediente con nombre X");
		mostrarMagosPorIngrediente(lscm, lsch, "Polvo Verde");
		
		System.out.println("\ne) Ordenar la Lista de Magos ascendentemente por el costo de realizar su hechizo favorito");
		ordenarMagosPorCosto(lscm, lsch, lsnim);
		
		System.out.println("\nf) Eliminar los ingredientes que cuesten mas de 17");
		eliminarIngredientesCostosos(lsnim, 17);
		
	}
	// a.
	public static void verificarIngredientes(LS_CircularMagos lscm, LS_CircularHechizos lsch, LS_NormalIngredientesMagicos lsnim, String nombreMago) {
	    NodoMagos magoNodo = lscm.getP();
	    do {
	        Magos mago = magoNodo.getMagos();
	        if (mago.getNombre().equals(nombreMago)) {
	            String hechizoFavorito = mago.getNombreHechizoFavorito();
	            NodoHechizos hechizoNodo = lsch.getP();
	            do {
	                Hechizos hechizo = hechizoNodo.getHechizos();
	                if (hechizo.getNombre().equals(hechizoFavorito)) {
	                    boolean primerIngrediente = false, ultimoIngrediente = false;
	                    NodoIngredientesMagicos ingredienteNodo = lsnim.getP();
	                    while (ingredienteNodo != null) {
	                        IngredientesMagicos ingrediente = ingredienteNodo.getQ();
	                        if (ingrediente.getNombre().equals(hechizo.getIdPrimerIngrediente())) primerIngrediente = true;
	                        if (ingrediente.getNombre().equals(hechizo.getIdUltimoIngrediente())) ultimoIngrediente = true;
	                        ingredienteNodo = ingredienteNodo.getSig();
	                    }
	                    if (primerIngrediente && ultimoIngrediente) {
	                        System.out.println("El mago " + nombreMago + " tiene todos los ingredientes para preparar su hechizo favorito.");
	                    } else {
	                        System.out.println("El mago " + nombreMago + " no tiene todos los ingredientes necesarios.");
	                    }
	                    return;
	                }
	                hechizoNodo = hechizoNodo.getSig();
	            } while (hechizoNodo != lsch.getP());
	        }
	        magoNodo = magoNodo.getSig();
	    } while (magoNodo != lscm.getP());
	}
	
	// b.
	public static void mostrarMagoMayorCosto(LS_CircularMagos lscm, LS_CircularHechizos lsch, LS_NormalIngredientesMagicos lsnim) {
	    NodoMagos magoNodo = lscm.getP();
	    String magoMayorCosto = "";
	    double mayorCosto = 0;

	    do {
	        Magos mago = magoNodo.getMagos();
	        String hechizoFavorito = mago.getNombreHechizoFavorito();
	        NodoHechizos hechizoNodo = lsch.getP();
	        do {
	            Hechizos hechizo = hechizoNodo.getHechizos();
	            if (hechizo.getNombre().equals(hechizoFavorito)) {
	                double costoTotal = 0;
	                NodoIngredientesMagicos ingredienteNodo = lsnim.getP();
	                while (ingredienteNodo != null) {
	                    IngredientesMagicos ingrediente = ingredienteNodo.getQ();
	                    if (ingrediente.getNombre().equals(hechizo.getIdPrimerIngrediente()) || ingrediente.getNombre().equals(hechizo.getIdUltimoIngrediente())) {
	                        costoTotal += ingrediente.getCosto();
	                    }
	                    ingredienteNodo = ingredienteNodo.getSig();
	                }
	                if (costoTotal > mayorCosto) {
	                    mayorCosto = costoTotal;
	                    magoMayorCosto = mago.getNombre();
	                }
	                break;
	            }
	            hechizoNodo = hechizoNodo.getSig();
	        } while (hechizoNodo != lsch.getP());
	        magoNodo = magoNodo.getSig();
	    } while (magoNodo != lscm.getP());

	    if (magoMayorCosto.isEmpty()) {
	        System.out.println("No se encontró un mago con un hechizo que tenga ingredientes válidos en la lista.");
	    } else {
	        System.out.println("El mago con el mayor costo para preparar su hechizo favorito es: " + magoMayorCosto + " con un costo de " + mayorCosto);
	    }
	}

	// c.
	public static void mostrarIngredientesMenosFrecuentes(LS_CircularMagos lscm, LS_CircularHechizos lsch, LS_NormalIngredientesMagicos lsnim) {
	    NodoIngredientesMagicos ingredienteNodo = lsnim.getP();
	    NodoIngredientesMagicos ingredienteMenosFrecuente = null;
	    int menorFrecuencia = Integer.MAX_VALUE;
	    while (ingredienteNodo != null) {
	        String nombreIngrediente = ingredienteNodo.getQ().getNombre();
	        int frecuenciaActual = 0;
	        NodoHechizos hechizoNodo = lsch.getP();
	        do {
	            Hechizos hechizo = hechizoNodo.getHechizos();
	            if (hechizo.getIdPrimerIngrediente().equals(nombreIngrediente) || hechizo.getIdUltimoIngrediente().equals(nombreIngrediente)) {
	                frecuenciaActual++;
	            }
	            hechizoNodo = hechizoNodo.getSig();
	        } while (hechizoNodo != lsch.getP());
	        if (frecuenciaActual < menorFrecuencia) {
	            menorFrecuencia = frecuenciaActual;
	            ingredienteMenosFrecuente = ingredienteNodo;
	        }

	        ingredienteNodo = ingredienteNodo.getSig();
	    }
	    if (ingredienteMenosFrecuente != null) {
	        System.out.println("Ingrediente menos frecuente: " + ingredienteMenosFrecuente.getQ().getNombre() + " con frecuencia de " + menorFrecuencia);
	    } else {
	        System.out.println("No se encontró ningún ingrediente en los hechizos.");
	    }
	}
    
    // d.
    public static void mostrarMagosPorIngrediente(LS_CircularMagos lscm, LS_CircularHechizos lsch, String nombreIngrediente) {
        NodoMagos magoNodo = lscm.getP();
        System.out.println("Magos que usan el ingrediente " + nombreIngrediente + ":");

        do {
            Magos mago = magoNodo.getMagos();
            String hechizoFavorito = mago.getNombreHechizoFavorito();
            NodoHechizos hechizoNodo = lsch.getP();
            do {
                Hechizos hechizo = hechizoNodo.getHechizos();
                if (hechizo.getNombre().equals(hechizoFavorito)) {
                    if (hechizo.getIdPrimerIngrediente().equals(nombreIngrediente) || hechizo.getIdUltimoIngrediente().equals(nombreIngrediente)) {
                        System.out.println(mago.getNombre());
                    }
                    break;
                }
                hechizoNodo = hechizoNodo.getSig();
            } while (hechizoNodo != lsch.getP());
            magoNodo = magoNodo.getSig();
        } while (magoNodo != lscm.getP());
    }
    
    // e.
    public static void ordenarMagosPorCosto(LS_CircularMagos lscm, LS_CircularHechizos lsch, LS_NormalIngredientesMagicos lsnim) {
        boolean huboIntercambio;
        do {
            huboIntercambio = false;
            NodoMagos magoNodo = lscm.getP();
            do {
                NodoMagos siguienteNodo = magoNodo.getSig();
                if (siguienteNodo == lscm.getP()) break;
                double costoMagoActual = calcularCostoHechizo(magoNodo.getMagos().getNombreHechizoFavorito(), lsch, lsnim);
                double costoSiguienteMago = calcularCostoHechizo(siguienteNodo.getMagos().getNombreHechizoFavorito(), lsch, lsnim);
                if (costoMagoActual > costoSiguienteMago) {
                    Magos temp = magoNodo.getMagos();
                    magoNodo.setMagos(siguienteNodo.getMagos());
                    siguienteNodo.setMagos(temp);
                    huboIntercambio = true;
                }
                magoNodo = magoNodo.getSig();
            } while (magoNodo != lscm.getP());
        } while (huboIntercambio);
        System.out.println("Lista de magos ordenada por costo de hechizo favorito:");
        lscm.mostrar();
    }

    public static double calcularCostoHechizo(String nombreHechizo, LS_CircularHechizos lsch, LS_NormalIngredientesMagicos lsnim) {
        NodoHechizos hechizoNodo = lsch.getP();
        do {
            Hechizos hechizo = hechizoNodo.getHechizos();
            if (hechizo.getNombre().equals(nombreHechizo)) {
                double costoTotal = 0;
                NodoIngredientesMagicos ingredienteNodo = lsnim.getP();
                while (ingredienteNodo != null) {
                    IngredientesMagicos ingrediente = ingredienteNodo.getQ();
                    if (ingrediente.getNombre().equals(hechizo.getIdPrimerIngrediente()) || ingrediente.getNombre().equals(hechizo.getIdUltimoIngrediente())) {
                        costoTotal += ingrediente.getCosto();
                    }
                    ingredienteNodo = ingredienteNodo.getSig();
                }
                return costoTotal;
            }
            hechizoNodo = hechizoNodo.getSig();
        } while (hechizoNodo != lsch.getP());

        return 0;
    }

    
    // f.
    public static void eliminarIngredientesCostosos(LS_NormalIngredientesMagicos lsnim, double maxCosto) {
        NodoIngredientesMagicos nodo = lsnim.getP();
        NodoIngredientesMagicos anterior = null;

        while (nodo != null) {
            IngredientesMagicos ingrediente = nodo.getQ();
            if (ingrediente.getCosto() > maxCosto) {
                if (anterior == null) {
                    lsnim.setP(nodo.getSig());
                } else {
                    anterior.setSig(nodo.getSig());
                }
            } else {
                anterior = nodo;
            }
            nodo = nodo.getSig();
        }

        System.out.println("Lista de ingredientes después de eliminar los costosos:");
        lsnim.mostrar();
    }
}
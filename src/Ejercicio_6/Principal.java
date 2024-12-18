package Ejercicio_6;

public class Principal {

	public static void main(String[] args) {
		LS_NormalIdiomas lsni = new LS_NormalIdiomas();
		lsni.adiFinal("Aleman", 15000);
		lsni.adiFinal("Frances", 70050);
		lsni.adiFinal("Portugues", 10020);
		lsni.adiFinal("Castellano", 10500);
		lsni.adiFinal("Ingles", 90100);
		lsni.adiFinal("Japones", 20000);
		lsni.adiFinal("Ruso", 13000);
		lsni.adiFinal("Italiano", 30000);
		lsni.adiFinal("Arabe", 80100);
		lsni.adiFinal("Sueco", 10350);
		System.out.println("LISTAS DE IDIOMAS Y HABLANTES");
		lsni.mostrar();
		
		LS_CircularPaises lscp = new LS_CircularPaises();
		lscp.adiFinal("España", "Castellano");
		lscp.adiFinal("Brasil", "Portugues");
		lscp.adiFinal("Francia", "Frances");
		lscp.adiFinal("Canada", "Ingles");
		lscp.adiFinal("India", "Hindi");
		lscp.adiFinal("China", "Chino Mandarin");
		lscp.adiFinal("Japon", "Japones");
		lscp.adiFinal("Rusia", "Ruso");
		lscp.adiFinal("Italia", "Italiano");
		lscp.adiFinal("Alemania", "Aleman");
		lscp.adiFinal("Inglaterra", "Ingles");
		System.out.println("LISTA DE PAISES E IDIOMA-OFICIAL");
		lscp.mostrar();
		
		System.out.println("\na) Mostrar los paises que tienen como idioma oficial la lengua");
		System.out.println("     i-esima de la listas");
		mostrarPaisesConIdioma(lsni, lscp, 3);
		
		System.out.println("\nb) Mostrar cual idioma es el mas hablado entre todos los paises");
		String idiomaMasHablado = obtenerIdiomaMasHablado(lsni);
        System.out.println("Idioma más hablado: " + idiomaMasHablado);
        
		System.out.println("\nc) Contar cuantos paises hablan el idioma X y el numero de hablantes");
		contarPaisesQueHablanIdioma(lscp, lsni, "Ingles");
		
		System.out.println("\nd) Verificar si el idioma que se habla en la mayor parte de los paises");
		System.out.println("     es el mismo que tiene mayor numero de hablantes");
        verificarIdiomaMasHabladoYPaises(lsni, lscp);
	}
	// a.
    public static void mostrarPaisesConIdioma(LS_NormalIdiomas lsni, LS_CircularPaises lscp, int i) {
        NodoIdiomas nodoIdioma = lsni.getP();
        int indice = 1;
        while (nodoIdioma != null && indice < i) {
            nodoIdioma = nodoIdioma.getSig();
            indice++;
        }
        if (nodoIdioma == null) {
            System.out.println("Índice fuera de rango.");
            return;
        }
        String idiomaIesimo = nodoIdioma.getIdioma();
        NodoPaises nodoPais = lscp.getP();
        boolean encontrado = false;
        do {
            if (nodoPais.getIdiomaOficial().equals(idiomaIesimo)) {
                System.out.println("País: " + nodoPais.getPais());
                encontrado = true;
            }
            nodoPais = nodoPais.getSig();
        } while (nodoPais != lscp.getP());
        if (!encontrado) {
            System.out.println("No se encontraron países con el idioma " + idiomaIesimo);
        }
    }

    // b.
    public static String obtenerIdiomaMasHablado(LS_NormalIdiomas lsni) {
        NodoIdiomas nodoIdioma = lsni.getP();
        String idiomaMasHablado = null;
        int maxHablantes = 0;
        while (nodoIdioma != null) {
            if (nodoIdioma.getNroHablantes() > maxHablantes) {
                maxHablantes = nodoIdioma.getNroHablantes();
                idiomaMasHablado = nodoIdioma.getIdioma();
            }
            nodoIdioma = nodoIdioma.getSig();
        }
        return idiomaMasHablado;
    }

    // c.
    public static void contarPaisesQueHablanIdioma(LS_CircularPaises lscp, LS_NormalIdiomas lsni, String idioma) {
        NodoPaises nodoPais = lscp.getP();
        int contarPaises = 0;
        int nroHablantes = 0;
        do {
            if (nodoPais.getIdiomaOficial().equals(idioma)) {
                contarPaises++;
            }
            nodoPais = nodoPais.getSig();
        } while (nodoPais != lscp.getP());
  
        NodoIdiomas nodoIdioma = lsni.getP();
        while (nodoIdioma != null) {
            if (nodoIdioma.getIdioma().equals(idioma)) {
                nroHablantes = nodoIdioma.getNroHablantes();
                break;
            }
            nodoIdioma = nodoIdioma.getSig();
        }
        System.out.println("Idioma: " + idioma);
        System.out.println("Número de países: " + contarPaises);
        System.out.println("Número de hablantes: " + nroHablantes);
    }

    // d.
    public static void verificarIdiomaMasHabladoYPaises(LS_NormalIdiomas lsni, LS_CircularPaises lscp) {
        String idiomaMasHablado = obtenerIdiomaMasHablado(lsni);
        
        NodoPaises nodoPais = lscp.getP();
        String idiomaMasComun = null;
        int maxContador = 0;
        
        NodoIdiomas nodoIdioma = lsni.getP();
        while (nodoIdioma != null) {
            int contador = 0;
            nodoPais = lscp.getP();
            do {
                if (nodoPais.getIdiomaOficial().equals(nodoIdioma.getIdioma())) {
                    contador++;
                }
                nodoPais = nodoPais.getSig();
            } while (nodoPais != lscp.getP());
            
            if (contador > maxContador) {
                maxContador = contador;
                idiomaMasComun = nodoIdioma.getIdioma();
            }
            
            nodoIdioma = nodoIdioma.getSig();
        }
        
        System.out.println("Idioma más hablado por número de hablantes: " + idiomaMasHablado);
        System.out.println("Idioma más hablado por países: " + idiomaMasComun);
        if (idiomaMasHablado.equals(idiomaMasComun)) {
            System.out.println("El idioma más hablado es el mismo en número de hablantes y cantidad de países.");
        } else {
            System.out.println("El idioma más hablado no coincide con el idioma más común en países.");
        }
    }
}
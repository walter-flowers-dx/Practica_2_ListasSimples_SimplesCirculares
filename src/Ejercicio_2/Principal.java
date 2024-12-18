package Ejercicio_2;

public class Principal {

    public static void main(String[] args) {
        LS_NormalPeliculas lsnp = new LS_NormalPeliculas();
        Peliculas p1 = new Peliculas("Inception", "Christopher Nolan", 148);
        Peliculas p2 = new Peliculas("The Dark Knight", "Christopher Nolan", 152);
        Peliculas p3 = new Peliculas("Pulp Fiction", "Quentin Tarantino", 154);
        Peliculas p4 = new Peliculas("Django Unchained", "Quentin Tarantino", 165);
        Peliculas p5 = new Peliculas("Interstellar", "Christopher Nolan", 169);
        Peliculas p6 = new Peliculas("Schindler's List", "Steven Spielberg", 195);
        Peliculas p7 = new Peliculas("Jaws", "Steven Spielberg", 124);
        Peliculas p8 = new Peliculas("Jurassic Park", "Steven Spielberg", 127);
        Peliculas p9 = new Peliculas("E.T.", "Steven Spielberg", 115);
        Peliculas p10 = new Peliculas("The Hateful Eight", "Quentin Tarantino", 187);

        lsnp.adiFinal(p1);
        lsnp.adiFinal(p2);
        lsnp.adiFinal(p3);
        lsnp.adiFinal(p4);
        lsnp.adiFinal(p5);
        lsnp.adiFinal(p6);
        lsnp.adiFinal(p7);
        lsnp.adiFinal(p8);
        lsnp.adiFinal(p9);
        lsnp.adiFinal(p10);

        lsnp.mostrar();

        System.out.println("\na) Agrupar las películas por el director que las dirigió:");
        agruparPorDirector(lsnp);

        System.out.println("\nb) Mostrar la penúltima película dirigida por el director 'Christopher Nolan':");
        mostrarPenultimaPeliculaPorDirector(lsnp, "Christopher Nolan");

        System.out.println("\nc) Contar las películas que tienen una duración mayor a 120 minutos:");
        System.out.println("Cantidad de películas con duración mayor a 120 minutos: " + contarPeliculasMayor120(lsnp));
    }
    // a.
    public static void agruparPorDirector(LS_NormalPeliculas lista) {
        NodoPeliculas actual = lista.getP();
        String[] directoresMostrados = new String[lista.nroNodos()];
        int index = 0;
        
        while (actual != null) {
            String director = actual.getQ().getDirector();
            boolean yaMostrado = false;
            
            for (int i = 0; i < index; i++) {
                if (directoresMostrados[i].equals(director)) {
                    yaMostrado = true;
                    break;
                }
            }
            if (!yaMostrado) {
                System.out.println("Director: " + director);
                NodoPeliculas temp = lista.getP();
                while (temp != null) {
                    if (temp.getQ().getDirector().equals(director)) {
                        System.out.println(" - " + temp.getQ().getTitulo());
                    }
                    temp = temp.getSig();
                }
                System.out.println();
                directoresMostrados[index++] = director;
            }
            
            actual = actual.getSig();
        }
    }
    
    // b.
    public static void mostrarPenultimaPeliculaPorDirector(LS_NormalPeliculas lista, String director) {
        NodoPeliculas actual = lista.getP();
        NodoPeliculas penultima = null, ultima = null;
        
        while (actual != null) {
            if (actual.getQ().getDirector().equals(director)) {
                penultima = ultima;
                ultima = actual;
            }
            actual = actual.getSig();
        }
        
        if (penultima != null) {
            System.out.println("Penúltima película de " + director + ": " + penultima.getQ().getTitulo());
        } else {
            System.out.println("No se encontró la penúltima película para el director " + director);
        }
    }
    
    // c.
    public static int contarPeliculasMayor120(LS_NormalPeliculas lista) {
        NodoPeliculas actual = lista.getP();
        int contador = 0;
        
        while (actual != null) {
            if (actual.getQ().getDuracion() > 120) {
                contador++;
            }
            actual = actual.getSig();
        }
        
        return contador;
    }
}

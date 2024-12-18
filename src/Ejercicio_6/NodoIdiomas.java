package Ejercicio_6;

public class NodoIdiomas {
	private String idioma;
    private int nroHablantes;  
    private NodoIdiomas sig;
    
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	public int getNroHablantes() {
		return nroHablantes;
	}
	public void setNroHablantes(int nroHablantes) {
		this.nroHablantes = nroHablantes;
	}
	public NodoIdiomas getSig() {
		return sig;
	}
	public void setSig(NodoIdiomas sig) {
		this.sig = sig;
	} 
    
    
    
}
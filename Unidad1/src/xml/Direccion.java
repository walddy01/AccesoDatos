package xml;

public class Direccion {

	String nombreVia;
	int numero;
	String poblacion;
	int codPostal;
	
	public Direccion() {}

	public Direccion(String nombreVia, int numero, String poblacion, int codPostal) {
		super();
		this.nombreVia = nombreVia;
		this.numero = numero;
		this.poblacion = poblacion;
		this.codPostal = codPostal;
	}

	public String getNombreVia() {
		return nombreVia;
	}

	public void setNombreVia(String nombreVia) {
		this.nombreVia = nombreVia;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public int getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(int codPostal) {
		this.codPostal = codPostal;
	}

	@Override
	public String toString() {
		return "Direccion [nombreVia=" + nombreVia + ", numero=" + numero + ", poblacion=" + poblacion + ", codPostal="
				+ codPostal + "]";
	}
	
	
}

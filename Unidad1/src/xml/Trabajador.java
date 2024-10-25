package xml;

public class Trabajador {

	String nif;
	String nombre;
	String cargo;
	
	public Trabajador() {}

	public Trabajador(String nif, String nombre, String cargo) {
		super();
		this.nif = nif;
		this.nombre = nombre;
		this.cargo = cargo;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	@Override
	public String toString() {
		return "Trabajador [nif=" + nif + ", nombre=" + nombre + ", cargo=" + cargo + "]";
	}
	
	
}

package xml;

import java.util.ArrayList;

public class Empresa {

	String nie;
	String nombre;
	Direccion direccion;
	ArrayList<Trabajador> trabajador = new ArrayList<Trabajador>();
	
	public Empresa() {}
	
	public Empresa(String nie, String nombre, Direccion direccion, ArrayList<Trabajador> trabajador) {
		super();
		this.nie = nie;
		this.nombre = nombre;
		this.direccion = direccion;
		this.trabajador = trabajador;
	}
	
	public String getNie() {
		return nie;
	}

	public void setNie(String nie) {
		this.nie = nie;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public ArrayList<Trabajador> getTrabajador() {
		return trabajador;
	}

	public void setTrabajador(ArrayList<Trabajador> trabajador) {
		this.trabajador = trabajador;
	}

	@Override
	public String toString() {
		return "Empresa [nie=" + nie + ", nombre=" + nombre + ", direccion=" + direccion + ", trabajador=" + trabajador
				+ "]";
	}
	
	
	
	
}

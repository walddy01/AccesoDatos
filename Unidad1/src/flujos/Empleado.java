package flujos;

import java.io.Serializable;

public class Empleado implements Serializable {

	private String dni;
	private String nombre;
	private double sueldo;
	
	public Empleado() {
		
	}
	
	public Empleado(String dni, String nombre, double sueldo) {
		this.dni = dni;
		this.nombre = nombre;
		this.sueldo = sueldo;
	}
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getSueldo() {
		return sueldo;
	}
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	@Override
	public String toString() {
		//return "Empleado [dni=" + dni + ", nombre=" + nombre + ", sueldo=" + sueldo + "]";
		return "DNI: " + dni + "\nNombre: " + nombre + "\nSueldo: " + sueldo + "\n";
	}
	

}

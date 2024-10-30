package ejerciciosRepaso;

import java.io.Serializable;

public class Perro implements Serializable{
	
	private String nombre;
	private String raza;
	private int edad;
	private float peso;
	private String estadoSalud;
	private String descripcion;
	
	public Perro() {}
	
	public Perro(String nombre, String raza, int edad, float peso, String estadoSalud, String descripcion) {
		this.nombre = nombre;
		this.raza = raza;
		this.edad = edad;
		this.peso = peso;
		this.estadoSalud = estadoSalud;
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public String getEstadoSalud() {
		return estadoSalud;
	}

	public void setEstadoSalud(String estadoSalud) {
		this.estadoSalud = estadoSalud;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Perro [nombre=" + nombre + ", raza=" + raza + ", edad=" + edad + ", peso=" + peso + ", estadoSalud="
				+ estadoSalud + ", descripcion=" + descripcion + "]";
	}
	
	
	
	
	
	
}

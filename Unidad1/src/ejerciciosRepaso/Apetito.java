package ejerciciosRepaso;

public class Apetito {
	
	private String nombre;
	private int edad;
	private float peso;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	
	@Override
	public String toString() {
		return "Apetito [nombre=" + nombre + ", edad=" + edad + ", peso=" + peso + "]";
	}
	
	
	
	
}

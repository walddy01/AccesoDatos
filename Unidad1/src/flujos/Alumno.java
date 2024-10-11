package flujos;

public class Alumno {

	int expediente;
	String nombre;
	int nota;
	
	public Alumno() {
		
	}
	
	public Alumno(int expediente, String nombre, int nota) {
		this.expediente = expediente;
		this.nombre = nombre;
		this.nota = nota;
	}
	
	public Alumno(int expediente, String nombre) {
		this.expediente = expediente;
		this.nombre = nombre;
	}

	public int getExpediente() {
		return expediente;
	}

	public void setExpediente(int expediente) {
		this.expediente = expediente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Expediente" + expediente + "\nNombre: " + nombre + "\nNota: " + nota;
	}
	
	
	
}

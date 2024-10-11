package flujos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Ejercicio29 {

	static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		

		int select = -1;

		do {
			System.out.println("------------------------------");
			System.out.println("| 1. Añadir Alumno.          |");
			System.out.println("| 2. Mostrar Alumnos.        |");
			System.out.println("| 3. Poner Nota.             |");
			System.out.println("| 4. Mostrar estadisticas.   |");
			System.out.println("| 5. Borrar Alumno.          |");
			System.out.println("| 0. Salir.                  |");
			System.out.println("------------------------------");
			System.out.print("¿Qué acción deseas realizar? ");
			select = Integer.parseInt(teclado.nextLine());
			
			switch (select) {
			case 1:
				addAlumno();
				break;
			case 2:
				mostrarAlumnos();
				break;
			case 3:
				ponerNota();
				break;
			case 4:
				mostrarEstadisticas();
				break;
			case 5:
				borrarAlumnos();
				break;
			default:
				if (select != 0) {
					select = -1;
				}
				break;
			}
		} while (select != 0);
		
		
	}
	
	public static void addAlumno() {
		System.out.println("Añadir Alumno.");
		
		System.out.print("Introduce nº expediente: ");
		int expediente = Integer.parseInt(teclado.nextLine());
		System.out.print("Introduce nombre: ");
		String nombre = teclado.nextLine();
		
		Alumno alumno = new Alumno(expediente, nombre);
		
		ObjectOutputStream fichero;
		
		try {
			fichero = new ObjectOutputStream(new FileOutputStream("alumnos.dat"));
			fichero.writeObject(alumno);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void mostrarAlumnos() {
		ObjectInputStream fichero;
		
		try {
			while(true) {
				fichero = new ObjectInputStream(new FileInputStream("alumnos.dat"));
				System.out.println(fichero.readObject()); 
			}
		} catch (Exception e) {
			System.out.println("a");
		}
	}
	
	public static void ponerNota() {
		System.out.println("Poner Nota.");
	}
	
	public static void mostrarEstadisticas() {
		System.out.println("Mostrar Estadisticas.");
	}
	
	public static void borrarAlumnos() {
		System.out.println("Borrar Alumno.");
	}

}

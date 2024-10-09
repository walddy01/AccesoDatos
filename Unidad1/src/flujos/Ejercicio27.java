package flujos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Ejercicio27 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		int select = -1;
		
		do {
			System.out.println("--------------------------------");
			System.out.println("| 1. Dar de alta empleados.    |");
			System.out.println("| 2. Buscar empleados.         |");
			System.out.println("| 3. Listar empleados.         |");
			System.out.println("| 4. Borrar empleado.          |");
			System.out.println("| 0. Salir.                    |");
			System.out.println("--------------------------------");
			System.out.print("¿Qué acción deseas realizar? ");
			select = Integer.parseInt(teclado.nextLine());
			
			switch (select) {
			case 1:
				darAltaEmpleado();
				break;
			case 2:
				buscarEmpleado();
				break;
			case 3:
				listarEmpleados();
				break;
			case 4:
				borrarEmpleado();
				break;

			default:
				if (select != 0) {
					System.out.println("Opción no valida.");
					select = -1;
				}
				break;
			}
			
		} while (select != 0);
		

		teclado.close();
	}
	
	public static void darAltaEmpleado() {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Introduce el DNI: ");
		String dni = teclado.nextLine();
		System.out.print("Introduce el nombre: ");
		String nombre = teclado.nextLine();
		System.out.print("Introduce el sueldo: ");
		double sueldo = Double.parseDouble(teclado.nextLine());
		
		Empleado empleado = new Empleado(dni, nombre, sueldo);

		ObjectOutputStream fichero;

		File f = new File("empleados.dat");

		try {
			if (f.exists()) {
				fichero = new MiObjectOutputStream(new FileOutputStream("empleados.dat", true));
			} else {
				fichero = new ObjectOutputStream(new FileOutputStream("empleados.dat", true));
			}
			fichero.writeObject(empleado);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void buscarEmpleado() {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Introduce el DNI del empleado: ");
		String dni = teclado.nextLine();
		
		boolean encontrado = false;
		
		Empleado empleado;
		ObjectInputStream fichero;
		
		try {
			
			fichero = new ObjectInputStream(new FileInputStream("empleados.dat"));
			while (true) {
				empleado = (Empleado) fichero.readObject();
				
				if (empleado.getDni().equals(dni)) {
					System.out.println(empleado);
					encontrado = true;
				}
			}
			
		} catch (Exception e) {
			if (!encontrado) {
				System.out.println("No hay ningún empleado con el dni " + dni + ".");
			}
		}
	}

	public static void listarEmpleados() {
		Empleado empleado;
		ObjectInputStream fichero;
		
		try {
			
			fichero = new ObjectInputStream(new FileInputStream("empleados.dat"));
			while (true) {
				empleado = (Empleado) fichero.readObject();
				System.out.println(empleado);
			}
			
		} catch (Exception e) {
			
		}
	}

	public static void borrarEmpleado() {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Introduce el DNI del empleado: ");
		String dni = teclado.nextLine();
		
		
		File original = new File("empleados.dat");
		File tmp = new File("tmp.dat");
		
		Empleado empleado;
		ObjectInputStream fichero;
		ObjectOutputStream temporal;
		
		try {
			
			fichero = new ObjectInputStream(new FileInputStream("empleados.dat"));
			temporal = new ObjectOutputStream(new FileOutputStream("tmp.dat"));
			
			while (true) {
				empleado = (Empleado) fichero.readObject();
				if (!empleado.getDni().equals(dni)) {
					temporal.writeObject(empleado);
				}
			}
			
		} catch (Exception e) {
			original.delete();
			tmp.renameTo(original);
		}
		
	}
}

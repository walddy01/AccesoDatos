package flujos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Scanner;

public class Ejercicio28 {
	
	static HashSet<Empleado> listaEmpleados = new HashSet<Empleado>();

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		File f = new File("empleados2.dat");
		
		if (f.exists()) {
			ObjectInputStream fichero;

			try {

				fichero = new ObjectInputStream(new FileInputStream("empleados2.dat"));
				while (true) {
					listaEmpleados = (HashSet<Empleado>) fichero.readObject();
					//System.out.println(listaEmpleados);
				}

			} catch (Exception e) {

			}
			
			for(Empleado i: listaEmpleados) {
				System.out.println(i.getDni());
			}
		}
		
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

		
		
		listaEmpleados.add(new Empleado(dni, nombre, sueldo));
		
		for (Empleado e: listaEmpleados) {
			System.out.println(e.getDni());
		}
		
		ObjectOutputStream fichero;
		
		File f = new File("empleados2.dat");
		
		try {
			fichero = new ObjectOutputStream(new FileOutputStream("empleados2.dat"));
			fichero.writeObject(listaEmpleados);
			fichero.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	public static void buscarEmpleado() {
		Scanner teclado = new Scanner(System.in);

		System.out.print("Introduce el DNI del empleado: ");
		String dni = teclado.nextLine();

		boolean encontrado = false;

		for (Empleado i: listaEmpleados) {
			if (i.getDni().equals(dni)) {
				System.out.println(i);
				encontrado = true;
			}
		}
		
		if (!encontrado) {
			System.out.println("No se ha encontrado el empleado.");
		}
	}

	public static void listarEmpleados() {
		for(Empleado i: listaEmpleados) {
			System.out.println(i);
		}
	}

	public static void borrarEmpleado() {
		Scanner teclado = new Scanner(System.in);

		System.out.print("Introduce el DNI del empleado: ");
		String dni = teclado.nextLine();

		boolean encontrado = false;

		for (Empleado i: listaEmpleados) {
			if (i.getDni().equals(dni)) {
				listaEmpleados.remove(i);
				encontrado = true;
			}
		}
		
		if (!encontrado) {
			System.out.println("No se ha encontrado el empleado.");
		} else {
			ObjectOutputStream fichero;
			
			File f = new File("empleados2.dat");
			f.delete();
			try {
				fichero = new ObjectOutputStream(new FileOutputStream("empleados2.dat"));
				fichero.writeObject(listaEmpleados);
				fichero.close();
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}
}

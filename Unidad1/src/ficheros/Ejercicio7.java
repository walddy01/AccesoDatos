package ficheros;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;

public class Ejercicio7 {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		HashSet<String> nombres = new HashSet<String>();
		
		String nombre = "";
		
		System.out.println("Introduce nombres de ficheros (para salir introduce 'salir'.)");
		do {
			System.out.print("Nombre de fichero: ");
			nombre = teclado.nextLine();
			
			if (!nombre.equals("salir")) {
				nombres.add(nombre);
				
				System.out.println("Fichero añadido.");
			}
			
		} while (!nombre.equals("salir"));

		
		try {
			for (String i: nombres) {
				System.out.println("---------------------------------");
				System.out.println(i);
				System.out.println("---------------------------------");
				
				File fichero = new File(i);
				
				if (fichero.exists()) {
					System.out.println("Fichero existe.");
					System.out.printf("Fichero %s | Carpeta %s \n", fichero.isFile(), fichero.isDirectory());
					System.out.println("Nombre del fichero: " + fichero.getAbsolutePath());
					// Permisos de lectura, escritura y ejecución
					if (fichero.canRead()) {
						System.out.print("r");
					}
					if (fichero.canWrite()) {
						System.out.print("w");
					}
					if (fichero.canExecute()) {
						System.out.print("x");
					}
					System.out.println("\nTamaño: " + fichero.length());
				} else {
					System.out.println("Fichero no existe.");
				}
			}
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error: " + e.getMessage());
		}
		
	}

}

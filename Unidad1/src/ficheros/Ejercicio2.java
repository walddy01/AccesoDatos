package ficheros;

import java.io.File;
import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Introduce una ruta:");
		String ruta = teclado.nextLine();
		
		File fichero = new File(ruta);
		
		if (fichero.exists()) {
			
			if (fichero.isFile()) {
				System.out.println("Es un fichero.");
			} else {
				System.out.println("Es un directorio.");
			}
			
			System.out.println("El tamaño del fichero es " + fichero.length());
		} else {
			System.out.println("No existe.");
		}
		

	}

}

package flujos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio15 {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);

		System.out.print("Introduce el nombre del fichero: ");
		String nombreFichero = teclado.nextLine();

		int numPersonas = 0;

		try {
			BufferedReader fichero = new BufferedReader(new FileReader(nombreFichero));
			String linea;
			// Bucle de lectura del fichero
			System.out.println("Contenido del fichero :");
			while ((linea = fichero.readLine()) != null) {
//				System.out.println(linea);
				String[] personas = linea.split(";");
				System.out.println("Nombre: " + personas[0] + ", Apellidos: " + personas[1] + ", DNI: " + personas[2]);
				numPersonas++;
			}

			System.out.println("Número total de personas en el fichero: " + numPersonas);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}

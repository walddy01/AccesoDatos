package flujos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio17 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

//		System.out.print("Introduce el nombre del fichero: ");
//		String nombreFichero = teclado.nextLine();
		String nombreFichero = "prueba.txt";
		File fOrigen = new File(nombreFichero);

		int numLinea = 1;

		// Mostrar fichero original
		mostrarFichero(nombreFichero, numLinea);

		// Linea a borrar
		System.out.println("¿Qué linea desea borrar?");
		int lineaBorrar = Integer.parseInt(teclado.nextLine());
		int lineaActual = 1;

		// Fichero temporal
		File ftmp = new File("tmp.txt");
		try {
			BufferedWriter tmp = new BufferedWriter(new FileWriter("tmp.txt"));

			BufferedReader fichero = new BufferedReader(new FileReader(nombreFichero));
			String linea;
			while ((linea = fichero.readLine()) != null) {

				if (lineaBorrar != lineaActual) {
					tmp.write(linea + "\n");
				} else {
					System.out.println("Los nuevos datos: ");
					String nuevaLinea = teclado.nextLine();
					tmp.write(nuevaLinea + "\n");
				}
				lineaActual++;
			}
			tmp.close();
			fichero.close();

			// Pasar datos desde tmp.txt a original
			fOrigen.delete();
			ftmp.renameTo(fOrigen);

			mostrarFichero(nombreFichero, numLinea);

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void mostrarFichero(String nombreFichero, int numLinea) {
		try {
			BufferedReader fichero = new BufferedReader(new FileReader(nombreFichero));
			String linea;

			while ((linea = fichero.readLine()) != null) {
				System.out.println(numLinea + ". " + linea);
				numLinea++;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}

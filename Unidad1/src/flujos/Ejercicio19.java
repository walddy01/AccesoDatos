package flujos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio19 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

//		System.out.print("Introduce el nombre del fichero: ");
//		String nombreFichero = teclado.nextLine();
		String nombreFichero = "cotizacion.txt";
		File fOrigen = new File(nombreFichero);

		int numLinea = 1;

		// Mostrar fichero original
		//mostrarFichero(nombreFichero, numLinea);

		// Linea a borrar
//		System.out.println("¿Qué linea desea borrar?");
//		int lineaBorrar = Integer.parseInt(teclado.nextLine());
		int lineaActual = 1;
		int contador = 0;
		String linea2 = "";

		// Fichero temporal
		File ftmp = new File("cotizacion2.txt");
		try {
			BufferedWriter tmp = new BufferedWriter(new FileWriter("cotizacion2.txt"));

			BufferedReader fichero = new BufferedReader(new FileReader(nombreFichero));
			String linea;
			while ((linea = fichero.readLine()) != null) {

				
//				System.out.println(lineaActual);
				if (lineaActual == 2) {
					System.out.println(linea);
					linea2 = linea;
					contador++;
				} else if (lineaActual == 3) {
					System.out.println(linea);
					linea2 += " " + linea + "\n";
					contador++;
				} else if (lineaActual == 5) {
					if (contador == 2) {
						tmp.write(linea2);
						contador = 0;
					}
					lineaActual = 0;
				}
				lineaActual++;
				
//				if (lineaBorrar != lineaActual) {
//					tmp.write(linea + "\n");
//				} else {
//					System.out.println("Los nuevos datos: ");
//					String nuevaLinea = teclado.nextLine();
//					tmp.write(nuevaLinea + "\n");
//				}
			}
			tmp.close();
			fichero.close();

			// Pasar datos desde tmp.txt a original
			//fOrigen.delete();
			//ftmp.renameTo(fOrigen);

			//mostrarFichero(nombreFichero, numLinea);

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

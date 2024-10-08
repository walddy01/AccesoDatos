package flujos;

import java.io.BufferedReader;
import java.io.FileReader;

public class EjemploBufferedReader {

	public static void main(String[] args) {
		// Declaramos el stream de lectura
		BufferedReader fichero;
		// Si el fichero no existe se lanza una excepción que hay que capturar
		try {
			// Abrimos el fichero
			fichero = new BufferedReader(new FileReader("nombre.txt"));
			// Variable para ir leyendo los caracteres del fichero
			String linea;
			// Bucle de lectura del fichero
			System.out.println("Contenido del fichero :");
			while ((linea = fichero.readLine()) != null) {
				System.out.println(linea);
			}
		} catch (Exception e) {
			System.out.println("Error al abrir el fichero");
			e.getMessage();
			e.printStackTrace();
		} finally {
//			fichero.close();
		}

	}

}

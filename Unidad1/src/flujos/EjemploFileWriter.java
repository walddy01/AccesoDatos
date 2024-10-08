package flujos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EjemploFileWriter {

	public static void main(String[] args) {
		// Validamos si existe el fichero
		String nombreFichero = "fichero0.txt";
		File fichero = new File(nombreFichero);
		if (fichero.exists())
			System.out.println("El fichero " + nombreFichero + " ya existe");
		else {
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(nombreFichero));
				// Escribimos 10 filas
				for (int x = 0; x < 10; x++) {
					bw.write("Fila numero " + x + "\n");
				}
				bw.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}

}

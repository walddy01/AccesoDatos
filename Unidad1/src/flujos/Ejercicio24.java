package flujos;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio24 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

        try {
            // Solicitamos la ruta del fichero
            System.out.println("Introduce la ruta del fichero:");
            String rutaFichero = teclado.nextLine();

            // Abrimos el fichero binario para lectura
            DataInputStream fichero = new DataInputStream(new FileInputStream(new File(rutaFichero)));

            // Leemos los registros del fichero y los mostramos
            	String nombre = "";
                int expediente = fichero.readInt();
                double nota = fichero.readDouble();
                char letra = fichero.readChar();
                while (letra != '\n') {
                	nombre += letra;
                	letra = fichero.readChar();
                }
               

               System.out.print("Expediente: " + expediente);
               System.out.print("\t Nota: " + nota );
               System.out.print("\t Nombre: " + nombre);
            
            // Cerramos el fichero
            fichero.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error: No se encontró el fichero.");
            e.printStackTrace();
        } catch (IOException e1) {
            System.out.println("Error al leer el fichero.");
            e1.printStackTrace();
        }

	}

}

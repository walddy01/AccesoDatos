package flujos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Ejercicio12 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Introduce el nombre del fichero: ");
		String nombreFichero = teclado.nextLine();
		
		File fichero = new File(nombreFichero);
		
		if (!fichero.exists()) {	
			try {
				fichero.createNewFile();
				System.out.println("El fichero no existia, se ha creado correctamente.");
				BufferedWriter bw = new BufferedWriter(new FileWriter(nombreFichero));
				int i = 0;
				do {
					System.out.print("Nombre: ");
					String nombre = teclado.nextLine();
					
					System.out.print("Apellidos: ");
					String apellidos = teclado.nextLine();
					
					System.out.print("DNI: ");
					String dni = teclado.nextLine();
					
					bw.write(nombre+";"+apellidos+";"+dni+"\n");
					i++;
				} while (i < 3);
				
				bw.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else {
			System.out.println("El fichero existe.");
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(nombreFichero));
				int i = 0;
				do {
					System.out.print("Nombre: ");
					String nombre = teclado.nextLine();
					
					System.out.print("Apellidos: ");
					String apellidos = teclado.nextLine();
					
					System.out.print("DNI: ");
					String dni = teclado.nextLine();
					
					bw.write(nombre+";"+apellidos+";"+dni+"\n");
					i++;
				} while (i < 3);
				
				bw.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

}

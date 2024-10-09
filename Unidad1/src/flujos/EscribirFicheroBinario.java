package flujos;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class EscribirFicheroBinario {
public static void main(String[] args) {
	Scanner teclado = new Scanner(System.in);
	try {
		//Abrimos el fichero binario para escritura
		DataOutputStream fichero = new DataOutputStream(new FileOutputStream(new File("alumno23.dat")));
		// Pedimos los datos
		
		for (int i = 0; i < 2; i++) {
			
			System.out.println("Escribe el expediente (int): ");
			int expediente = Integer.parseInt(teclado.nextLine());
			System.out.println("Escribe la nota (double): ");
			double nota = Double.parseDouble(teclado.nextLine());
			System.out.println("Introduce el nombre (string): ");
			String nombre = teclado.nextLine();
			// Escribimos en el fichero binario
			fichero.writeInt(expediente);
			fichero.writeDouble(nota);
			fichero.writeChars(nombre+"\n");
		}
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e1) {
		e1.printStackTrace();
	}
 }
}
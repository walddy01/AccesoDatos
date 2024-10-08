package flujos;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class EscribirFicheroBinario {
public static void main(String[] args) {
	//Abrimos el fichero binario para escritura
	try {
		DataOutputStream dos = new DataOutputStream (new FileOutputStream (new File("ficheroBinario.dat")));
	
		 //Escribimos los datos
		 dos.writeByte(97);
		 dos.writeByte(98);
		 dos.writeByte(99);
		 dos.writeByte(100);
		 dos.writeByte(101);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e1) {
		e1.printStackTrace();
	}
 }
}
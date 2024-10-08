package flujos;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ejercicio22 {

	public static void main(String[] args) {
		//Abrimos el fichero binario para escritura
		try {
			DataInputStream dos = new DataInputStream (new FileInputStream (new File("ficheroBinario.dat")));
		
			 //Leemos los datos
			int n = dos.readInt();
			System.out.println(n);
//			 dos.writeByte(97);
//			 dos.writeByte(98);
//			 dos.writeByte(99);
//			 dos.writeByte(100);
//			 dos.writeByte(101);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

}

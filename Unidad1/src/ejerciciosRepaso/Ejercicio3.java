package ejerciciosRepaso;

import java.io.RandomAccessFile;

public class Ejercicio3 {

	public static void main(String[] args) {
		
		try {
			RandomAccessFile archivo = new RandomAccessFile("apetito.dat", "rw");
			archivo.seek(0);
			
			while(true) {
				byte[] nombreBytes = new byte[20];
	            archivo.read(nombreBytes);	
	            String nombre = new String(nombreBytes);
	            nombre = nombre.trim();
	            
	            int edad = archivo.readInt();
	            
	            float peso = archivo.readFloat();
	            
	            System.out.println("La cantidad de comida que debe comer " + nombre + " es " + (edad*peso) + " gramos.");
			}
			
		} catch (Exception e) {
		}

	}

}

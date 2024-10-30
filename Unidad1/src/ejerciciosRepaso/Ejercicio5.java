package ejerciciosRepaso;

import java.io.RandomAccessFile;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Ejercicio5 {
	static ArrayList<Apetito> listaApetito = new  ArrayList<Apetito>();
	static ObjectMapper mapper = new ObjectMapper();
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
	            
	            Apetito a = new Apetito();
	            a.setNombre(nombre);
	            a.setEdad(edad);
	            a.setPeso(peso);
	            
	            listaApetito.add(a);
	            
	            System.out.println("La cantidad de comida que debe comer " + nombre + " es " + (edad*peso) + " gramos.");
			}
			
			
			
		} catch (Exception e) {
		
		} finally {
			for(Apetito a : listaApetito) {
				try {
					mapper.writeValue(System.out, a);
					} catch (Exception e) {
						e.printStackTrace();	
					 }
			}
		}

	}

}

package ficheros;

import java.io.File;
import java.util.Scanner;

public class Ejercicio8 {
	// /home/diurno/eclipse-workspace/Unidad1/
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Introduce la ruta de la carpeta: ");
		String ruta = teclado.nextLine();
		
		File carpeta = new File(ruta);
		
		if (carpeta.isDirectory()) {
			mostrarContenido(carpeta);			
		}
		
		
//		System.out.println(carpeta.getAbsolutePath());
		
	}
	
	public static void mostrarContenido(File c) {
		File[] lista = c.listFiles();
//		int nivel = 0;
//		for (int j = 0; j < nivel; j++) {
//			System.out.print("\t");
//		}
//		nivel++;
		for (File i: lista) {
			
			if (i.isDirectory()) {
				mostrarContenido(i);
			}
			
			if (i.isDirectory()) {
				System.out.println("[D] " + i.getName());			
			} else {
				System.out.println("[F] " + i.getName());				
			}
		}
	}

}

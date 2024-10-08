package ficheros;

import java.io.File;
import java.util.Scanner;
import java.util.TreeSet;

public class Ejercicio10 {
	// /home/diurno/eclipse-workspace/Unidad1/
	public static void main(String[] args) {
		Ejercicio10Archivos archivos = new Ejercicio10Archivos();
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Introduce la ruta del directorio: ");
		String ruta = teclado.nextLine();
		
		File directorio = new File(ruta);
		
		TreeSet<File> ordenados = new TreeSet<File>();
		
		if (directorio.isDirectory()) {
			
			for (File i: directorio.listFiles()) {
				archivos.addArchivo(i);
			}
			
			for (File i: archivos.archivosOrdenados) {
				System.out.println(i.getName() + " " + i.length() + " bytes");
			}
			
		}
	}

}

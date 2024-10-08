package ficheros;

import java.io.File;
import java.util.TreeSet;

public class Ejercicio10Archivos implements Comparable<File>{

	TreeSet<File> archivosOrdenados = new TreeSet<File>();
	
	public static void main(String[] args) {
		

	}

	public int compare(File f1, File f2) {
		
		// Comparar por tamaño de archivo
		int result = Long.compare(f1.length(), f2.length());
		
		if (result == 0) {
			return f1.getName().compareTo(f2.getName());
		}
		return result;
	}
	
	public void addArchivo(File a) {
		archivosOrdenados.add(a);
	}
	
	@Override
	public int compareTo(File o) {
		
		return 0;
	}

}

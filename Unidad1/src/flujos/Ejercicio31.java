package flujos;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Ejercicio31 {

	public static void main(String[] args) throws IOException {
		RandomAccessFile archivo = null;
		char c;
		
		try {
			archivo = new RandomAccessFile("ej25_texto.txt", "rw");
			System.out.println("Tamaño del archivo: " + archivo.length());
			
			while (archivo.getFilePointer() < archivo.length()) {
				c = (char) archivo.readByte();
				if (c=='a' || c=='e' || c=='i' || c=='o' || c=='u') {
					archivo.seek(archivo.getFilePointer()-1);
					archivo.writeByte(Character.toUpperCase(c));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (archivo != null) {
				archivo.close();
			}
		}
	}
}

package ejerciciosRepaso;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Ejercicio2 {

	public static void main(String[] args) {
		
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("perros.dat"));
			
			ArrayList<Perro> listaPerros = new ArrayList<Perro>();
			
			listaPerros = (ArrayList<Perro>) ois.readObject();
			
//			while(true) {
//				Perro p = (Perro) ois.readObject();
//				System.out.println(p.getDescripcion());
//			}
			
			RandomAccessFile fApetito = new RandomAccessFile("apetito.dat", "rw");
			
			for(Perro p : listaPerros) {
				
				while (p.getNombre().length() < 20) {
					p.setNombre(p.getNombre() + " ");
					
				}
				
				fApetito.writeBytes(p.getNombre());
				fApetito.writeInt(p.getEdad());
				fApetito.writeFloat(p.getPeso());
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

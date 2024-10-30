package ejerciciosRepaso;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Ejercicio1 {

	public static void main(String[] args) {
		
		ArrayList<Perro> listaPerros = new ArrayList<Perro>();
		
		try {
			
			BufferedReader fichero = new BufferedReader(new FileReader("perros.txt"));
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("perros.dat")));
			String linea;
			
			
			while((linea = fichero.readLine()) != null) {
				linea = linea.trim();
				String[] separado = linea.split(",");
				listaPerros.add(new Perro(separado[0], separado[1], Integer.parseInt(separado[2]), Float.parseFloat(separado[3]), separado[4], separado[5]));
			}
			
//			for(Perro p : listaPerros) {
//				oos.writeObject(p);
//			}
			
			oos.writeObject(listaPerros);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

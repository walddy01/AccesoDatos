package flujos;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Ejercicio26Leer {

	public static void main(String[] args) {
		
		Empleado empleado1;
		ObjectInputStream fichero;
		
		File f = new File("empleados.dat");
		
		
		try {
			
			fichero = new ObjectInputStream(new FileInputStream("empleados.dat"));
			empleado1 = (Empleado) fichero.readObject();
			System.out.println(empleado1);
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		

	}

}

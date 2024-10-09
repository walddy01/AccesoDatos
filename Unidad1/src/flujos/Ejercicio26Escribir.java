package flujos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Ejercicio26Escribir {

	public static void main(String[] args) {
		
		Empleado empleado1 = new Empleado("12312345A", "Paco", 1000);
		
		ObjectOutputStream fichero;
		
		File f = new File("empleados.dat");
		
		
		try {
			if (f.exists()) {
				fichero = new MiObjectOutputStream(new FileOutputStream("empleados.dat", true));
			} else {
				fichero = new ObjectOutputStream(new FileOutputStream("empleados.dat", true));
			}
			fichero.writeObject(empleado1);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		

	}

}

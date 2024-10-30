package ejerciciosRepaso;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class Ejercicio4 {

	public static void main(String[] args) {
		try {
			
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("perros.dat"));
			
			Perros perros = new Perros();
			perros.setListaPerros((ArrayList<Perro>) ois.readObject());
			
			// Crear contexto JAXB
			JAXBContext jaxbContext = JAXBContext.newInstance(Perros.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			// Configuración opcional para formato legible
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			
			// Convertir objeto a XML y mostrar en consola
			marshaller.marshal(perros, new File("perros.xml"));
			
			ois.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}

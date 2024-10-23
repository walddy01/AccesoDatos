package xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class EjemploJAXBpersonas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Personas miLista = new Personas();

		Persona p1 = new Persona("123312334Y", "Paco", 43);
		Persona p2 = new Persona("231232132J", "Luis", 25);
		Persona p3 = new Persona("896532312B", "Mario", 5);

		miLista.aniadirPersona(p1);
		miLista.aniadirPersona(p2);
		miLista.aniadirPersona(p3);

		miLista.mostrarPersonas();

		System.out.println("...................");
		try {
			// Crear contexto JAXB
			JAXBContext jaxbContext = JAXBContext.newInstance(Personas.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			// Configuración opcional para formato legible
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			// Convertir objeto a XML y mostrar en consola
			marshaller.marshal(miLista, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}

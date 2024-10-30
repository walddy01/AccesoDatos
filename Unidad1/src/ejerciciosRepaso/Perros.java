package ejerciciosRepaso;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Perros {
	ArrayList<Perro> listaPerros;
	
	@XmlElement(name = "perro")
	public ArrayList<Perro> getListaPerros() {
		return listaPerros;
	}

	public void setListaPerros(ArrayList<Perro> listaPerros) {
		this.listaPerros = listaPerros;
	}
	
	
}

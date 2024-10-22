package xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class Ejercicio35 {

	public static void main(String[] args) {
		try {
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
	            
	        File archivoXML = new File("profesores.xml");
	        
	        if (!archivoXML.exists()) {
	        	archivoXML.createNewFile();
	        } else {
	        	Document documento = builder.parse(archivoXML);	        	
	        }
	        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
